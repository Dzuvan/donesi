<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Delete Restaurant" />
</jsp:include>
<div class="container d-flex justify-content-center align-items-center">
	<p>
		Are you sure you wish to delete <strong> ${restaurant.name }</strong>
		?
	</p>
	<br>
	<form method="post" action="deleteRestaurant">
		<input type="hidden" name="id" value="${restaurant.id }" />
		<div class="form-group">
			<input type="submit" name="submit" value="Yes"
				class="btn btn-warning"> <a href="restaurant"
				class="btn btn-success">No</a>
		</div>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>