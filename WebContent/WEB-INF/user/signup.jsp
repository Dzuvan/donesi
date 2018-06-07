<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Signup" />
</jsp:include>

<div class="d-flex justify-content-center align-items-center container">
	<form method="post" action="signup">
		<div class="form-group">
			<input type="text" class="form-control" name="username"
				id="InputUsername" placeholder="Username"
				value='${empty messages.username ? "" : param.username}' required>
			<span style="color: red; font-weight: bold;">${messages.username}</span>
		</div>
		<div class="form-group">
			<input type="password" class="form-control" name="password"
				id="InputPassword" placeholder="Password">
		</div>
		<div class="form-group">
			<input type="password" class="form-control" name="password2"
				id="InputPassword2" placeholder="Repeat password"> <span
				style="color: red; font-weight: bold;">${messages.password}</span>
		</div>
		<div class="form-group">
			<input type="email" class="form-control" name="email" id="InputEmail"
				aria-describedby="emailHelp" placeholder="Enter email"> <small
				id="emailHelp" class="form-text text-muted" style="color: #ffc107">
				We'll never share your email with anyone else. </small>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="firstName"
				id="InputFirstName" placeholder="First name">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="lastName"
				id="InputLastName" placeholder="Last name">
		</div>
		<div class="form-group">
			<input type="tel" class="form-control" name="phone" id="InputPhone"
				placeholder="Phone number">
		</div>
		<div class="form-group">
			<input type="date" class="form-control" name="birthday"
				id="InputBirthday" placeholder="Birthday">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>