<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>MINGW's Library</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" type="text/css" />
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../css/styles.css" rel="stylesheet" />
</head>

<body>
	<c var="bookDTO" items="${bookDTO}"> <!-- Responsive navbar-->
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
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
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
	
	<!-- Product section-->
	<form action="/book/book_detail?bookISBN=${bookDTO.bookISBN}" method="POST">
		<section class="py-5">
			<div class="container px-4 px-lg-5 my-5">
				<div class="row gx-4 gx-lg-5 align-items-center">
					<div class="col-md-6">
						<img class="card-img-top mb-5 mb-md-0"
							src="/bookImageStorage/${bookDTO.bookImage}" alt="..." />
					</div>
					<div class="col-md-6">
						<div class="small mb-1">${bookDTO.bookGenre}</div>
						<h1 class="display-5 fw-bolder">${bookDTO.bookTitle}</h1>
						<div class="fs-5 mb-5">
							<span class="">도서 재고 : </span> <span>${bookDTO.bookCount}</span>
						</div>
						<p class="lead">
							저자 : ${bookDTO.bookAuthor}<br /> 출판사 : ${bookDTO.bookPublisher}<br />${bookDTO.bookSummary}
						</p>
						<div class="d-flex">
						
						<%
							//대여는 무조건 로그인 했을 때만 떠라!
							if (id != null){%>
								<button type="submit" value="대여하기"  class="btn btn-outline-dark flex-shrink-0">
								  <i class="bi-cart-fill me-1">대여 하기</i>
								</button>
								
							<%}
						%>
							<!-- <input class="btn btn-outline-dark flex-shrink-0" type="submit" value="대여하기" /> -->
							<!-- 이거 작은 카트 모양 이미지인데 input 태그 안에 어떻게 넣는지 모르겠어용 -->
							<!-- <i class="bi-cart-fill me-1"></i> 대여 하기 </input> -->
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
	<!-- Related items section-->
	<section class="py-5 bg-light">
		<div class="container px-4 px-lg-5 mt-5">
			<h2 class="fw-bolder mb-4">관련 장르 도서</h2>
			<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			
				<c:forEach var="bookDTO2" items="${genreBookList}">
					<div class="card h-100">
						<!-- 히트작이면 히트작이라고 태그 띄워주기 -->
						<c:if test="${bookDTO2.bookHit>='5'}">
							<div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">HIT!</div>
						</c:if>
						<img class="card-img-top" src="../bookImageStorage/${bookDTO2.bookImage}" alt="..." />
						<div class="card-body p-4">
							<div class="text-center">
								<h5 class="fw-bolder">${bookDTO2.bookTitle}</h5>
							</div>
						</div>
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="/book/book_detail?bookISBN=${bookDTO2.bookISBN}&bookGenre=${bookDTO2.bookGenre}">도서 상세</a>
							</div>
						</div>
					</div>
                </c:forEach>
					
				</div>
			</div>
		</div>
	</section>
	<!-- Footer--> <footer class="footer bg-light">
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
					<p class="text-muted small mb-4 mb-lg-0">&copy; MinGW's
						Library 2021. All Rights Reserved.</p>
				</div>
				<div class="col-lg-6 h-100 text-center text-lg-end my-auto">
					<ul class="list-inline mb-0">
						<li class="list-inline-item me-4"><a href="#!"><i
								class="bi-facebook fs-3"></i></a></li>
						<li class="list-inline-item me-4"><a href="#!"><i
								class="bi-twitter fs-3"></i></a></li>
						<li class="list-inline-item"><a href="#!"><i
								class="bi-instagram fs-3"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer> <!-- Bootstrap core JS--> <script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS--> <script type="text/javascript"
		src="../js/scripts.js"></script> <!--    사용자 정의 추가용--> <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
	<!--    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css" rel="stylesheet" />-->

	<!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">-->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
	</c>
</body>

</html>