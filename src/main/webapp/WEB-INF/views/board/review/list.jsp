<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>리뷰 List</title>
    <!-- layout css -->
    <link rel="stylesheet" href="../../../../resources/static/css/review/list.css">
    <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css">

    <script src="https://kit.fontawesome.com/7ae3a6a91c.js" crossorigin="anonymous"></script>

    <script src="../js/list.js" defer></script>
    <!-- tab -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

    <script>
        $(function() {
            $('.write_btn').click(function() {
                // 게시판 목록으로 이동 : GET / board / list

                location.href = "/board/review/write";
            }); // on click

            $('.gridView-title').click(function() {
                // 게시판 목록으로 이동 : GET / board / list

                location.href = "/board/review/view&seq=${__BOARD__.seq}";
            }); // on click

        })
    </script>
</head>

<jsp:include page="../../layout/header.jsp"/>
<body>

<div id="container" class="list_wrap">

    <!-- search bar -->
    <div class="search_wrap">
        <div class="search">
            <select name="" id="">
                <option value="카테고리">카테고리</option>
                <option value="카테고리">카테고리</option>
                <option value="카테고리">카테고리</option>
                <option value="카테고리">카테고리</option>
            </select>
            <input type="text" class="searchTerm" placeholder="검색내용을 입력하세요.">

            <button type="submit" class="searchButton">
                <i class="fa fa-search"></i>
            </button>
        </div>
    </div>

    <!-- tab menu -->
    <ul class="tab">
        <li class="on" data-tab="menu1"><a href="#">전체</a></li>
        <li data-tab="menu2"><a href="#">공연</a></li>
        <li data-tab="menu3"><a href="#">야외활동</a></li>
        <li data-tab="menu4"><a href="#">팝업스토어</a></li>
        <li data-tab="menu4"><a href="#">전시회</a></li>
    </ul>

<%--    <div id="menu1" class="tabcont on">--%>
<%--        <h3>menu1</h3>--%>
<%--        <p> This is menu1 content</p>--%>
<%--    </div>--%>
<%--    </div>--%>

    <div id="menu2" class="tabcont">
        <h3>menu2</h3>
        <p> This is menu2 content</p>
    </div>

    <div id="menu3" class="tabcont">
        <h3>menu3</h3>
        <p> This is menu3 content</p>
    </div>

    <div id="menu4" class="tabcont">
        <h3>menu4</h3>
        <p> This is menu4 content</p>
    </div>

    <!-- list -->
    <div class="gridViewContainer">
<%---------------------%>
    <c:forEach var="review" items="${__LIST__}">
        <div class="gridView-listItem">
<%--            <a href="/board/get?currPage=${pageMaker.cri.currPage}&bno=${boardVO.bno }">${ boardVO.title }</a>--%>
            <div class="gridView-tile">
                <div class="gridView-imageSection thumbnailWrap">
                    <div class="gridView-imageSectionMaskTop"></div>
                    <div class="gridView-searchHitSelect searchHitSelect">
                        <i class="fa fa-check"></i>
                    </div>
                    <div class="gridView-menu">
                        <i class="fa fa-ellipsis-v"></i>
                    </div>
                    <div class="gridView-image" style="background-image:url('https://mblogthumb-phinf.pstatic.net/MjAxNzA4MjdfMjgy/MDAxNTAzODAyNzIzNTM4.fp7hUPYdqiPc3GHMaB3-NYOpIK6ZLLC03ZKn0w03da4g.DFgtEvRePLPBvXbdQJt8XVjq6kJEXbJQ1uwUXCveoyog.JPEG.kotfa198643/lotte-world-tower-1791802_1920.jpg?type=w800');"></div>
                </div>
                <div class="gridView-detailsSection">
                    <div class="gridView-detailsTop">
                        <a class="gridView-title u-link" href="/board/review/view?seq=${review.seq }">${review.title}</a>
                    </div>
                    <div class="gridView-detailsBottom">
                        <div class="gridView-date">2 hours ago</div>
                        <div class="gridView-mediaTypeIcon">
                            <div class="heartButtonArea">
                                <label class="like-icon" title="Мне нравится!">
                                    <input class="like-button" type="checkbox">
                                    <svg class="heartSvg" clip-rule="evenodd" fill-rule="evenodd" image-rendering="optimizeQuality"
                                         shape-rendering="geometricPrecision" text-rendering="geometricPrecision" viewBox="0 0 500 500"
                                         xmlns="http://www.w3.org/2000/svg"><defs>
                                        <style type="text/css">
                                            <![CDATA[.str0 {stroke-width:15;stroke-linejoin:round}]]>
                                        </style>
                                    </defs><path class="fil0 str0" d="M412 79c-53-40-146-17-162 68-16-85-109-108-162-68-43 32-55 94-44 137 30 119 194 217 206 224 12-7 176-105 206-224 11-43-1-105-44-137z" id="Layer_x0020_1"/>
                                    </svg>
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>

    <div class="listWrap" id="list_container" style="display: block;"></div>

    <!-- pagination -->
    <div class="pagination_wrap">
        <ul class="pagination">
            <li class="fas fa-angle-left"></li>
            <li><a class="active" href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li class="fas fa-angle-right"></li>
        </ul>
        <div class="btn_wrap">
            <button class="write_btn"><a href="#">글쓰기</a></button>
        </div>
    </div>
</div>


        <jsp:include page="../../layout/footer.jsp"/>
</body>
</html>