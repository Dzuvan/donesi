<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Edit Article" />
</jsp:include>
<div class="container">
	<form method="post" action="editArticle">
		<input type="hidden" name="id" value="${article.id }" />
		<div class="form-group">
			<label for="name">Name</label> <input type="text" required
				class="form-control" id="name" name="name" value='${article.name}' />
		</div>
		<div class="form-group">
			<label for="description">Description</label> <input type="text"
				class="form-control" id="description" name="description" required
				value='${article.description}' />
		</div>
		<div class="form-group">
			<label for="Amount">Amount</label> <input type="number" min="0"
				class="form-control" id="amount" name="amount" required
				value='${article.amount}' />
		</div>
		<div class="form-group">
			<label for="price">Price</label> <input type="number" min="0"
				class="form-control" id="price" name="price" required
				value='${article.price}' />
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-success">Save</button>
			<a href="articleList" class="btn btn-secondary">Back</a>
		</div>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>