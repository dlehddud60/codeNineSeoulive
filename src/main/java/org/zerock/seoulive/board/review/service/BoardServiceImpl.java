package org.zerock.seoulive.board.review.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.review.domain.BoardDTO;
import org.zerock.seoulive.board.review.domain.BoardVO;
import org.zerock.seoulive.board.review.domain.Criteria;
import org.zerock.seoulive.board.review.exception.ServiceException;
import org.zerock.seoulive.board.review.mapper.BoardMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@Service("BoardService")
public class BoardServiceImpl
        implements
        BoardService,
        InitializingBean,
        DisposableBean {

    @Setter(onMethod_ = {@Autowired})
    private BoardMapper dao;	// 영속성 계층의 DAO빈 주입받음

    // 1. 게시판 목록 얻어 반환해주는 기능 수행
    @Override
    public List<BoardVO> getList(Criteria cri) throws ServiceException {
        log.trace("\n\t getList() invoked.");

        try {
            return this.dao.selectList();

        }	catch(Exception e) {
            throw new ServiceException(e);
        }
    }	//	getList
    // 2. 새로운 게시물 등록 기능 수행(CREATE)
    @Override
    public Boolean register(BoardDTO dto) throws ServiceException {
        log.trace("\n\t register({}) invoked.",dto);

        try {
            return (this.dao.insert(dto)==1);

        }	catch(Exception e) {
            throw new ServiceException(e);
        }
    }	//	register
    // 3. 특정 게시물 상세조회(read)
//    @Override
//    public BoardVO get(Integer seq) throws ServiceException{
//        log.trace("\n\t BoardVO({}) invoked.",seq);
//
//
//        try {
//            return this.dao.select(seq);
//
//        }	catch(Exception e) {
//            throw new ServiceException(e);
//        }
//    }	//	get

    @Override
    public BoardVO get(Integer seq) throws ServiceException{
        log.trace("\n\t BoardVO({}) invoked.",seq);
        BoardVO boardVO = dao.select(seq);
        return boardVO;
    }	//	get



    // 4. 특정 게시물 업데이트(update)
    @Override
    public Boolean modify(BoardDTO dto) throws ServiceException {
        log.trace("\n\t modify({}) invoked.",dto);

        try {
            return (this.dao.update(dto)==1);

        }	catch(Exception e) {
            throw new ServiceException(e);
        }	}	//	modify

    // 5. 특정 게시물 삭제(DELETE)
    @Override
    public Boolean remove(Integer seq) throws ServiceException {
        log.trace("\n\t remove({}) invoked.",seq);

        try {
            return (this.dao.delete(seq)==1);

        }	catch(Exception e) {
            throw new ServiceException(e);
        }	}	//	remove

//	===================InitializingBean,DisposableBean ==========//


    @Override
    public void afterPropertiesSet() throws Exception { // 초기화(=전처리)
        log.trace("\n\t afterPropertiesSet() invoked.");

//		assert this.dao != null;
        Objects.requireNonNull(this.dao);
        log.info("\n\t this.dao : {} ",dao);
    }	// afterPropertiesSet
    @Override
    public void destroy() throws Exception { // 자원해제(=후처리)
        log.trace("\n\t destroy() invoked.");

    }	// destroy

    @Override
    public Integer getTotal() throws ServiceException {
        log.trace("getTotal() invoked");


        return this.dao.getTotalAmount();
    } // getTotal

}	// end class