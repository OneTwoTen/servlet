<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
		crossorigin="anonymous">




	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">PT15304-UD</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/WEB1/admin/users">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>



	<div class="row">
		<div class="col-12">
			<div class="col-6 offset-3">
				<form method="POST" action="/WEB1/videos/ShareVideo">
				<input type="hidden" name="videoid" value="${id}">
					<div class="mt-3">
						<label for="fullname" class="form-label">Name</label> <input
							type="text" class="form-control" id="link" name="link" />
					</div>
					<div class="mt-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email" />
					</div>
					<div class="mt-3">
						<button type="submit" class="btn btn-primary mb-3">
							Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>