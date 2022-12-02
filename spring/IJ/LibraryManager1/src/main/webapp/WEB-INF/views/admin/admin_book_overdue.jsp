<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>MINGW's Library</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="../../assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles2.css" rel="stylesheet" />
</head>

<body>
	<!-- Responsive navbar-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container px-5">
			<a class="navbar-brand" href="/admin_index">MINGW's Library Admin
				Page</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/admin_index">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Page Content-->
	<div class="container px-4 px-lg-5">
		<!-- Heading Row-->

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">도서</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="/admin/book/add">도서
								추가</a></li>
						<li class="breadcrumb-item"><a href="/admin/book/delete">도서
								삭제</a></li>
						<li class="breadcrumb-item"><a href="/admin/book/update">도서
								수정</a></li>
						<li class="breadcrumb-item active">연체 도서</li>
					</ol>

					<!--                    도서 목록-->
					<div class="card mb-4">
						<div class="card-body">연체된 도서들의 목록입니다.</div>
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> 연체 도서 목록
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>ISBN</th>
										<th>E-mail</th>
										<th>대여 날짜</th>
										<th>반납 만기 날짜</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>ISBN</th>
										<th>E-mail</th>
										<th>대여 날짜</th>
										<th>반납 만기 날짜</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="checkOutDTO" items="${bookOverDueList}">
										<tr>
											<td>${checkOutDTO.checkOutISBN}</td>
											<td>${checkOutDTO.checkOutEmail}</td>
											<td>${checkOutDTO.checkOutRentalDate}</td>
											<td>${checkOutDTO.checkOutReturnDueDate}</td>
										</tr>
									</c:forEach>
									<!-- <tr>
										<td>1165215007</td>
										<td>jee00609@naver.com</td>
										<td>2020-03-01</td>
										<td>2020-04-01</td>
									</tr>
									<tr>
										<td>1165215007</td>
										<td>jee00609@gmail.com</td>
										<td>2020-03-01</td>
										<td>2020-04-01</td>
									</tr>
									<tr>
										<td>1165215007</td>
										<td>jee00609@daum,net</td>
										<td>2020-03-01</td>
										<td>2020-04-01</td>
									</tr> -->
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</main>


			<!-- 안 예뻐 ...-->
			<footer class="m-5 py-5 bg-dark">
				<div class="container px-4 px-lg-5">
					<p class="m-0 text-center text-white">Copyright &copy; MinGW's
						Library 2021</p>
				</div>
			</footer>

			<!-- Bootstrap core JS-->
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
			<!-- Core theme JS-->
			<script src="js/scripts.js"></script>
			<!--    도서 정의 추가용-->
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
			<!--        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>-->
			<!--    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css" rel="stylesheet" />-->

			<!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">-->
			<!--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>-->

			<script
				src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>

			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
				crossorigin="anonymous"></script>
			<script src="js/scripts.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
				crossorigin="anonymous"></script>
			<script src="/js/dataTables.js"></script>
		</div>
	</div>

</body>

</html>
