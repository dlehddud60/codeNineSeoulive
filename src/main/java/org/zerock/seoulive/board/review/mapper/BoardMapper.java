package org.zerock.seoulive.board.review.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zerock.seoulive.board.review.domain.BoardDTO;
import org.zerock.seoulive.board.review.domain.BoardVO;
import org.zerock.seoulive.board.review.domain.Criteria;

import java.util.List;

@Mapper
public interface BoardMapper {   //CRUD 를 해볼까 ?

    public abstract List<BoardVO> getLists(Criteria cri);

    //Create를 해보자
    @Select("""
			SELECT /*+ index_desc(TBL_REVIEW) */ *
			FROM TBL_REVIEW
			""")
    public abstract  List<BoardVO> selectList();

    //새로운개시물 등록
    @Insert("INSERT INTO TBL_REVIEW (seq,title,content,writer,place) VALUES (seq_tbl_review.nextval,#{title},#{content},#{writer},#{place}) ")
    public abstract Integer insert( BoardDTO dto);

    //특정개시물 상세조회
    @Select("SELECT * FROM TBL_REVIEW WHERE SEQ = #{seq} ORDER BY SEQ desc")
    public abstract BoardVO select(Integer seq);

    //특정게시물 삭제
    public abstract Integer delete(Integer seq);

    // 5. 특정 게시물 업데이트(갱신)
    public abstract Integer update(BoardDTO dto);

    //6.요청시점에 총 게시물 개수를 반환
    @Select("SELECT count(seq) FROM TBL_REVIEW WHERE seq>0") //pk값으로 받아야해
    public abstract Integer getTotalAmount();



}
