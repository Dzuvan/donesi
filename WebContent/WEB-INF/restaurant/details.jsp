<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Restaurant" />
</jsp:include>

<a href="addArticleToRestaurant?id=${restaurant.id }">Add article</a>
<hr>
<div class="container">
	<h1> ${restaurant.name}</h1>
	<div class = "row">
		<c:forEach var="item" items="${restaurant.meals}">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">${item.name}</h5>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class = "row">
	<c:forEach var="item" items="${restaurant.drinks}">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">${item.name}</h5>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
