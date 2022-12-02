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
<link rel="icon" type="image/x-icon" href="../../../assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles2.css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
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
					<h1 class="mt-4">공지사항</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">공지 사항 추가</li>
						<li class="breadcrumb-item"><a
							href="/admin/alarm/notice/notice_delete">공지 사항 삭제</a></li>
					</ol>

					<!--                    공지 사항 목록-->
					<div class="card mb-4">
						<div class="card-body">현재 추가 하고자 하는 공지 사항이 존재하는지 미리 확인하세요!</div>
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> 공지 사항 목록
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>공지 ID</th>
										<th>공지 제목</th>
										<th>공지 날짜</th>
									</tr>
								</thead>
								<!-- <tfoot>
									<tr>
										<th>공지 ID</th>
										<th>공지 제목</th>
										<th>공지 날짜</th>
									</tr>
								</tfoot> -->
								<tbody>
									<c:forEach var="noticeDTO" items="${noticeList}">
                                        <tr>
                                            <td>${noticeDTO.noticeID}</td>
                                            <td>${noticeDTO.noticeTitle}</td>
                                            <td>${noticeDTO.noticeDate}</td>
                                            <!-- <td><input type="button" value="클릭" onclick="location.href='/noticeId=${noticeDTO.noticeID}'"/></td> -->
                                            <!-- 버튼으로 게시글 ID 가져오기 테스트 성공 -->
                                        </tr>
                                    </c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<!--                공지 사항 추가 파트-->
				<div class="container px-4 px-lg-5">
					<div class="row justify-content-center">
						<div class="card shadow-lg border-5 rounded-lg mt-5">
							<div class="card-header">
								<h3 class="text-center font-weight-light my-4">공지 사항 추가</h3>
							</div>
							<div class="card-body">
								<form action="/admin/alarm/notice/notice_add" method="POST">

									<div class="form-floating mb-3">
										<input class="form-control" id="inputNoticeTitle" type="text"
											placeholder="공지 사항 제목을 입력해주세요." name="inputNoticeTitle" /> <label
											for="inputNoticeTitle">공지 사항 제목</label>
									</div>

									<div class="form-group">
										<textarea class="form-control" id="inputNoticeContent"
											placeholder="공지 사항 내용을 입력해주세요." rows="10" name="inputNoticeContent"></textarea>
									</div>
									<div id="inputNoticeContentCount">(0 / 1000)</div>

									<div class="mt-4 mb-0">
										<div class="d-grid">
											<input type="submit" class="btn btn-primary btn-block"
												value="공지 사항을 추가합니다." />
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

			</main>
			<!-- Footer-->
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
			<script src="/js/scripts.js"></script>
			<!--    회원 정의 추가용-->
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
			<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
				crossorigin="anonymous"></script>
			<script src="/js/dataTables.js"></script>

			<!-- 글자제한 -->
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://code.jquery.com/jquery-3.5.1.js"
				integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
				crossorigin="anonymous"></script>
		</div>
	</div>
</body>

</html>