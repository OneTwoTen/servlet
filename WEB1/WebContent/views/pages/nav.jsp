<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
</head>
<body>
	<div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/WEB1/user/infomation?id=${sessionScope.user.id}">${sessionScope.user.fullname}</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="/WEB1/videos">Home <span class="sr-only">(current)</span>
					</a></li>
					<c:if test="${sessionScope.user.role == '2'}">
						<li class="nav-item"><a class="nav-link"
							href="/WEB1/admin/users">Users</a></li>
					</c:if>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Video </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="/WEB1/videos">Video</a>

							<c:if test="${sessionScope.user.role == '2'}">
								<a class="dropdown-item" href="/WEB1/admin/new-video">New
									Video</a>
							</c:if>
							<c:if test="${sessionScope.user != null}">
								<a class="dropdown-item" href="/WEB1/videos/favorites">Favorite</a>
							</c:if>
						</div></li>
					<c:if test="${sessionScope.user != null}">
						<li><a class="dropdown-item" href="/WEB1/logout">Đăng
								xuất</a></li>
					</c:if>
					<c:if test="${sessionScope.user == null}">
						<li class="nav-item"><a class="nav-link"
							href="/WEB1/forgotpassword" tabindex="-1"> Quên mật khẩu </a></li>
						<li class="nav-item"><a class="nav-link" href="/WEB1/login"
							tabindex="-1"> Đăng nhập </a></li>
					</c:if>

				</ul>
				<form class="form-inline my-2 my-lg-0">
					<span>${ error }</span>
				</form>
			</div>
		</nav>
	</div>
</body>
</html>