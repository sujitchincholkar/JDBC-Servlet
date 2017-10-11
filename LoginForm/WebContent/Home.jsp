<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
   if(session.getAttribute("name")==null){
	   response.sendRedirect("Login.jsp");
   }
	
%>
<nav class="navbar navbar-inverse">
<ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      </ul>
       <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><%=session.getAttribute("name") %></a></li>
      <li><a href="Logout">Log Out</a></li>
      </ul>
</nav>

<%-- <p>Session id<%=session.getId() %></p>
<p>Session Last Access<%=session.getLastAccessedTime() %> --%>
</body>
</html>