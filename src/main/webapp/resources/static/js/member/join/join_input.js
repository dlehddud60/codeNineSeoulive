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
$('.selection_list').each(function () {
    $(this).children('li').click(function (event) {
        // const value = parseInt($(this).children().val(),10);
        const value = $(this).children().text();
        console.log(value);

        $('input[name=gender]').attr('value', value);
        $(this).parent().prev().text($(this).children().text());
        $(this).parent().prev().removeClass('on');
    });
});
function inputValueChange() {
    var birthDay = document.getElementById('#birthDay');
    birthDay.value = birthDay.padStart(2, '0');
}
