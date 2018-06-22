<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Create Article" />
</jsp:include>
<div class="container">
	<form method="post" action="createArticle">
		<div class="form-group">
			<label for="name">Name</label> <input type="text"
				class="form-control" id="name" name="name" required />
		</div>
		<div class="form-group">
			<label for="description">Description</label> <input type="text"
				class="form-control" id="description" name="description" required />
		</div>
		<div class="form-group">
			<label for="Amount">Amount</label> <input type="number" min="0"
				class="form-control" id="amount" name="amount" required />
		</div>
		<div class="form-group">
			<label for="price">Price</label> <input type="number" min="0"
				class="form-control" id="price" name="price"  required/>
		</div>
		<div class="form-group">
			<label for="type">Type</label> 
			<select name="type" id="type" required>
				<option value="Drink">Drink</option>
				<option value="Meal">Meal</option>
			</select>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-success">Create</button>
			<a href="articleList" class="btn btn-secondary">Back</a>
		</div>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>