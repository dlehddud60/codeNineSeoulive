package org.zerock.seoulive.board.free.domain;

import lombok.Data;

@Data
public class Criteria {
    //For Fetching records according to the currPage
    private Integer currPage=1;   		//현재 페이지 번호
    private Integer amount=10;			//한페이지당 게시물 개수

    //--For Pagenation
    private Integer pagesPerPage =10;   //한 페이지당 보여줄 페이지목록의 길이
}
