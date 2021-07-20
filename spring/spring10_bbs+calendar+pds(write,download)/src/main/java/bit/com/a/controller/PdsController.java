package bit.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.dto.PdsDto;
import bit.com.a.service.PdsService;
import bit.com.a.util.PdsUtil;

@Controller
public class PdsController {
	
	@Autowired
	PdsService service;
	
	@RequestMapping(value= "pdslist.do", method = RequestMethod.GET)
	public String pdslist(Model model) {
		model.addAttribute("doc_title","자료실 목록");
		
		List<PdsDto> list = service.getPdsList();
		model.addAttribute("pdslist",list);
		
		return "pdslist.tiles";
	}
	
	@RequestMapping(value="pdswrite.do", method = RequestMethod.GET)
	public String pdswrite(Model model) {
			model.addAttribute("doc_title","자료 올리기");
		return "pdswrite.tiles";
	}
	
	@RequestMapping(value="pdsupload.do", method = RequestMethod.POST)
	public String pdsupload(PdsDto pdsdto, 
			@RequestParam(value = "fileload", required = false)
			MultipartFile fileload,
			HttpServletRequest req){
		//form 필드 = PdsDto
		//fileload는 따로 받아준다.
		
		//filename(원본) 취득
		String filename = fileload.getOriginalFilename();	
		pdsdto.setFilename(filename); //db에 저장하기 위해서 원본 파일명을 넣어준다.
		
		//upload경로 설정
		//server에 저장
		String fupload = req.getServletContext().getRealPath("/upload");
		
		//폴더에 저장할 경우
		//String fupload = "d:\\tmp";
		
		System.out.println("fupload: " +fupload); //확인해보기
		
		//파일명 변경
		String newfilename = PdsUtil.getNewFileName(pdsdto.getFilename());
		pdsdto.setNewfilename(newfilename);
		
		File file = new File(fupload + "/" + newfilename);
		
		//file에 대한 정보를 넣어주면서 바이트 단위로 넣어준다.
		
		try {
			//실제로 업로드 되는 부분
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			//DB에 저장
			service.uploadPds(pdsdto);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/pdslist.do";
	}
	
	@RequestMapping(value = "fileDownload.do", method = { RequestMethod.POST, RequestMethod.GET } )
	public String fileDownload(String newfilename, String filename, int seq, HttpServletRequest req, Model model) {
		
		//추상뷰에서 다운로드 받을수 있도록 만들어 준다.
		
		//upload경로 설정
		//server에 저장 (톰캣은 껏다켰다 하면 파일이 날라 갈 수 있음.)(톰캣은 껏다켰다 하면 파일이 날라 갈 수 있음.)
		String fupload = req.getServletContext().getRealPath("/upload");
		
		//폴더에 저장할 경우 
		//String fupload = "d:\\tmp";
		
		File downloadFile = new File(fupload + "/" + newfilename);
		
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("originalFile", filename);
		model.addAttribute("seq", seq);
		

		return "downloadView";
	}
	
}
