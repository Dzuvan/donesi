<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Restaurants" />
</jsp:include>
<a href="createRestaurant">Create New Restaurant</a>
<hr>
<div class="d-flex justify-content-center align-items-center container ">
	<c:forEach items="${restaurants}" var="item">
		<c:if test="${item.active == true }">
			<div class="card text-white bg-dark mb-3" style="width: 18rem;">
				<div class="card-body">
					<h5 class="card-title"><a href="restaurantDetails?id=${item.id}">${item.name }</a></h5>
					<h5 class="card-subtitle mb-2 text-muted">${item.category }</h5>
					<p class="card-text">${item.address}</p>
					<a href="editRestaurant?id=${item.id }" class="btn btn-warning">Edit</a>
					<a href="deleteRestaurant?id=${item.id }" class="btn btn-danger">Delete</a>
				</div>
			</div>
		</c:if>
	</c:forEach>
</div>
<%@ include file="../layout/footer.jsp"%>