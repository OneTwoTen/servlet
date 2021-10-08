<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video Management</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
</head>
<body>
	<div class="row row-cols-1 row-cols-md-3">
		<c:forEach items="${listVideo}" var="video">
			<div class="col-3 mb-3">
				<div class="card">
					<iframe src="${video.link}" class="card-img-top"> </iframe>
					<div class="card-body">
						<a href="/WEB1/video?id=${video.id }"><h5 class="card-title">${video.title}</h5></a>
					</div>
					<div class="card-footer">
						<a class="btn btn-primary"
							href="/WEB1/favorite?videoid=${ video.id }">Like</a> <a
							class="btn btn-warning"
							href="/WEB1/videos/ShareVideo?videoid=${video.id }">Share</a>
						<c:if test="${sessionScope.user.role == '2'}">
							<a class="btn btn-warning"
								href="/WEB1/admin/videos/update?id=${video.id}">Chỉnh Sửa</a>
							<a class="btn btn-warning"
								href="/WEB1/videos/delete?id=${video.id}">Xoá</a>
						</c:if>
					</div>
				</div>

			</div>


		</c:forEach>
	</div>
	<ul class="pagination">
		<li class="page-item"><a href="/WEB1/videos?page=${ page - 1 }"
			class="page-link">Previos</a></li>
		<li class="page-item"><a href="/WEB1/videos?page=${ page + 1 }"
			class="page-link">Next</a></li>
	</ul>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
	var like;
	function likevideo(x) {
		like = x;
	    var xmlhttp = new XMLHttpRequest();

	    xmlhttp.onreadystatechange = function() {
	        if (xmlhttp.readyState == XMLHttpRequest.DONE) {   // XMLHttpRequest.DONE == 4
	           if (xmlhttp.status == 200) {
	               document.getElementById("like"+like).innerHTML = xmlhttp.responseText;
	           }
	           else if (xmlhttp.status == 400) {
	              alert('There was an error 400');
	           }
	           else {
	               alert('videoid: '+x);
	               document.getElementById("like"+like).innerHTML = xmlhttp.responseText;
	           }
	        }
	    };

	    xmlhttp.open("GET", "/WEB1/favorite?videoid="+like);
	    xmlhttp.send();
	}
	</script>
</body>
</html>