<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 헤더 시작 -->
<div id="header">
    <div class="wrap">
        <h1 class="logo">
            <a href="#"><img src="../../../resources/static/img/img-logo.png" width="240" height="60"></a>
        </h1>
        <ul class="bn">
            <a href="#" class="fl">
                <li>여행지</li>
            </a>
            <a href="#" class="fl">
                <li>일정</li>
            </a>

            <a href="#" class="fl">
                <li>자유게시판</li>
            </a>

        </ul>

        <ul class="bn">

            <a href="#" class="fr" id="logoutBtn">
                <li>로그아웃</li>
            </a>

        </ul>

    </div>

</div>

<script>
    $(function () {

        $('#logoutBtn').on('click', function () {
            self.location.href = '/member/logout';    // GET, /user/logout
        }); // .onclick

    }); // .jq
</script>
<!-- 헤더 끝 -->
