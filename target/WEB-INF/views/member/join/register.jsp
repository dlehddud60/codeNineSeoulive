<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입</title>

  <link rel="stylesheet" href="../../../../resources/static/css/member/join/join_input.css">
  <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css">

  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

  <script src="https://kit.fontawesome.com/507ab4987a.js" crossorigin="anonymous"></script>
</head>

<jsp:include page="../../layout/header.jsp"/>

<body>

<form action="${path}/member/join/register" method="post">
  <div class="join_container">
    <div class="join_container inner">
      <!-- <div class="join_wrap">
          <p>아이디</p>
          <div class="join_btn_wrap">
              <input type="text" placeholder="영문/숫자 5~11자">
              <button class="btn">중복확인</button>
              <div class="error_message"></div>
          </div>
      </div> -->

      <div class="join_wrap">
        <p>이메일</p>
        <div class="join_btn_wrap">
          <input name="email_id" type="email" placeholder="example@example.com">
          <div>
            <button class="btn">이메일 인증</button>
          </div>
        </div>
        <div class="join_btn_wrap">
          <input name="email_id" type="email" placeholder="인증번호 입력" style="margin: 3px auto;">
          <div>
            <button class="btn">인증 확인</button>
          </div>
          <div class="error_message"></div>
        </div>
      </div>

      <div class="join_wrap">
        <p>비밀번호</p><input type="password" name="password" placeholder="영문/숫자/특수문자 8~16자" style="margin: 3px auto;">
        <input type="password" name="password" placeholder="비밀번호 확인">
        <div class="error_message"></div>
      </div>

      <div class="join_wrap">
        <p>이름</p>
        <input type="text" placeholder="이름">
        <div class="error_message"></div>
      </div>

      <div class="join_wrap">
        <p>생년월일</p>
        <div class="join_wrap_birth">
          <input type="number" min="1900" max="2023" placeholder="년(4자)">
          <div data-value="month" class="selection_list_warp">
            <li data-value="month" class="selection_item">
              월 <i class="fas fa-angle-down"></i>
            </li>
            <ul data-value="month" class="selection_list">
              <li><button type="button">월</button></li>
              <li><button type="button">1월</button></li>
              <li><button type="button">2월</button></li>
              <li><button type="button">3월</button></li>
              <li><button type="button">4월</button></li>
              <li><button type="button">5월</button></li>
              <li><button type="button">6월</button></li>
              <li><button type="button">7월</button></li>
              <li><button type="button">8월</button></li>
              <li><button type="button">9월</button></li>
              <li><button type="button">10월</button></li>
              <li><button type="button">11월</button></li>
              <li><button type="button">12월</button></li>
            </ul>
          </div>
          <input type="number" max="31" placeholder="일">
          <div class="error_message"></div>
        </div>
      </div>

      <div class="join_wrap">
        <p>성별</p>
        <div class="selection_list_warp">
          <li class="selection_item">성별<i class="fas fa-angle-down"></i></li>
          <ul class="selection_list">
            <li><button type="button">성별</button></li>
            <li><button type="button">남</button></li>
            <li><button type="button">여</button></li>
          </ul>
        </div>
      </div>

    </div>

    <div class="join_container inner">
      <div class="join_wrap profile">
        <p>프로필 설정</p>
        <img src="../../../../resources/static/img/profile.png">
        <div id="image_container"></div>
      </div>

      <div class="upload_image">
        <input type="file" id="select_image" accept="image/*" onchange="setThumbnail(event);"
               style="width: 0; height: 0;" />
        <label for="select_image">프로필 사진 업로드</label>
      </div>

      <div class="join_wrap">
        <p>닉네임</p>
        <div class="join_btn_wrap">
          <input type="text" placeholder="4~10자">
          <button class="btn">중복확인</button>
        </div>
      </div>

      <div class="join_wrap">
        <p>소개글</p>
        <input type="text" placeholder="100자 이내 입력">
      </div>

      <div class="join_wrap">
        <p><input type="checkbox" id="terms">
          <label for="terms">이용약관과 개인정보 취급방침을 확인하고 이에 동의합니다.</label>
          <a href="#">(전체 약관보기)</a></p>
      </div>

      <div class="join_button">
        <input type="submit" id="join_btn" name="join_btn" value="가입하기">
      </div>
    </div>
  </div>
</form>


<script>

  // 프로필 사진 미리보기
  function setThumbnail(event) {
    var reader = new FileReader();

    reader.onload = function (event) {
      var img = document.createElement("img");
      img.setAttribute("src", event.target.result);
      document.querySelector("div#image_container").appendChild(img);
    };

    reader.readAsDataURL(event.target.files[0]);
  }

  // 리스트 펼치기
  $('.selection_item').each(function () {
    $(this).click(function () {
      $(this).toggleClass('on');
    });
  });
  $('.selection_list').each(function() {
    $(this).children('li').click(function(event) {
      $(this).parent().prev().text($(this).children().text());
      $(this).parent().prev().removeClass('on');
    });
  });

  // input 정보 가져오기
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });

</script>

</body>

<jsp:include page="../../layout/footer.jsp"/>

</html>