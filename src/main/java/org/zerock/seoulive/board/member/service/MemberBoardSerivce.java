package org.zerock.seoulive.board.member.service;


import java.util.List;

import org.zerock.seoulive.board.member.domain.tbl_memberVO;
import org.zerock.seoulive.board.member.exception.ServiceException;




public interface MemberBoardSerivce {
	
		
		
		// 이메일 찾기 
		public abstract tbl_memberVO get(String email) throws ServiceException;
		
		
	
	
}	// end interface
