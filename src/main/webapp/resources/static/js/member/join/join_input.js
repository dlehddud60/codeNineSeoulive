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

// 이메일 인증
$('#mail_check_btn').click(function() {
    const email = $('#user_email').val(); // 이메일 주소값 얻어오기!
    console.log('완성된 이메일 : ' + email); // 이메일 오는지 확인
    const checkInput = $('#mail_check_input'); // 인증번호 입력하는곳

    $.ajax({
        type : 'get',
        url : '<c:url value ="/member/join/register/mailCheck?email="/>'+email, // GET 방식이라 Url 뒤에 email을 붙힐 수 있다.
        success : function (data) {
            console.log("data : " +  data);
            checkInput.attr('disabled', false);
            code = data;
            alert('인증번호가 전송되었습니다.')
        }
    }); // end ajax
}); // end send email
