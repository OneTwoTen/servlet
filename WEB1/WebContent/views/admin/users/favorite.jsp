<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>favorite</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
</head>
<body>
<div class="row row-cols-1 row-cols-md-3">
	<c:forEach items="${listFavoriteVideo}" var="listF">
		<div class="col-3 mb-3">
				<div class="card">
					<div class="card-body">
						<a href="/WEB1/video?id=${listF.video.id }"><h5 class="card-title">${listF.video.id}</h5></a>
						<span>Like date: ${listF.likedate}</span>
					</div>
					<div class="card-footer">
						<a class="btn btn-primary" href="/WEB1/unlike?id=${ listF.id }">Unlike</a> 
						<a class="btn btn-warning" href="">Share</a>
					</div>
				</div>
			
		</div>

	
	</c:forEach>
	</div>
</body>
</html>