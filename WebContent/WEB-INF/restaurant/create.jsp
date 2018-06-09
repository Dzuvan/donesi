<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Create Restaurant" />
</jsp:include>
<div class="container">
	<form method="post" action="createRestaurant">
		<div class="form-group">
			<label for="name">Name</label> <input type="text" required
				class="form-control" id="name" name="name" />
		</div>
		<div class="form-group">
			<label for="address">Address</label> <input type="text"
				class="form-control" id="address" name="address" required />
		</div>
		<div class="form-group">
			<label for="category">Category</label> 
			<select name="cateogry" required>
				<option value="Domaća kuhinja">Domaća kuhinja</option>
				<option value="Roštilj">Roštilj</option>
				<option value="Kineski restoran">Kineski restoran</option>
				<option value="Indijski restoran">Indijski restoran</option>
				<option value="Poslastičarnica">Poslastičarnica</option>
				<option value="Picerija">Picerija</option>
			</select>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-success">Create</button>
			<a href="articleList" class="btn btn-secondary">Back</a>
		</div>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>