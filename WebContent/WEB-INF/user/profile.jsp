<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="beans.User" />
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Profile" />
</jsp:include>

<div class="container">
	<div class="row align-items-center">
		<div class="card">
			<table class="table">
				<tr>
					<td>Username</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Email</td>
					<td>Phone Number</td>
					<td>Birthday</td>
					<td>Action</td>
				</tr>
				<tr>
					<td>${user.username}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.email}</td>
					<td>${user.phone}</td>
					<td>${user.birthday}</td>
					<td class="btn btn-warning"><a href="editUser?id=${user.id}">Edit</a></td>
				</tr>
			</table>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>