<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User" />
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Login" />
</jsp:include>
<div class="d-flex justify-content-center align-items-center container ">
	<form action="login" method="post">
		<div class="form-group">
			<input type="text" class="form-control" name="username" id="username"
				placeholder="Username">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" name="password"
				id="password" placeholder="Password">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<div class="d-flex justify-content-center align-items-center container ">
	<p>
		<a href="signup">Not registered? Click here to sign up</a>
	</p>
</div>
<%@ include file="../layout/footer.jsp"%>