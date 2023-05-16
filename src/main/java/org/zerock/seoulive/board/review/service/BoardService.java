package org.zerock.seoulive.board.review.service;

import org.zerock.seoulive.board.review.domain.BoardDTO;
import org.zerock.seoulive.board.review.domain.BoardVO;
import org.zerock.seoulive.board.review.domain.Criteria;
import org.zerock.seoulive.board.review.exception.ServiceException;

import java.util.List;

public interface BoardService {

    // 1. 게시판 목록 얻어 반환해주는 기능 수행
    public abstract List<BoardVO> getList(Criteria cri) throws ServiceException;

    // 2. 새로운 게시물 등록 기능 수행(CREATE)
    public abstract Boolean register(BoardDTO dto)throws ServiceException;

    // 3. 특정 게시물 상세조회(read)
    public abstract BoardVO get(Integer seq) throws ServiceException ;

    // 4. 특정 게시물 업데이트(update)
    public abstract Boolean modify(BoardDTO dto) throws ServiceException;

    // 5. 특정 게시물 삭제(DELETE)
    public abstract Boolean remove(Integer seq)throws ServiceException;

    // 6. 총 게시물 개수 반환
    public abstract Integer getTotal() throws ServiceException;


}
