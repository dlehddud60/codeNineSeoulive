<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 커밋하고 푸쉬하기1212 -->
    <title>SEOULLIVE</title>
    <!-- layout css -->
    <link rel="stylesheet" href="../../../../resources/static/css/free/list&write.css">
    <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css">


    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.1/jquery-migrate.min.js"></script>
    <script src="https://kit.fontawesome.com/4b84ea08f3.js" crossorigin="anonymous"></script>

</head>
<jsp:include page="../../layout/header.jsp"/>

<body>

<div id="container">
    <div class="title_box">
        <h2 class="title">자유게시판</h2>
    </div>
    <div class="search_wrap">
        <form method="get" action="?">
            <fieldset class="search_box">
                <legend class="hide">게시글 검색</legend>
                <div class="cate_box">
                    <label for="search_category" class="hide"><span>검색분류선택</span></label>
                    <select name="search_category">
                        <option value="all">전체</option>
                        <option value="">제목</option>
                        <option value="">내용</option>
                        <option value="">작성자</option>
                    </select>
                </div>
                <div class="search_input_box">
                    <label for="search_value" class="hide"><span>검색</span></label>
                    <input class="b_input"type="text" id="search_value" name="search_value" placeholder="검색어를 입력해 주세요">
                    <button type="submit" class="search_button"><span>검색</span></button>
                </div>

            </fieldset>
        </form>
    </div>
    <div class="table_wrap">
        <table class="table_free" summary="번호, 카테고리, 제목, 작성자, 등록일, 조회수로 구성된 표">
            <caption class="hide">공지사항</caption>
            <colgroup>
                <col width="10%">
                <col width="*">
                <col width="10%">
                <col width="10%">
                <col width="10%">
            </colgroup>
            <thead>
            <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">등록일</th>
                <th scope="col">조회</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="freeDto" items="${list}">
                <tr>
                    <td>${freeDto.seq}</td>
                    <td class="title left"><a href="view?seq=${freeDto.seq}">${freeDto.title}</a>
                        <a href="#" title="자세히 보기"></a>
                    </td>
                    <td>${freeDto.writer}</td>
                    <td><fmt:formatDate value="${freeDto.write_date}" pattern="yyyy-MM-dd"/></td>
                    <td>${freeDto.total_count}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>

    <div class="button_wrap">
        <ul class="button_box">
            <li><a href="/board/free/write">등록</a></li>
        </ul>
    </div>



    <div class="paging_wrap">
        <div class="paging_box">
            <ul>
                <li class="prev pager">
                    <a href="#a" title="이전 페이지로 이동하기"><i class="fas fa-chevron-left"></i></a></li>
                <li>
                    <a class="active" href="#a">1</a></li>
                <li>
                    <a href="#a">2</a></li>
                <li>
                    <a href="#a">3</a></li>
                <li>
                    <a href="#a">4</a></li>
                <li>
                    <a href="#a">5</a></li>
                <li>
                    <a href="#a">6</a></li>
                <li>
                    <a href="#a">7</a></li>
                <li>
                    <a href="#a">8</a></li>
                <li>
                    <a href="#a">9</a></li>
                <li>
                    <a href="#a">10</a></li>
                <li class="next pager">
                    <a href="#a" title="다음 페이지로 이동하기"><i class="fas fa-chevron-right"></i></a></li>
            </ul>
        </div>
    </div>

</div>




</body>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>

</html>
