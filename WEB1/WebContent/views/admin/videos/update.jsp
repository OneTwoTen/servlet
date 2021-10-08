<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
						aria-current="page" href="#">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>



	<div class="row">
		<div class="col-12">
			<div class="col-6 offset-3">
				<form method="POST"
					action="/WEB1/admin/videos/update?id=${video.id }">
					<div class="form-group">
						<label for="exampleInputEmail1">Link</label> <input type="text"
							class="form-control" id="link" name="link" value="${video.link}">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Title</label> <input
							type="text" class="form-control" id="title" name="title"
							value="${video.title}">
					</div>
					<div class="form-row">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="acitve"
								id="exampleRadios1" value="1" ${video.acitve==1 ? "checked": ""}>
							<label class="form-check-label" for="exampleRadios1">
							${video.acitve }
								Active</label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="acitve"
								id="exampleRadios2" value="2" ${video.acitve!=1 ? "checked":""}>
							<label class="form-check-label" for="exampleRadios2">
								UnActive</label>
						</div>
					</div>
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Example textarea</label>
						<textarea class="form-control" id="description" name="description"
							value="${video.description}" rows="3"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>

				</form>
			</div>
		</div>
	</div>
</body>
</html>