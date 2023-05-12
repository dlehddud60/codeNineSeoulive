package org.zerock.seoulive.board.course.service;

import java.util.List;

import org.zerock.seoulive.board.course.domain.tbl_courseDTO;
import org.zerock.seoulive.board.course.domain.tbl_courseVO;
import org.zerock.seoulive.board.course.exception.ServiceException;

public interface CourseBoardSerivce {
	
	// write
	// 새로운 게시물 등록 기능
	public abstract Boolean write(tbl_courseDTO dto) throws ServiceException;
	
	// list
	// 게시판 목록을 얻어 반환해주는 기능 
	public abstract List<tbl_courseVO> list() throws ServiceException;
	
	// view
	// 특정 게시물 상세조회 
	public abstract tbl_courseVO view(Integer seq) throws ServiceException;

	// modify
	// 특정 게시물 수정(업데이트)
	public abstract Boolean modify(tbl_courseDTO dto) throws ServiceException;
		
	// remove
	// 특정 게시물 삭제 delete
	public abstract Boolean remove(Integer seq) throws ServiceException;
	
	
	
	
	
}	// end interface
