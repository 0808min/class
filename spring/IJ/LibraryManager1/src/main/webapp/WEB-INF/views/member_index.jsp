<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>MINGW's Library</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet" />
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
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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




    <!--    검색 파트-->
    <!-- Masthead-->
    <header class="masthead">
        <div class="container position-relative">
            <div class="row justify-content-center">
                <div class="col-xl-6">
                    <div class="text-center text-white">
                        <!-- Page heading-->
                        <h1 class="mb-5">Welcome to MinGW's Library</h1>
                        <!-- Signup form-->
                        <h1 class="mb-5"><%=session.getAttribute("loginMemberName")%>
                            님 안녕하세요!

                  </form>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- !!!!!!!!!!!!!!!!!!!!   자유게시판  !!!!!!!!!!!!!!!!!!!!-->
    <!-- Page Content-->
    <div class="container px-4 px-lg-5">
        <!-- Call to Action-->
        <div class="card text-white bg-primary my-5 py-10 text-center">
            <div class="card-body">
                <!--                    <p class="text-white m-0">자유 게시판</p>-->
                <a href="/board/unified_search" class="btn btn-primary btn-lg">자유 게시판</a>
            </div>
        </div>
        <!-- Content Row-->
        <div class="row gx-4 gx-lg-5">
           <c:forEach var="boardDTO" items="${boardList}">
            <div class="col-md-4 mb-5">
                <div class="card h-100">
                    <div class="card-body">
                        <h2 class="card-title">${boardDTO.boardTitle}</h2>
                        <p class="card-text">${boardDTO.boardContent}</p>
                    </div>
                    <div class="card-footer">
                        <a class="btn btn-primary btn-sm" href="/board/board_detail?boardID=${boardDTO.boardID}">More Info</a>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>

   <!--    사서 추천 도서 / 인기 도서 섹션 -->
    <section class="bg-light py-5 border-bottom">
        <div class="container px-4 px-lg-5">
            <div class="card text-center">
                <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs" id="tabs">
                        <li class="nav-item"><a class="nav-link active" href="#librarianNominate" data-toggle="tab">사서 추천 도서</a></li>
                        <li class="nav-item"><a class="nav-link" href="#hitBook" data-toggle="tab">인기 도서</a></li>
                    </ul>
                </div>
                <div class="card-body">
                    <div class="tab-content">
                        <div class="tab-pane active" id="librarianNominate">
                            <!--                        사서 추천 도서-->
                            <div class="card-group col-sm-auto">
                                <c:forEach var="goodDTO" items="${goodList}">
                                    <div class="card" style="width: 18rem;">
                                        <img class="card-img-top" src="/bookImageStorage/${goodDTO.goodImage}" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">${goodDTO.goodTitle}</h5>
                                            <%--                                            <p class="card-text">${goodDTO.goodContent}</p> --%>
                                            <a href="/good/good_detail?goodID=${goodDTO.goodID}" class="btn btn-primary">자세히 보기</a>
                                        </div>
                                        <div class="card-footer">
                                            <small class="text-muted">${goodDTO.goodDate}</small>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="card text-white bg-primary my-5 py-10 text-center">
                                <div class="card-body">
                                    <a href="/good/unified_search" class="btn btn-primary btn-lg">사서
                                        추천 도서 게시판</a>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="hitBook">
                            <!--                        인기 도서-->
                            <div class="card-group col-sm-auto">
                                <c:forEach var="bookDTO2" items="${hitBookList}">
                                    <div class="card" style="width: 18rem;">
                                    	<div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">HIT!</div>
                                        <img class="card-img-top" src="/bookImageStorage/${bookDTO2.bookImage}" alt="Card image cap">
                                        <div class="card-body">
                                            <h5 class="card-title">${bookDTO2.bookTitle}</h5>
                                            <%--                                            <p class="card-text">${goodDTO.goodContent}</p> --%>
                                            <a href="/book/book_detail?bookISBN=${bookDTO2.bookISBN}&bookGenre=${bookDTO2.bookGenre}" class="btn btn-primary">자세히 보기</a>
                                        </div>
                                        <%-- <div class="card-footer">
                                           <small class="text-muted">${bookDTO2.bookDate}</small>
                                       </div> --%>
                                    </div>
                                </c:forEach>

                            </div>
                            <div class="card text-white bg-primary my-5 py-10 text-center">
                                <div class="card-body">
                                    <a href="/book/hit_unified_search" class="btn btn-primary btn-lg">인기
                                        도서 게시판</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <section class="py-5 border-bottom">
        <div class="container px-5 my-5">


            <!--
            <div class="text-center mb-5">
                <h2 class="fw-bolder">Pay as you grow</h2>
                <p class="lead mb-0">With our no hassle pricing plans</p>
            </div>
-->


            <div class="row gx-5 justify-content-center">
                <!-- Pricing card free-->
                <div class="col-lg-6 col-xl-6">
                    <div class="card mb-5 mb-xl-0">
                        <div class="card-body p-10">

                            <div class="mb-3">
                                <span class="display-4 fw-bold"> <i class="bi bi-star-fill text-warning"></i> 공지 사항
                                </span>

                            </div>
                            <ul class="list-unstyled mb-4">
                                <!-- <li class="mb-2"><i class="bi bi-check text-primary"></i> <strong>1 users</strong></li>
                                <li class="mb-2"><i class="bi bi-check text-primary"></i>5GB storage</li> -->
                                <c:forEach var="noticeDTO" items="${noticeList}">
                                   <li class="mb-2"><i class="bi bi-check text-primary"></i><a href="/notice/notice_detail?noticeID=${noticeDTO.noticeID}">${noticeDTO.noticeTitle}</a></li>
                                </c:forEach>
                            </ul>
                            <div class="d-grid">
                                <a class="btn btn-outline-primary" href="/notice/unified_search">더보기</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Pricing card pro-->
                <div class="col-lg-6 col-xl-6">
                    <div class="card mb-5 mb-xl-0">
                        <div class="card-body p-10">
                            <div class="mb-3">
                                <span class="display-4 fw-bold"> <i class="bi bi-star-fill text-warning"></i>신간 도서
                                </span>
                            </div>
                            <ul class="list-unstyled mb-4">
                               <c:forEach var="bookDTO" items="${bookList}">
                                <li class="mb-2"><i class="bi bi-check text-primary"></i> 
                                    <strong>
                                        <a class="bi text-primary" href="/book/book_detail?bookISBN=${bookDTO.bookISBN}">${bookDTO.bookTitle}</a>
                                    </strong>
                                </li>
                                </c:forEach>
                            </ul>
                            
                            <div class="d-grid">
                                <a class="btn btn-outline-primary" href="/book/new_unified_search">더보기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Testimonials-->
    <section class="testimonials text-center bg-light">
        <div class="container">
            <h2 class="mb-5">Spring Project 를 함께한 전우</h2>
            <div class="row">
                <div class="col-lg-6">
                    <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                        <img class="img-fluid rounded-circle mb-3" src="assets/img/MJC.jpg" alt="..." />
                        <h5>MJ.C</h5>
                        <p class="font-weight-light mb-0">"취업하고 싶어요!"</p>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                        <img class="img-fluid rounded-circle mb-3" src="assets/img/MJK.png" alt="..." />
                        <h5>MJ.K</h5>
                        <p class="font-weight-light mb-0">"The cake is a lie!"</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    
    <!-- Footer-->
    <footer class="footer bg-light">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 h-100 text-center text-lg-start my-auto">
                    <ul class="list-inline mb-2">
                        <li class="list-inline-item"><a href="#!">About</a></li>
                    </ul>
                    <p class="text-muted small mb-4 mb-lg-0">&copy; MinGW's
                        Library 2021. All Rights Reserved.</p>
                </div>
                <div class="col-lg-6 h-100 text-center text-lg-end my-auto">
                    <ul class="list-inline mb-0">
<!--                         <li class="list-inline-item me-4"><a href="#!"><i class="bi-facebook fs-3"></i></a></li>
                        <li class="list-inline-item me-4"><a href="#!"><i class="bi-twitter fs-3"></i></a></li>
                        <li class="list-inline-item"><a href="#!"><i class="bi-instagram fs-3"></i></a></li> -->
                    </ul>
                </div>
            </div>
        </div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script type="text/javascript" src="../js/scripts.js"></script>
    <!--    사용자 정의 추가용-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
    <!--    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css" rel="stylesheet" />-->

    <!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
</body>

</html>