<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
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
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
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

        <div id="layoutSidenav_content">
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">도서</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">도서 추가</li>
                        <li class="breadcrumb-item"><a href="/admin/book/delete">도서
                                삭제</a></li>
                        <li class="breadcrumb-item"><a href="/admin/book/update">도서
                                수정</a></li>
                        <li class="breadcrumb-item"><a href="/admin/book/overdue">연체
								도서</a></li>
                    </ol>

                    <!--                    도서 목록-->
                    <div class="card mb-4">
                        <div class="card-body">현재 추가 하고자 하는 도서가 존재하는지 미리 확인하세요!</div>
                    </div>
                    <div class="card mb-4">
                        <div class="card-header">
                            <i class="fas fa-table me-1"></i> 도서 목록
                        </div>
                        <div class="card-body">
                            <table id="datatablesSimple">
                                <thead>
                                    <tr>
                                        <th>ISBN10</th>
                                        <th>제목</th>
                                        <th>저자</th>
                                        <th>출판사</th>
                                        <th>장르</th>
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
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!--                도서 추가 파트-->
                <div class="container px-4 px-lg-5">
                    <div class="row justify-content-center">
                        <div class="card shadow-lg border-5 rounded-lg mt-5">
                            <div class="card-header">
                                <h3 class="text-center font-weight-light my-4">도서 추가</h3>
                            </div>
                            <div class="card-body">
                                <form action="/admin/book/add" method="POST" enctype="multipart/form-data">

                                    <!--                                    ISBN10 & 장르-->
                                    <div class="row mb-3">
                                        <div class="col-md-6">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="inputBookISBN" type="text" placeholder="ISBN 코드를 입력해주세요." name="inputBookISBN" /> <label for="inputISBN">ISBN10 코드</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-floating">
                                                <input class="form-control" id="inputBookGenre" type="text" placeholder="장르를 입력해주세요." name="inputBookGenre" /> <label for="inputGenre">장르</label>
                                            </div>
                                        </div>
                                    </div>


                                    <!--                                    제목 저자 출판사-->
                                    <div class="row mb-3">
                                        <div class="col-md-4">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="inputBookTitle" type="text" placeholder="제목 명을 입력해주세요." name="inputBookTitle" /> <label for="inputFirstName">제목</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="inputBookAuthor" type="text" placeholder="저자 명을 입력해주세요." name="inputBookAuthor" /> <label for="inputLastName">저자</label>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-floating mb-3 mb-md-0">
                                                <input class="form-control" id="inputBookPublisher" type="text" placeholder="출판사 명을 입력해주세요." name="inputBookPublisher" /> <label for="inputLastName">출판사</label>
                                            </div>
                                        </div>
                                    </div>

                                    <!--                                    권수-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="inputBookCount" type="number" placeholder="권수를 입력해주세요." name="inputBookCount" /> <label for="inputBookCount">권수</label>
                                    </div>
                                    
                                    <!--                                    줄거리-->
                                    <!-- <div class="form-floating mb-3">
                                        <input class="form-control" id="inputBookSummary" type="text" placeholder="줄거리를 입력해주세요." name="inputBookSummary" /> <label for="inputBookSummary">한줄 줄거리</label>
                                    </div> -->
                                    <div class="form-group">
										<textarea class="form-control" id="inputNoticeContent"
											placeholder="줄거리를 입력해주세요." rows="10" name="inputBookSummary"></textarea>
									</div>
									<div id="inputNoticeContentCount">(0 / 1000)</div>

                                    <!--                                    파일-->
                                    <label class="form-label" for="inputBookImage">책의 이미지
                                        파일을 삽입해주세요.</label> <input class="form-control" id="inputBookImage" type="file" placeholder="이미지 파일을 선택해주세요." name="inputBookImage" enctype="multipart/form-data" />

                                    <div class="mt-4 mb-0">
                                        <div class="d-grid">
                                            <input type="submit" class="btn btn-primary btn-block" value="도서를 추가합니다." />
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
