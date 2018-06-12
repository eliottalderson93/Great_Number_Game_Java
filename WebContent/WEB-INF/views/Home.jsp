<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="html/css; charset=ISO-8859-1">
<link rel="stylesheet" href="../../css/styles.css" />
<title>Great Number Game</title>
</head>
<body>
	<div class = "wrapper">
		<p>Welcome to the Great Number Game</p>
		<p>I am thinking of a number between 1 and 100</p>
		<p>Take a guess!</p>
		<p>${pageContext.request.contextPath}</p>
		<%final String win = (String) request.getAttribute("win"); %>
		<%if((win == null) || (win == "")){ %>
		<%}else if(win == "high"){%>
		<div class = "high"><p>Too high</p></div>
		<%} else if(win == "low"){%>
		<div class = "low"><p>Too low</p></div>
		<%}else{%>
		<form class = "win" method = 'POST' action = "/Great_Number_Game/Reset">
		<p>was the number!</p>
		<button>Play Again</button>
		</form>
		<%} %>
		<form method = 'post' action = '/Great_Number_Game/Guess'>
		<input type = 'text' name = 'guess'>
		<button>Guess</button>
		</form>
	</div>
</body>
</html>