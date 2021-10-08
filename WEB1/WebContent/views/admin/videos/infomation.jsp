<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video</title>
</head>
<body>
	<div class="row">
		<div class="col-8">
			<iframe height="100%" width="100%" src="${video.link}"></iframe>
				<div class="card">

						<div class="card-body">
							<a href=""><h5 class="card-title">${video.title }</h5></a>

							<p class="card-text">${video.description }</p>
						</div>
						<div class="card-footer">
							<button class="btn btn-primary">Like</button>
							<button class="btn btn-warning">Share</button>
						</div>
					</div>
		</div>
		<div class="col-4">
			<div class="row row-cols-1 row-cols-md-3">
				<div class="col-6 mb-4">
					<div class="card">

						<iframe src="https://www.youtube.com/embed/tgbNymZ7vqY"
							class="card-img-top"> </iframe>
						<div class="card-body">
							<a href="https://www.google.com.vn/"><h5 class="card-title">Card
									title</h5></a>

							<p class="card-text">This is a longer card.</p>
						</div>
						<div class="card-footer">
							<button class="btn btn-primary">Like</button>
							<button class="btn btn-warning">Share</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>