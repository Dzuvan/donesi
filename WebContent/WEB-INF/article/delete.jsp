<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Edit Article" />
</jsp:include>
<div class="container d-flex justify-content-center align-items-center">
	<p>
		Are you sure you wish to delete <strong> ${article.name }</strong> ?
	</p>
	<form method="post" action="deleteArticle">
		<input type="hidden" name="id" value="${article.id }" />
		<div class="form-group">
			<input type="submit" name="submit" value="Yes"
				class="btn btn-warning"> <a href="articleList"
				class="btn btn-success">No</a>
		</div>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>