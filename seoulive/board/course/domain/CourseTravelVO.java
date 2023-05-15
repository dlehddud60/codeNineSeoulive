package org.zerock.seoulive.board.course.domain;


import lombok.Value;

@Value
public class CourseTravelVO {
    private Integer SEQ;
    private Integer BOARD_SEQ;
    private Integer TRAVEL_SEQ;
    private Integer UPLOAD_SEQ;
    private String LINK;
    private String USER_REVIEW;

} // end class
