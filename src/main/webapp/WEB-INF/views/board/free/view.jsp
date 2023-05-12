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
<div class="wrapper">
    <div class="title">
        <h1 class="title_name">${dto.title}</h1>
        <div class="head_line">
            <div id="writer_container">
                <span class="writer_picture"><i class="fas fa-user"></i>프로필사진</span>
                <span id="writer"></span>
            <span id="area_profile"></span>
            <span id="nick"></span>
          </span>
                <i class="fas fa-circle">${dto.writer}</i>
                <span id="publish_date"><fmt:formatDate value="${dto.write_date}" pattern="yyyy-MM-dd"/></span>
                <span id="watch_count">${dto.total_count}</span>
            </div>
            <div class="title_function">
                <a href="#" id="copyBtn" class="url_setClipboard" title="" style="cursor:pointer;">
                    <i class="fas fa-share-nodes"></i>URL 복사
                </a>
                <a href="#" class="buddyBtn"><i class="fas fa-user"></i></a>팔로우


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


                </button>
            </div>
        </div>
    </div>



    <div class="content">${dto.content}</div>

    <div class="viewBtn">
        <ul class="btnList">
            <li><a href="#">삭제</a></li>
            <li><a href="#">수정</a></li>
            <li><a href="#">목록</a></li>
        </ul>
    </div>

    <div class="comment">
        <div class="comment_top">
            댓글
        </div>
        <div class="comment_mid">
            <input class="comment_box" type="text" value="댓글을 남겨주세요.">
            <input class="comment_upload" type="button" value="등록">
        </div>
        <div class="comment_bottom">
            <ul class="comment_bot_wrap">
                <img src="/seoullive2/img/KakaoTalk_20230407_144432323.png" alt="">
                <li class="comment_id">user1</li>
                <li class="comment_cont">댓글내용</li>
            </ul>
            <ul class="comment_bot_wrap">
                <img src="/seoullive2/img/KakaoTalk_20230407_144432323.png" alt="">
                <li class="comment_id">user1</li>
                <li class="comment_cont">댓글내용</li>
            </ul>
            <ul class="comment_bot_wrap">
                <img src="/seoullive2/img/KakaoTalk_20230407_144432323.png" alt="">
                <li class="comment_id">user1</li>
                <li class="comment_cont">댓글내용</li>
            </ul>
        </div>
    </div>

</div>
<script src="/js/reviewvi.js" defer></script>
<jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</body>


</html>