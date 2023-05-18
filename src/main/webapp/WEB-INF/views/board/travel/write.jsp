<%--
  Created by IntelliJ IDEA.
  User: sungjaehyun
  Date: 2023/05/15
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>여행지 write</title>

  <link rel="stylesheet" href="../../../../resources/static/css/travel/write.css"/>
  <link rel="stylesheet" href="../../../../resources/static/css/layout/layout.css"/>

  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

  <script>
    $(function() {
      $('.cancelBtn').click(function() {

        <%--location.href = "/board/travel/list?currPage=${param.currPage}";--%>
        location.href = "/board/travel/list";

      });

    });
  </script>


  <jsp:include page="../../layout/header.jsp"/>
</head>
<body>
<form action="/board/travel/write" method="post">

  <!-- 글쓰기 헤더 -->
  <div class="travel_header">
    <h2>여행지 글쓰기</h2>
  </div>
  <hr>
  <!-- 제목 -->
  <div class="travel_title">
    <input type="text" placeholder=" 제목을 입력해 주세요." autofocus>
  </div>

  <!-- 카테고리 -->
  <div class="travel_category">
    <h3>카테고리</h3>
  </div>
  <hr>
  <div class="travel_thema">

    <label for="travelplace"><input type="checkbox" id="travelplace" value="travel" name="thema"><span>야외활동</span></label>
    /
    <label for="show"><input type="checkbox" id="show" value="travel" name="thema"><span>공연</span></label>
    /
    <label for="exhibition"><input type="checkbox" id="exhibition" value="exhibition" name="thema"><span>전시회</span></label>
    /
    <label for="popup"><input type="checkbox" id="popup" value="popup" name="thema"><span>팝업스토어</span></label>
  </div>

  <!-- 캘린더 내용 -->
  <div class="cal_input">
    <div class="cal_date_input">
      <label for="date_from"> 시작일자 </label>
      <input type="date" class="date_input">
      <br>
      <label for="date_to"> 종료일자 </label>
      <input type="date" class="date_input">
      <br>
    </div>
    <div class="cal_time_input">
      <label for="start_time">시작시간 </label>
      <input type="time" class="time_input">
      <br>
      <label for="end_time"> 종료시간 </label>
      <input type="time" class="time_input">
      <br>
    </div>
  </div>

  <!-- 본문 -->
  <div class="content">
    <textarea placeholder=" 내용을 입력해주세요."></textarea>
  </div>

  <div class="location">
    <label>위치 </label><input type="text" placeholder="주소 노출">
  </div>

  <!-- 첨부파일 -->
  <div class="file_upload">
    <label for="">사진</label>
    <div>
      <button class="upload"></button>
      <input type="file" class="real-upload" accept="image/*" style="display: none;" required multiple>
      <ul class="image-preview">
      </ul>
    </div>
  </div>
<%--  <div id="preview_imgs"></div>--%>
<%--  <div class="travel_filebox">--%>
<%--    <label for="select_image">사진 선택</label>--%>
<%--    <input type="file" id="select_image" accept="image/*" onchange="imageChange(event);" multiple="multiple">--%>
<%--  </div>--%>

  <!-- 버튼 -->
  <div class="btn">
    <div class="btn_accent">
      <a href="" onclick=""><button>작성하기</button></a>
    </div>
    <div class="btn_cancel">
      <a href="" onclick=""><button>취소</button></a>
    </div>
  </div>
</form>


<%--<script>--%>
<%--  // 이미지 미리보기--%>
<%--  function imageChange(event){--%>
<%--    let i = event.target.files.length-1;--%>
<%--    for(let image of event.target.files){--%>
<%--      let img = document.createElement("img");--%>
<%--      const reader = new FileReader();--%>
<%--      reader.onload = function(event){--%>
<%--        img.setAttribute("src", event.target.result);--%>
<%--      }--%>
<%--      reader.readAsDataURL(event.target.files[i--]);--%>
<%--      document.querySelector("#preview_imgs").appendChild(img);--%>
<%--    }--%>
<%--  }--%>
<%--</script>--%>

<script>

  function getImageFiles(e) {
    const uploadFiles = [];
    const files = e.currentTarget.files;
    const imagePreview = document.querySelector('.image-preview');
    const docFrag = new DocumentFragment();


    // 업로드 파일 수가 여러장 이상인 경우 경고 메시지 출력
    if ([...files].length > 1) {
      alert('이미지는 한개씩 업로드 가능합니다.');
      return;
    }

    // 업로드 파일 중 이미지 파일이 아닌 경우 경고 메시지 출력
    for (let i = 0; i < files.length; i++) {
      if (!files[i].type.match("image/.*")) {
        alert('이미지 파일만 업로드 가능합니다.');
        return;
      }
    }

    for (let i = 0; i < files.length; i++) {
      // 업로드 파일 수가 1장 이하인 경우에만 파일 추가
      if (uploadFiles.length < 1) {
        uploadFiles.push(files[i]);
        const reader = new FileReader();
        reader.onload = (e) => {
          const preview = createElement(e, files[i]);
          imagePreview.appendChild(preview);
        };
        reader.readAsDataURL(files[i]);
      }
    }
  }

  function createElement(e, file) {
    const li = document.createElement('li');
    const img = document.createElement('img');
    img.setAttribute('src', e.target.result);
    img.setAttribute('data-file', file.name);
    li.appendChild(img);
    return li;
  }

  const realUpload = document.querySelector('.real-upload');
  const upload = document.querySelector('.upload');



  upload.addEventListener('click', () => realUpload.click());

  realUpload.addEventListener('change', getImageFiles);
</script>

</body>
  <jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
</html>