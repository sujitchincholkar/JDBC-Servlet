<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		String username = request.getParameter("username");
		session = request.getSession(false);
		response.setContentType("text/html");
		System.out.println("Inside jsp");
		 /* response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0 */
		 response.setDateHeader("Expires", 0); // Proxies.  */
		 System.out.println(session.getAttribute("id"));
		if (session.getAttribute("id")== null) {
			response.sendRedirect("/Login.html");
		} else if(session.isNew()){
			
		}
	%>
	 <sql:setDataSource var = "con" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/MyDb"
         user = "root"  password = "root"/>
         <sql:query dataSource = "${con}" var = "result">
         SELECT filename,id from fileSave where uid=<%=session.getAttribute("id")%>;
      </sql:query>
	<h3>
		Hello	<%=username%>....
	</h3>
	<a href="Logout">Logout</a>
	<br>
	<form action="UploadFile" enctype="multipart/form-data" method="post">
	    <input type="file" Value="file" name="file" id="file" required><br>
		<input type="submit" Value="Upload">
		 <table border = "1" width = "100%">
         <tr>
            <th>File Name</th>
         </tr>
         
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
              <td> <a href="Download" name="${row.id}"><c:out value = "${row.filename}"/>...</a></td>
            </tr>
         </c:forEach>
      </table>
	</form>
	<br>
	

</body>
</html>