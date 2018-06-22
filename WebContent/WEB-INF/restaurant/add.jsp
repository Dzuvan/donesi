<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Add Article" />
</jsp:include>
<div class="container">
	<form method="post" action="addArticleToRestaurant">
		<div class="form">
			<div class="form-group">
				<label for="article">Article</label> <select name="article">
					<c:forEach var="item" items="${articles}">
						<option value="${item.id }">${item.name}</option>>
			</c:forEach>
				</select>
			</div>
			<input hidden="true" name="restaurant" value="${restaurant.id}">
			<button type="submit" class="btn btn-success">Create</button>
			<a href="restaurantDetails?id=${restaurant.id}"
				class="btn btn-secondary">Back</a>
		</div>
	</form>
</div>