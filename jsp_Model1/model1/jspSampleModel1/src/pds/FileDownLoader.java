package pds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownLoader extends HttpServlet {

	ServletConfig mConfig = null;
	final int BUFFER_SIZE = 8192; //저장사이즈(임시 저장 공간)
	
	@Override //경로 얻어 오기 위해 필요한 것
	public void init(ServletConfig config) throws ServletException {
		mConfig = config; //업로드한 경로를 취득하기 위해서 
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("FileDownLoader doGet");
		
		String newFileName = req.getParameter("newfilename");
		System.out.println("newFileName="+newFileName);
		
		int seq = Integer.parseInt(req.getParameter("seq"));
		
		//download 카운터 증가
		PdsDao dao = PdsDao.getInstance();
		dao.downCount(seq);
		
		String filename = dao.getDto(seq).getFilename();
		System.out.println("fileName="+filename);
		
		BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
		
		//path(경로)
		//tomcat(server)
		String filepath = mConfig.getServletContext().getRealPath("/upload");
		
		//폴더
		//String filepath = "d:\\tmp";
		
		filepath = filepath + "\\" + newFileName;
		System.out.println(filepath);
		
		File f = new File(filepath);
		
		//크롬 브라우저의 설정(한글명 파일 깨짐)
		String fileNameOrg = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
		
		if(f.exists() && f.canRead()) { //파일이 있는지, 읽을 수 있는지.
			
			//다운로드 창 설정
			resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileNameOrg + "\";");  //다운로드 파일명을 넣어줌
			resp.setHeader("Content-Transfer-Encoding", "binary;"); // binary형태로 받겠다.
			resp.setHeader("Content-Length", "" + f.length()); //다운로드 바?
			resp.setHeader("Pragma", "no-cache;"); // 따로 저장을 하지 않겠다.
			resp.setHeader("Expires", "-1;"); // 기한을 정해놓지 않는다.			
		
			//다운로드 후 
			//파일 생성, 기입
			BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(f));
			//생성된 파일 포인터를 잡아서...?
			
			byte buffer[] = new byte[BUFFER_SIZE];
			int read = 0;
			
			while((read = fileInput.read(buffer)) != -1) { //파일 끝 부분까지 
				out.write(buffer, 0, read); //실제 다운로드 부분
			}
			
			fileInput.close();
			out.flush();
		}
	}

}
