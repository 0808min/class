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
<link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/css/styles2.css" rel="stylesheet" />
</head>

<body>

    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg bg-light static-top ">
        <div class="container px-5">
            <%
					// 세션값 가져오기
					String id = (String) session.getAttribute("loginMemberName"); // Object 타입이므로 다운캐스팅
					if (id == null){%>
                    <a class="navbar-brand" href="/">MINGW's Library</a>
                    <%}else{%>
                    <a class="navbar-brand" href="/member_index">MINGW's Library</a>
                    <%}
			%>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <%
					// 세션값 가져오기

					if (id == null){%>
						<li class="nav-item"><a class="nav-link" href="/member/register">Register</a></li>
	                    <li class="nav-item"><a class="nav-link" href="/member/login">Login</a></li>
					<%}else{%>
						<li class="nav-item"><a class="nav-link" href="/member/my_page">MyPage</a></li>
                    <li class="nav-item"><a class="nav-link" href="/member/logout">Logout</a></li>
					<%}
					%>
   
                </ul>
            </div>
        </div>
    </nav>
    
    
    <!-- Navigation-->
    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
        <div class="container">
            <a class="btn" style="background-color: #e3f2fd; color: dodgerblue;" href="/book/unified_search">자료 검색</a>

            <div class="dropdown show">
                <a class="btn dropdown-toggle" style="background-color: #e3f2fd; color: dodgerblue;" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    신청 / 참여
                </a>

                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <%
						// 세션값 가져오기
						if (id == null){%>
                    <a class="dropdown-item disabled" href="/member/member_hope">희망 도서 신청</a>
                    <a class="dropdown-item" href="/board/unified_search">자유 게시판</a>
                    <%}else{%>
                    <a class="dropdown-item" href="/member/member_hope">희망 도서 신청</a>
                    <a class="dropdown-item" href="/board/unified_search">자유 게시판</a>
                    <%}
					%>
                </div>
            </div>

            <div class="dropdown show">
                <a class="btn dropdown-toggle" style="background-color: #e3f2fd; color: dodgerblue;" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    도서관 이용
                </a>

                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="/good/unified_search">사서 추천 도서</a>
                    <a class="dropdown-item" href="/book/new_unified_search">신간 도서</a>
                </div>
            </div>

            <div class="dropdown show">
                <a class="btn dropdown-toggle" style="background-color: #e3f2fd; color: dodgerblue;" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    도서관 정보
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="/library_introduce">도서관 소개</a>
                    <a class="dropdown-item" href="/notice/unified_search">공지 사항</a>
                </div>
            </div>
        </div>
    </nav>
    
	<!-- Page Content-->
	<div class="container px-4 px-lg-5">
		<!-- Heading Row-->

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">도서 검색</h1>


					<div class="card mb-4">

						<div class="card-body">
							<table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>ISBN10</th>
                                        <th>제목</th>
                                        <th>저자</th>
                                        <th>출판사</th>
                                        <th>장르</th>
                                        <th>해당 도서 페이지</th>
                                    </tr>
                                </thead>
                                <!-- <tfoot>
									<tr>
										<th>ISBN10</th>
										<th>제목</th>
										<th>저자</th>
										<th>출판사</th>
										<th>장르</th>
									</tr>
								</tfoot> -->
                                <tbody>
                                    <c:forEach var="bookDTO" items="${bookList}">
                                        <tr>
                                            <td>${bookDTO.bookISBN}</td>
                                            <td>${bookDTO.bookTitle}</td>
                                            <td>${bookDTO.bookAuthor}</td>
                                            <td>${bookDTO.bookPublisher}</td>
                                            <td>${bookDTO.bookGenre}</td>
                                            <td><input type="button" value="자세히" onclick="location.href='/book/book_detail?bookISBN=${bookDTO.bookISBN}&bookGenre=${bookDTO.bookGenre}'"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
						</div>
					</div>
				</div>

			</main>


			<!-- 안 예뻐 ...-->
			<!-- Footer-->
    <footer class="footer bg-light">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 h-100 text-center text-lg-start my-auto">
                    <ul class="list-inline mb-2">
                        <li class="list-inline-item"><a href="#!">About</a></li>
                        <li class="list-inline-item">⋅</li>
                        <li class="list-inline-item"><a href="#!">Contact</a></li>
                        <li class="list-inline-item">⋅</li>
                        <li class="list-inline-item"><a href="#!">Terms of Use</a></li>
                        <li class="list-inline-item">⋅</li>
                        <li class="list-inline-item"><a href="#!">Privacy Policy</a></li>
                    </ul>
                    <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2021. All Rights Reserved.</p>
                </div>
                <div class="col-lg-6 h-100 text-center text-lg-end my-auto">
                    <ul class="list-inline mb-0">
                        <li class="list-inline-item me-4">
                            <a href="#!"><i class="bi-facebook fs-3"></i></a>
                        </li>
                        <li class="list-inline-item me-4">
                            <a href="#!"><i class="bi-twitter fs-3"></i></a>
                        </li>
                        <li class="list-inline-item">
                            <a href="#!"><i class="bi-instagram fs-3"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
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
