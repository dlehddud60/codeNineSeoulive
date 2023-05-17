package org.zerock.seoulive.board.member.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.zerock.seoulive.board.member.domain.tbl_memberDTO;
import org.zerock.seoulive.board.member.domain.tbl_memberVO;
import org.zerock.seoulive.board.member.exception.ServiceException;
import org.zerock.seoulive.board.member.mapper.MemberBoardMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service("boardMemberSerivce")
public class MemberBoardServiceImpl 
	implements 
		MemberBoardSerivce,
		InitializingBean,
		DisposableBean{

	// 영속성 계층의 DAO 빈 주입 받음(Persistence)
	@Setter(onMethod_= {@Autowired})
	private MemberBoardMapper mapper;

	
	
	// 이메일 찾기 
	@Override
	public tbl_memberVO get(String email) throws ServiceException {
		log.trace("get({}) invoked.",email);
		
		try {
			return this.mapper.selectEmail(email);
		}catch(Exception e) {
			throw new ServiceException(e);
		}
		
	}	// tbl_courseVO
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
			log.trace("afterPropertiesSet() invoked.");
		
			Objects.requireNonNull(this.mapper);
			log.info("\t+ this.mapper: {}", mapper);
	} // afterPropertiesSet
	
	@Override
	public void destroy() throws Exception {
		log.trace("destroy() invoked.");
		
	}	// end destroy





	
	

}	// end class
