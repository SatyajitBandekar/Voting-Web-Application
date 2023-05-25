<%String acheck =(String) session.getAttribute("acheck"); %>
<%
if(acheck != null)
{
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Admin Home Page</h1>


<h2>Candidate 1 total votes : ${c1}</h2>
<h2>Candidate 2 total votes : ${c2}</h2>
<h2>Candidate 3 total votes : ${c3}</h2>
<h2>Candidate 4 total votes : ${c4}</h2>

<%}
else
{
	response.sendRedirect("AdminLogin");
}
%>

</body>
</html>