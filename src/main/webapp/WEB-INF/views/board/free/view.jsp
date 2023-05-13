<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../../../../resources/static/css/free/view.css">
    <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css">



    <script src="https://kit.fontawesome.com/6ba5041685.js" crossorigin="anonymous"></script>
</head>
<!-- test -->
<body>
<jsp:include page="../../layout/header.jsp"/>



<div class="main-container">
    <div class="main-title">
        <h1>자유게시판</h1>
        <p>서울라이브 게시판</p>
    </div>
    <div class="board-view-container">
        <div class="board-view" id="board-view-content">
            <div class="board-title">${dto.title}</div>
            <div class="board-info">
                <div class="board-info-lists">
                    <div class="board-info-list">번호</div>
                    <div class="board-info-num">${dto.seq}</div>
                </div>
                <div class="board-info-lists">
                    <div class="board-info-list">글쓴이</div>
                    <div class="board-info-writer">${dto.writer}</div>
                </div>
                <c:if test="${empty dto.modify_date}">
                <div class="board-info-lists">
                    <div class="board-info-list">작성일</div>
                    <div class="board-info-date"><fmt:formatDate value="${dto.write_date}" pattern="yyyy-MM-dd"/></div>
                </div>
                </c:if>
                <c:if test="${!empty dto.modify_date}">
                    <div class="board-info-lists">
                        <div class="board-info-list">수정일</div>
                        <div class="board-info-date"><fmt:formatDate value="${dto.write_date}" pattern="yyyy-MM-dd"/></div>
                    </div>
                </c:if>
                <div class="board-info-lists">
                    <div class="board-info-list">조회</div>
                    <div class="board-info-views">${dto.total_count}</div>
                </div>
            </div>
            <div class="board-content">${dto.content}</div>
        </div>

        <div class="button_wrap">
            <ul class="button_box">
                <li><a href="/board/free/remove?seq=${dto.seq}">삭제</a></li>
                <li><a href="/board/free/modify?seq=${dto.seq}">수정</a></li>
                <li><a href="/board/free/list">목록</a></li>
            </ul>
        </div>

    </div>
</div>


<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>


</html>