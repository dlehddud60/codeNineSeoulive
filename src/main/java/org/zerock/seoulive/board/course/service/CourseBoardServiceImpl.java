package org.zerock.seoulive.board.course.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.course.domain.tbl_courseDTO;
import org.zerock.seoulive.board.course.domain.tbl_courseVO;
import org.zerock.seoulive.board.course.exception.ServiceException;
import org.zerock.seoulive.board.course.mapper.CourseBoardMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service("boardCourseSerivce")
public class CourseBoardServiceImpl 
	implements 
		CourseBoardSerivce,
		InitializingBean,
		DisposableBean{

	// 영속성 계층의 DAO 빈 주입 받음(Persistence)
	@Setter(onMethod_= {@Autowired})
	private CourseBoardMapper dao;
	
	// 게시물 쓰기 
	@Override
	public Boolean write(tbl_courseDTO dto) throws ServiceException {

		log.trace("\t write tbl_courseDTO invoked({}) ", dto);
		
		try {
			return this.dao.insert(dto)==1;
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
		
	}	// end write
	
	// 목록 보기 
	@Override
	public List<tbl_courseVO> list() throws ServiceException {
		
		log.trace("\t getList() invoked.");
		
		try {
			return this.dao.selectList();
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
	}	// end list
	
	// 특정 게시물 보기!
	@Override
	public tbl_courseVO view(Integer seq) throws ServiceException {
		log.trace("\t view : {} invoked.",seq);
		
		try {
			return this.dao.select(seq);
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
			
	}	// end view 

	@Override
	public Boolean modify(tbl_courseDTO dto) throws ServiceException {
		
		log.trace("\t modify : {} invoked.",dto);
		
		try {
			return this.dao.update(dto)==1;
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
	}	// end modify

	@Override
	public Boolean remove(Integer seq) throws ServiceException {
		
		log.trace("\t remove : {} invoked.",seq);
		try {
			return this.dao.delete(seq) == 1;
		}catch(Exception e) {
			throw new ServiceException(e);
		}	// end try-catch
	}	// end remove
	
//	======================================

	@Override
	public void afterPropertiesSet() throws Exception {

		// 초기화(전처리) 
		log.trace("\t afterPropertiesSet() invoked.");
		
		Objects.requireNonNull(this.dao);
		log.info("\t {} : {}",this.dao.toString().getClass().getName(),this.dao);
		
	}	// end afterPropertiesSet
	
	@Override
	public void destroy() throws Exception {

		//자원해제(후처리)
		log.trace("\t destroy () invoked.");
		
	}	// end destroy

}	// end class
