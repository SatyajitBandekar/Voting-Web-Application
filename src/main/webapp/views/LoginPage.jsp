<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>


<form action="LoginProcess" method="post">
<input type="text" name="username" placeholder="Enter Username"><br><br>
<input type="password" name="password" placeholder="Enter Password"><br><br>
<button>Login</button>
</form><br><br>

<form action="logoutprocess" method="post">
<input type="hidden" name="check", value="logout">
<button>LogOut</button>
</form><br><br>

<a href="Register" style="border:2px solid black; border-radius: 5px;">Register</a>


</body>
</html>