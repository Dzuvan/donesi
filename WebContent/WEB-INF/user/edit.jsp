<jsp:useBean id="user" scope="session" class="beans.User" />
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Edit Profile" />
</jsp:include>

<div class="container">
	<form method="post" action="editUser">
		<div class="form-group">
			<label for="username">Username</label> 
			<input type="text" class="form-control" id="username" name="username" value='${user.username}' />
		</div>
		<div class="form-group">
			<label for="firstName">Fist name</label> 
			<input type="text" class="form-control" id="firstName" name="firstName" value='${user.firstName }' />
		</div>
		<div class="form-group">
			<label for="lastName">Last name</label>
			<input type="text" class="form-control" id="lastName" name="lastName" value='${user.lastName}' />
		</div>
		<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" class="form-control" name="email" id="email" value='${user.email }' />
		</div>
		<div class="form-group">
			<label for="phone">Phone</label> 
			<input type="tel" class="form-control" name="phone" id="phone" value='${user.phone}' />
		</div>
		<div class="form-group">
			<label for="birthday">Birthday</label> 
			<input type="date" class="form-control" name="birthday" id="birthday" value='${user.birthday }'/>
		</div>
		<button type="submit" class="btn btn-success">Save</button>
		<a href="profile" class="btn btn-secondary">Back</a>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>