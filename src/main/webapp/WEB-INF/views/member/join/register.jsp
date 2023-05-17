<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

      <script defer src="../../../../resources/static/js/member/join/join_input.js"></script>
      <script defer src="../../../../resources/static/img/profile.png"></script>

      <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
      <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

      <script src="https://kit.fontawesome.com/507ab4987a.js" crossorigin="anonymous"></script>
    </head>

    <jsp:include page="../../layout/header.jsp" />

    <body>

      <form action="/member/join/register" method="post">
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
                <input type="email" name="email" id="email" placeholder="example@example.com" required>
                <div>
                  <button type="button" class="btn" name="mail_check_btn" id="mail_check_btn">이메일 인증</button>
                </div>
              </div>
              <div class="join_btn_wrap">
                <input name="mail_check_input" id="mail_check_input" placeholder="인증번호 입력" disabled="disabled" maxlength="6" required style="margin: 3px auto;">
                <!--          <div>-->
                <!--            <button type="button" class="btn">인증 확인</button>-->
                <!--          </div>-->
              </div>
              <span id="emailError"></span>
            </div>

            <div class="join_wrap">
              <p>비밀번호</p>
              <input type="password" name="password" id="password" placeholder="영문/숫자/특수문자 10자 이상 20자 이하" required
                style="margin: 3px auto;">
              <input type="password" id="password_check" placeholder="비밀번호 확인" required>
              <span id="pwError"></span>
            </div>

            <!-- <div class="join_wrap">
              <p>이름</p>
              <input type="text" placeholder="이름">
              <div class="error_message"></div>
            </div> -->

            <!-- <div class="join_wrap">
              <p>생년월일</p>
              <div class="join_wrap_birth">
                <input type="number" name="brithYear" min="1900" max="2023" placeholder="년(4자)">
                <div class="selection_list_warp" style="z-index: 100">
                  <input type="hidden" name="birthMonth">
                  <li class="selection_item">
                    월 <i class="fas fa-angle-down"></i>
                  </li>
                  <ul class="selection_list" style="height: 250px;">
                    <li><button type="button">월</button></li>
                    <li><button type="button" value="01">1월</button></li>
                    <li><button type="button" value="02">2월</button></li>
                    <li><button type="button" value="03">3월</button></li>
                    <li><button type="button" value="04">4월</button></li>
                    <li><button type="button" value="05">5월</button></li>
                    <li><button type="button" value="06">6월</button></li>
                    <li><button type="button" value="07">7월</button></li>
                    <li><button type="button" value="08">8월</button></li>
                    <li><button type="button" value="09">9월</button></li>
                    <li><button type="button" value="10">10월</button></li>
                    <li><button type="button" value="11">11월</button></li>
                    <li><button type="button" value="12">12월</button></li>
                  </ul>
                </div>
                <input type="number" name="birthDay" id="birthDay" max="31" placeholder="일" onchange="inputValueChange()">
                <div class="error_message"></div>
              </div>
            </div> -->

            <div class="join_wrap">
              <p>생년월일</p>
              <div><input type="text" id="birthDate" name="birthDate" placeholder="예)19990101" maxlength="8" required></div>
              <span id="birthError"></span>
            </div>

            <div class="join_wrap">
              <p>성별</p>
              <div class="selection_list_warp">
                <input type="text" id="gender" name="gender" required style="display: none">
                <li class="selection_item">성별<i class="fas fa-angle-down"></i></li>
                <ul class="selection_list">
                  <li><button type="button">성별</button></li>
                  <li><button type="button">남</button></li>
                  <li><button type="button">여</button></li>
                </ul>
              </div>
              <span id="genderError"></span>
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
                <input type="text" id="nickName" name="nickName" placeholder="2~12자" required>
                <button type="button" class="btn">중복확인</button>
              </div>
              <span id="nickError"></span>
            </div>

            <div class="join_wrap">
              <p>소개글</p>
              <input type="text" name="introduction" placeholder="100자 이내 입력 (선택)">
            </div>

            <div class="join_wrap">
              <p><input type="checkbox" id="terms">
                <label for="terms">이용약관과 개인정보 취급방침을 확인하고 이에 동의합니다.</label>
                <a href="#">(전체 약관보기)</a></p>
              <span id="termsError"></span>
            </div>

            <div class="join_button">
              <input type="submit" id="join_btn" value="가입하기">
            </div>
          </div>
        </div>
      </form>

      <script>
        // 이메일 인증
        $('#mail_check_btn').click(function () {
          const email = $('#email').val(); // 이메일 주소값 얻어오기
          console.log('완성된 이메일 : ' + email); // 이메일 오는지 확인
          const checkInput = $('#mail_check_input'); // 인증번호 입력하는곳

          $.ajax({
            type: 'get',
            url: '<c:url value ="/member/join/register/mailCheck?email="/>' + email, // GET방식이라 Url 뒤에 email을 뭍힐수있다.
            success: function (data) {
              console.log("data : " + data);
              checkInput.attr('disabled', false);
              code = data;
              alert('인증번호가 전송되었습니다.')
            }
          }); // end ajax
        }); // end send email

        // 인증번호 비교
        $('#mail_check_input').blur(function () {
          const inputCode = $(this).val();
          const $resultMsg = $('#emailError');

          if (inputCode === code) {
            $resultMsg.html('인증번호가 일치합니다.');
            $resultMsg.css('color', 'green');
            $('#mail_check_btn').attr('disabled', true);
            $('#email').attr('readonly', true);
          } else {
            $resultMsg.html('인증번호가 불일치 합니다. 다시 확인해주세요.');
            $resultMsg.css('color', 'red');
          }
        });

      </script>

    </body>

    <jsp:include page="../../layout/footer.jsp" />

    </html>