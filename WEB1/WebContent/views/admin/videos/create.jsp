<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST"
		action="/WEB1/admin/new-video">
		<div class="form-group">
			<label for="exampleInputEmail1">Link</label> <input type="text"
				class="form-control" id="link" name="link" value="link">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Title</label> <input type="text"
				class="form-control" id="title" name="title" value="title">
		</div>
		<div class="form-row">
			<div class="form-check">
				<input class="form-check-input" type="radio" name="active"
					id="exampleRadios1" value="1" checked> <label
					class="form-check-label" for="exampleRadios1"> Active</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="active"
					id="exampleRadios2" value="2"> <label
					class="form-check-label" for="exampleRadios2"> UnActive</label>
			</div>
		</div>
		<div class="form-group">
			<label for="exampleFormControlTextarea1">Example textarea</label>
			<textarea class="form-control" id="description" name="description"
				value="description" rows="3"></textarea>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>

	</form>
</body>
</html>