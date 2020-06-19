<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String str1=(String)request.getAttribute("arg1");
  out.print("<h1>"+str1+"</h1>");
  String str=(String)request.getParameter("arg");
  out.print("<h1>"+str+"</h1>");
  
%>
</body>
</html>