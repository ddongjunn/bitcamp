package bit.com.a.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("DownloadView renderMergedOutputModel");
		
		File file = (File) model.get("downloadFile"); //getAttribute와 같다.
		String originalFile = (String) model.get("originalFile");
		int seq = (Integer) model.get("seq");
		
		response.setContentType(this.getContentType());
		response.setContentLength((int)file.length());
		
		System.out.println("originalFile : " + originalFile); //여기까지는 한글이 안깨진다.
		
		//다운로드 받을때 한글명이 깨지기 때문에 설정해주기 (이 설정을 안해주면 한글 파일명이 정상으로 나오지 않는다)
		originalFile = URLEncoder.encode(originalFile, "utf-8");
		
		//다운로드 창이 나오는 부분
		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFile + "\";");
	    response.setHeader("Content-Transfer-Encoding", "binary;");
	    response.setHeader("Content-Length", "" + file.length());
	    response.setHeader("Pragma", "no-cache;"); 
	    response.setHeader("Expires", "-1;");
	    
	    OutputStream out = response.getOutputStream();
	    FileInputStream fi = new FileInputStream(file);
	    
	    //실제 파일이 다운로드되는 부분
	    FileCopyUtils.copy(fi, out);
	    
	    if(fi != null) {
	    	fi.close();
	    }
	}

}
