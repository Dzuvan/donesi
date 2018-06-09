<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" flush="true">
	<jsp:param name="title" value="Edit Restaurant" />
</jsp:include>
<div class="container">
	<form method="post" action="editRestaurant">
		<input type="hidden" name="id" value="${restaurant.id }" />
		<div class="form-group">
			<label for="name">Name</label> <input type="text" required
				class="form-control" id="name" name="name"
				value='${restaurant.name}' />
		</div>
		<div class="form-group">
			<label for="address">Address</label> <input type="text"
				class="form-control" id="address" name="address" required
				value='${restaurant.address}' />
		</div>
		<div class="form-group">
			<label for="category">Category</label> <select name="category" required>
				<option
					${restaurant.category == "DomacaKuhinja" ? 'selected="selected"':"" }
					value="DomacaKuhinja">Domaca kuhinja</option>
				<option
					${restaurant.category == "Rostilj" ? 'selected="selected"':"" }
					value="Rostilj">Roštilj</option>
				<option
					${restaurant.category == "KineskiRestoran" ? 'selected="selected"' :"" }
					value="KineskiRestoran">Kineski restoran</option>
				<option
					${restaurant.category == "IndijskiRestoran" ? 'selected="selected"' :"" }
					value="IndijskiRestoran">Indijski restoran</option>
				<option
					${restaurant.category == "Poslasticarnica" ? 'selected="selected"' :"" }
					value="Poslasticarnica">Poslastičarnica</option>
				<option
					${restaurant.category == "Picerija" ? 'selected="selected"' :"" }
					value="Picerija">Picerija</option>
			</select>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-success">Save</button>
			<a href="restaurantList" class="btn btn-secondary">Back</a>
		</div>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>