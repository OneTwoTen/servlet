<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
<body>
	<div class="row row-cols-1 row-cols-md-3">
		<div class="col-12">
			<div class="mt-5 row">
				<div class="col-6">
					<a href="/WEB1/register" class="btn btn-success">Thêm mới</a>
				</div>
				<div class="col-4"></div>
				<div class="col-2 d-flex justify-content-end">
					<select class="form-select">
						<option value="10" selected>10</option>
						<option value="10">20</option>
						<option value="10">50</option>
						<option value="10">100</option>
					</select>
				</div>
			</div>
			<div class="mt-5 table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<td>Id</td>
							<td>Name</td>
							<td>Email</td>
							<td>Role</td>
							<td colspan="2">Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listUser }" var="user">
							<tr>
								<td>${user.id}</td>
								<td>${user.fullname }</td>
								<td>${ user.email }</td>
								<td>${ user.role }</td>
								<td><a href="/WEB1/admin/users/update?id=${user.id }"
									class="btn btn-primary">Update</a></td>
								<td><a href="/WEB1/admin/users/delete?id=${user.id }"
									class="btn btn-danger">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="pagination">
					<li class="page-item"><a
						href="/WEB1/admin/users?page=${ page - 1 }" class="page-link">Previos</a>
					</li>
					<li class="page-item"><a
						href="/WEB1/admin/users?page=${ page + 1 }" class="page-link">Next</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>