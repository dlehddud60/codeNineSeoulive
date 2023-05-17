package org.zerock.seoulive.board.travel.domain;

import lombok.Data;

import java.util.Date;

@Data
public class DTO {

    private Integer seq;
    private String writer;
    private String category;
    private String title;
    private String content;
    private String address;
    private Integer total;




} // end class