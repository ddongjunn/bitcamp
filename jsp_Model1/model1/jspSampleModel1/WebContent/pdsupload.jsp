<%@page import="java.util.Date"%>
<%@page import="pds.PdsDto"%>
<%@page import="pds.PdsDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
//실제 파일 업로드를 실시하는 함수  DIR = 경로 
public String processUploadFile(FileItem fileItem, String newFileName, String dir) throws IOException{
	
	String f = fileItem.getName();
	long sizeInBytes = fileItem.getSize(); //현재 크기 (Byte)
	
	String fileName = "";
	String fpost = "";
	
	//업로드한 파일이 정상일 경우
	if(sizeInBytes > 0){ //	d:\\tmp\\abc.txt 경로를 가정 , d:/tmp/abc.txt
		int idx = f.lastIndexOf("\\"); // \\의 위치를 return
		if(idx == -1){ //못찾은 경우 = d:tmp/abc.txt
			idx = f.lastIndexOf("/");
		}
		fileName = f.substring(idx + 1); //파일 이름 가져오기 //abc.txt
		
		try{
			//File uploadFile = new File(dir, fileName);
			File uploadFile = new File(dir, newFileName); //새로운 파일명
			fileItem.write(uploadFile); //실제로 업로드하는 부분
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	return fileName; //파일이름 return
}
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdsupload.jsp</title>
</head>
<body>

<%
/*
	한글파일의 경우. 파일명이 손실되는 경우가 있다.
	내파일.txt -> 3243242.txt
	
	db에 저장시
	실제 파일명 : 내파일.txt
	변환파일명 : 3243232.txt	
*/

// tomcat 배포
String fupload = application.getRealPath("/upload"); //서버 리부팅시 자료가 사라질 수 있다.
	
// 지정 폴더 저장
//String fupload = "d:\\tmp";

System.out.println("파일 업로드:" + fupload);

String yourTempDir = fupload;

int yourMaxRequestSize = 100 * 1024 * 1024; // 1M byte (최대 전송 사이즈)
int yourMaxMemorySize =  100 * 1024;	//1K Byte

// form field에 데이터(String)
String id = "";
String title = "";
String content = "";

//fild data
String filename = "";
String newFileName = "";

boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if(isMultipart){ //정상처리
	///////////////////////// file
	// FileItem 오브젝트를 생성하는 클래스
	DiskFileItemFactory factory = new DiskFileItemFactory();

	factory.setSizeThreshold(yourMaxMemorySize);
	factory.setRepository(new File(yourTempDir));
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(yourMaxRequestSize);
	
	List<FileItem> items = upload.parseRequest(request); //form 전체가 넘어온다.
	Iterator<FileItem> it = items.iterator(); //it를 통해서 하나씩 꺼낸다?
	
	while(it.hasNext()){
		FileItem item = it.next();
		
		if(item.isFormField()){ //id, title, content의 경우 여기
			if(item.getFieldName().equals("id")){
				id = item.getString("utf-8");		
			}else if(item.getFieldName().equals("title")){
				title = item.getString("utf-8");	
			}else if(item.getFieldName().equals("content")){
				content = item.getString("utf-8");
			}
		
		}else{ // file
			if(item.getFieldName().equals("fileload")){
				
				//확장자명
				String fileName = item.getName(); //abc.txt
				int lastInNum = fileName.lastIndexOf("."); // 마지막 .의 위치 
				String exName = fileName.substring(lastInNum);
				
				//새로운 파일명 셋팅
				newFileName = (new Date().getTime()) + ""; //알아볼수없는 숫자 반환:long 이기 때문에 문자열로 변환
				newFileName = newFileName + exName;
				filename = processUploadFile(item, newFileName, fupload);
			}
		}
	}
	
}else{
	System.out.println("Multipart가 아님");
}

//DB에 Data저장
PdsDao dao = PdsDao.getInstance();
boolean isS = dao.writePds(new PdsDto(id, title, content, filename, newFileName));

if(isS){
%>
	<script>
	alert('파일 업로드 성공!');
	location.href = "pdslist.jsp";
	</script>
	
<%} else { %>
	<script>
	alert('파일 업로드 실패!');
	location.href = "pdswrite.jsp";
	</script>
	
<% } %>
</body>
</html>