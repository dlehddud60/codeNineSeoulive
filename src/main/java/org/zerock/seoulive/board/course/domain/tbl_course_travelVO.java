package org.zerock.seoulive.board.course.domain;

import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Value
@Log4j2
public class tbl_course_travelVO {
	private Integer seq;
	private Integer boardSeq;
	private Integer travelSeq;
	private Integer uploadSeq;
	private String link;
	private String userReview;
	
	public tbl_course_travelDTO toDTO() {
		log.trace("toDTO() invoked.");
		
		tbl_course_travelDTO dto = new tbl_course_travelDTO();
		
		dto.setSeq(seq);
		dto.setBoardSeq(boardSeq);
		dto.setTravelSeq(travelSeq);
		dto.setUploadSeq(uploadSeq);
		dto.setLink(link);
		dto.setUserReview(userReview);
		
		log.info("\t dto : {}",dto);
		
		return dto;
	}	// end toDTO
}	// end class
