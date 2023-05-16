$(function (){
    $('.pageNum').on('click', function(e){
        // console.log('pageNum Clicked....')
        let selectedPageNum = e.currentTarget.textContent
        // console.log(selectedPageNum);

        location.href = "/board/free/list?currPage=" + selectedPageNum;
    }); // onclick
}); //jq