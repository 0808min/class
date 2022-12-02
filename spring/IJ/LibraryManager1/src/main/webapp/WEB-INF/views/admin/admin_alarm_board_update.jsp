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
					<h1 class="mt-4">게시글</h1>
					<!-- <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="/admin/member/show">회원 목록</a></li>
                        <li class="breadcrumb-item"><a href="/admin/member/hope">회원
                                희망 도서</a></li>
                        <li class="breadcrumb-item active">회원
                            게시글</li>
                    </ol> -->

					<!--                    회원 목록-->
					<div class="card mb-4">
						<div class="card-body">현재 자유 게시판에 기록된 게시글들의 목록을 확인 가능합니다.</div>
					</div>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i>게시글 회원 목록
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>게시글 ID</th>
										<th>E-mail</th>
										<th>제목</th>
										<th>작성 날짜</th>
										<th>공개 여부</th>
										<th>게시글 링크</th>
									</tr>
								</thead>
								<!-- <tfoot>
                                    <tr>
                                        <th>이름</th>
                                        <th>E-mail</th>
                                        <th>비밀번호</th>
                                        <th>랭크</th>
                                    </tr>
                                </tfoot> -->
								<tbody>
									<c:forEach var="boardDTO" items="${boardList}">
										<tr>
											<td>${boardDTO.boardID}</td>
											<td>${boardDTO.boardEmail}</td>
											<td>${boardDTO.boardTitle}</td>
											<td>${boardDTO.boardDate}</td>
											<td>${boardDTO.boardPublic}</td>
											<td><input type="button" value="자세히"
												onclick="location.href='/board/board_detail?boardID=${boardDTO.boardID}'" /></td>
											<!-- 버튼으로 게시글 ID 가져오기 테스트 성공 -->
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</main>

			<div class="container px-4 px-lg-5">
				<div class="row justify-content-center">
					<div class="card shadow-lg border-5 rounded-lg mt-5">
						<div class="card-header">
							<h3 class="text-center font-weight-light my-4">게시글 공개 여부 수정</h3>
						</div>
						<div class="card-body">
							<form action="/admin/alarm/board/board_update" method="POST">

								<div class="form-floating mb-3">
									<input class="form-control" id="inputBoardID" type="text"
										placeholder="회원의 E-mail 을 입력해주세요." name="inputBoardID" /> <label
										for="inputBoardID">수정을 원하는 게시글의 ID</label>
								</div>

								<label for="inputBoardPublid">회원 게시글 관리</label>
								<div class="">
									<select class="form-control form-control-lg"
										id="inputBoardPublic" name="inputBoardPublic">
										<option>Y</option>
										<option>N</option>
									</select>
								</div>

								<div class="mt-4 mb-0">
									<div class="d-grid">
										<input type="submit" class="btn btn-primary btn-block"
											value="게시글 공개 여부를 수정합니다." />
									</div>
								</div>

							</form>
						</div>


					</div>
				</div>
			</div>


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
			<!--    회원 정의 추가용-->
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
			

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
