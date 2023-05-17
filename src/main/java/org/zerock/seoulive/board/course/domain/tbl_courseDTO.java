package org.zerock.seoulive.board.course.domain;

import java.util.Date;

import lombok.Data;
@Data
public class tbl_courseDTO {
	private Integer seq;
	private String writer;
	private String title;
	private String review;
	private Integer total;
	private Date write_Date;
	private Date modify_Date;
	private Date duration_Start;
	private Date duration_End;
}	// end class
