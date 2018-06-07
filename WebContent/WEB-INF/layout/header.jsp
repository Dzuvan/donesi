<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${param.title}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body
	class='${param.title == "Login" ? "login-slika": "" || param.title == "Signup" ? "login-slika": "" || param.title=="Articles" ? "slika" : "" }'>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="welcome">Naruči me ;)</a>
		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<li class='nav-item ${param.title=="Welcome" ? "active" : ""}'><a
					class="nav-link" href="welcome">Home </a></li>
				<li class='nav-item ${param.title=="Articles" ? "active" : ""}'><a
					class="nav-link" href="articleList">Articles</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Disabled</a></li>
			</ul>
			<c:choose>
				<c:when test="${user.username != null }">
					<a class="nav-item nav-link" href="profile">Profile</a>
					<form class="form-inline my-2 my-lg-0" method="get" action="logout">
						<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Logout</button>
					</form>
				</c:when>
				<c:otherwise>
					<a href="login" class="btn btn-outline-success my-2 my-sm-0">Login</a>
				</c:otherwise>
			</c:choose>
		</div>
	</nav>
	<div class="container d-flex justify-content-center">
		<h1 style="color: #ffc107">${param.title}</h1>
	</div>