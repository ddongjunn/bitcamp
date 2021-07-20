<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//DB, 데이터를 취합
String name = "이동준";
int age = 16;
String birth = "93/05/08";

String json = "{ \"name\":\"" + name + "\", \"age\":" + age + ", \"birth\":\"" + birth + "\" }";

System.out.println(json);

//전송 (web에 출력)
out.println(json);
%>