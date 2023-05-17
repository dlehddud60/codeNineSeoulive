package org.zerock.seoulive.board.course.domain;

import java.util.Date;

import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Value
public class tbl_courseVO {
	private Integer seq;
	private String writer;
	private String title;
	private String review;
	private Integer total;
	private Date write_Date;
	private Date modify_Date;
	private Date duration_Start;
	private Date duration_End;
	
	public tbl_courseDTO toDTO() {
		log.trace("\t toDTO() invoked.");
		
		tbl_courseDTO dto = new tbl_courseDTO();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setReview(review);
		dto.setTotal(total);
		dto.setWrite_Date(write_Date);
		dto.setModify_Date(modify_Date);
		dto.setDuration_Start(duration_Start);
		dto.setDuration_End(duration_End);
		log.info("\t toDto : {}",dto);
		return dto;
	}	// end class
}	// end class
