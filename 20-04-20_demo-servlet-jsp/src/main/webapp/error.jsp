<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
	List<String> errorList = (List<String>)request.getAttribute("errorsList");
	for(String str : errorList)
	{
		out.println(str + "<br/>");	
	}
	%>
</body>
</html>