<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<div class="overflow-auto sideBar" style="height: 90vh;">
			<div class="wrapper">
				<!-- Sidebar -->
				<nav id="sidebar">
					<div class="sidebar-header">
						<h3>Bootstrap Sidebar</h3>
					</div>

					<ul class="list-unstyled components">
						<p>ABC</p>
						<li class="active"><a href="#homeSubmenu"
							data-toggle="collapse" aria-expanded="false"
							class="dropdown-toggle">Home</a>
							<ul class="collapse list-unstyled" id="homeSubmenu">
								<li><a href="/WEB1/user/infomation?id=${sessionScope.user.id}">Thông tin cá nhân</a></li>
								<li><a href="#">Đổi mật khẩu</a><a class="nav-link" href="#">Link</a>
								</li>
							</ul></li>
						
					</ul>
				</nav>

			</div>
		</div>

</body>
</html>