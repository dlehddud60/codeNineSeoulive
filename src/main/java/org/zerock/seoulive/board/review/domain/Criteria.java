package org.zerock.seoulive.board.review.domain;

import lombok.Data;

@Data
public class Criteria { //페이지 처리와 관련된 DTO
    private Integer currPage = 1;
    private Integer amount = 10;
    private Integer pagePerPage = 10;


}