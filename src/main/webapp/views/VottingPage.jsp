<%String check =(String) session.getAttribute("check"); %>
<%
if(check != null)
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

<h1>Votting Page</h1>

<form action="VottingProcess" method="post">
<input type="radio" name="vote" value="candidate_1" id="vote">Candidate 1<br><br>
<input type="radio" name="vote" value="candidate_2" id="vote">Candidate 1<br><br>
<input type="radio" name="vote" value="candidate_3" id="vote">Candidate 1<br><br>
<input type="radio" name="vote" value="candidate_4" id="vote">Candidate 1<br><br>
<input type="hidden" name="username" value=${username }><br><br>
<button>Vote</button>
</form>

<%}
else
{
	response.sendRedirect("LoginPage");
}
%>
</body>
</html>