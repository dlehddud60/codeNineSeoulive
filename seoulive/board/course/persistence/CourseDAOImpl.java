package org.zerock.seoulive.board.course.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.seoulive.board.course.domain.CoursePageTO;
import org.zerock.seoulive.board.course.domain.CourseTravelVO;
import org.zerock.seoulive.board.course.domain.CourseVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor

@Repository("courseDAO")
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CourseVO> courseList(CoursePageTO page) {
		return sqlSession.selectList("courseList", page);
	}

	@Override
	public int getTotalAmount() {
		return sqlSession.selectOne("getTotalAmount");
	}

	@Override
	public List<CourseTravelVO> selectTravelList(CourseVO vo) {
		return sqlSession.selectList("selectTravelList", vo);
	}

	@Override
	public List<CourseVO> searchCourse(Integer currPage, Integer amount, String searchType, String keyword) {
		log.trace("searchCourse() invoked.");
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("currPage", currPage);
		paramMap.put("amount", amount);
		paramMap.put("category", searchType);
        paramMap.put("keyword", keyword);
        log.info(paramMap);
        
        return sqlSession.selectList("searchCourse", paramMap);
	}

	@Override
	public int getTotalSearch(String searchType, String keyword) {

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("category", searchType);
        paramMap.put("keyword", keyword);
		return sqlSession.selectOne("getTotalSearch", paramMap);
	}

}
