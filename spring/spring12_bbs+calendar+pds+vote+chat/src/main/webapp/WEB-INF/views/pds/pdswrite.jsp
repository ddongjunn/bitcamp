<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
1.파일 업로드시 method =  post
2.enctype = "mulitpart/form-data"
 -->					
<form name="frmForm" id="_frmForm" action="pdsupload.do" method="post" enctype="multipart/form-data">

<table class="list_table">
	<colgroup>
		<col width="50">
		<col width="100">
	</colgroup>
	<tr>
		<th>아이디</th>
		<td style="text-align : left">
			<input type="text" name="id" readonly value="${login.id}" size="50">
		</td>
	</tr>
	<tr>
		<th>제목</th>
		<td style="text-align : left">
			<input type="text" name="title" size="50">
		</td>
	</tr>
	<tr>
		<th>파일 업로드</th>
		<td style="text-align : left">
			<input type="file" name="fileload" style="width: 400px">
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td style="text-align : left"> <!-- 썸머노트, smart editor -->
			<textarea rows="10" cols="50" name="content"></textarea>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" style="height: 50px; text-align: center;">
			<a href="#none" id="_btnPds" title="자료올리기">
				<img alt="" src="image/bwrite.png">
			</a>
		</td>
	</tr>
</table>
</form>

<script>
$('#_btnPds').click(function() {
	//빈칸 체크
	
	$('#_frmForm').submit();
});
</script>