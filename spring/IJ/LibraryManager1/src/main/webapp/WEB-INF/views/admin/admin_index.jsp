<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet" />
</head>

<body>
    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container px-5">
            <a class="navbar-brand" href="/admin_index">MINGW's Library Admin Page</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/admin_index">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Page Content-->
    <div class="container px-4 px-lg-5">
        <!-- Heading Row-->
        <div class="row gx-4 gx-lg-5 align-items-center my-5">
            <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0" src="assets/img/admin_wallpaper.jpg" alt="..." /></div>
            <div class="col-lg-5">
                <h1 class="font-weight-light">MinGW's Library<br /> Admin Page</h1>
                <p>관리자님 안녕하세요! <br /> 관리자님의 행복한 하루를 기원합니다.</p>
            </div>
        </div>
        <!-- Call to Action-->
        <div class="card text-white bg-danger my-5 py-4 text-center">
            <div class="card-body">
                <h3>
                    <p class="text-white m-0">FACE THE FEAR, MAKE THE FUTURE.</p>
                </h3>
            </div>
        </div>

        <!--    도서 / 알림 / 회원 모음집 섹션 -->

        <div class="container my-5 py-4 text-center">
            <div class="card text-center">
                <div class="card-header">
                    <ul class="nav nav-tabs card-header-tabs" id="tabs">
                        <li class="nav-item">
                            <a class="nav-link active" href="#nav_Book" data-toggle="tab">도서</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#nav_Alarm" data-toggle="tab">알림</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#nav_Member" data-toggle="tab">회원</a>
                        </li>
                    </ul>
                </div>
                <div class="card-body">
                    <div class="tab-content">
                        <div class="tab-pane active" id="nav_Book">
                            <!--                        도서-->
                            <div class="card-group">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="assets/img/book_book.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">도서 추가/삭제</h5>
                                        <p class="card-text">MinGW's Library 의 도서 시스템에<br /> <b>도서를 추가/삭제</b>하는 기능을 이용합니다.</p>
                                        <a href="/admin/book/add" class="btn btn-primary">도서 추가</a>
                                        <a href="/admin/book/delete" class="btn btn-primary">도서 삭제</a>
                                    </div>
                                </div>
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="assets/img/book_update.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">도서 수정</h5>
                                        <p class="card-text">MinGW's Library 의 도서 시스템에<br /> <b>도서의 정보를 수정</b>하는 기능을 이용합니다.</p>
                                        <a href="/admin/book/update" class="btn btn-primary">도서 수정</a>
                                    </div>
                                </div>
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="assets/img/book_overdue.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">연체 도서</h5>
                                        <p class="card-text">MinGW's Library 의 도서 시스템에<br /> <b>연체된 도서 정보를</b> 보는 기능을 이용합니다.</p>
                                        <a href="/admin/book/overdue" class="btn btn-primary">연체 도서</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="nav_Alarm">
                            <!--                        알림-->
                            <div class="card-group">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="assets/img/alarm_notice.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">공지사항</h5>
                                        <p class="card-text">MinGW's Library 의 도서 시스템의<br /> <b>공지사항 게시판</b>을 관리합니다.</p>
                                        <a href="/admin/alarm/notice/notice_add" class="btn btn-primary">공지 사항 추가</a>
                                        <a href="/admin/alarm/notice/notice_delete" class="btn btn-primary">공지 사항 삭제</a>
                                    </div>

                                </div>
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="assets/img/alarm_good.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">사서 추천 도서</h5>
                                        <p class="card-text">MinGW's Library 의 도서 시스템의<br /> <b>사서 추천 도서 게시판</b>을 관리합니다.</p>
                                        <a href="/admin/alarm/good/good_add" class="btn btn-primary">추천 도서 추가</a>
                                        <a href="/admin/alarm/good/good_delete" class="btn btn-primary">추천 도서 삭제</a>
                                    </div>

                                </div>
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="assets/img/alarm_free_board.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">자유 게시판 관리</h5>
                                        <p class="card-text">MinGW's Library 의 도서 시스템의<br /> <b>자유 게시판 게시물</b>을 관리합니다.</p>
                                        <a href="/admin/alarm/board/board_update" class="btn btn-primary">게시물 비공개 설정</a>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="nav_Member">
                            <!--                        회원회원회원회원-->
                            <div class="card-group">
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="assets/img/member_list.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">회원 목록</h5>
                                        <p class="card-text">MinGW's Library 의 도서 시스템의<br /> <b>전체 회원 목록</b>을 확인합니다.</p>
                                        <a href="/admin/member/show" class="btn btn-primary">회원 목록</a>
                                    </div>
                                </div>
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="assets/img/member_update.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">회원 희망 도서</h5>
                                        <p class="card-text">MinGW's Library 의 회원들이 신청한<br /> <b>희망 도서</b>를 확인합니다.</p>
                                        <a href="/admin/member/hope" class="btn btn-primary">회원 희망 도서</a>
                                    </div>
                                </div>
                                <div class="card" style="width: 18rem;">
                                    <img class="card-img-top" src="assets/img/member_black_show.jpg" alt="Card image cap">
                                    <div class="card-body">
                                        <h5 class="card-title">회원 블랙리스트 관리</h5>
                                        <p class="card-text">MinGW's Library 의 도서 시스템의<br /> <b>블랙리스트 회원 정보</b>를 관리합니다.</p>
                                        <a href="/admin/member/black_show" class="btn btn-primary">회원 블랙리스트 관리</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container px-4 px-lg-5">
                <p class="m-0 text-center text-white">Copyright &copy; MinGW's Library 2021</p>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../js/scripts.js"></script>
        <!--    회원 정의 추가용-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
        <!--    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css" rel="stylesheet" />-->

        <!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
    </div>
</body>

</html>
