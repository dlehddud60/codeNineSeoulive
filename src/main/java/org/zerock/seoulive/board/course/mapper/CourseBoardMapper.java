package org.zerock.seoulive.board.course.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.seoulive.board.course.domain.tbl_courseDTO;
import org.zerock.seoulive.board.course.domain.tbl_courseVO;

public interface CourseBoardMapper {
	
	// persistance layor
	
	// 0 현재시간 가져오기
		@Select("""
				Select 
					current_date 
				from dual
				"""
				)
		public abstract Date selectDate();
	
	// 날짜 더하기 
	@Select("""
			Select current_date+5
			From dual
			""")
	public abstract Date plusDate();
	
	// 목록 확인 
	@Select("""
			SELECT /*+ index_besc(tbl_course) */
			*
			FROM tbl_course
			""")
	public abstract List<tbl_courseVO> selectList();
	
	
	// 삽입 
	public abstract Integer insert(tbl_courseDTO dto);

	// 특정게시물 상세조회
	public abstract tbl_courseVO select(Integer seq);
	
	// 특정 게시물 삭제 
	public abstract Integer delete(Integer seq);
	
	// 특정 게시물 업데이트(갱신)
	public abstract Integer update(tbl_courseDTO dto);
	
	
}	// end interface
