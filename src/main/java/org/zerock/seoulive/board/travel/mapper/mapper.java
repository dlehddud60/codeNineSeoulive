package org.zerock.seoulive.board.travel.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.seoulive.board.travel.domain.DTO;
import org.zerock.seoulive.board.travel.domain.VO;

import java.util.List;

public interface mapper {
    @Select("""
            SELECT * FROM TBL_TRAVEL
            """)
    public abstract List<VO> selectList();

    public abstract Integer insert(DTO dto);
    @Select("""
            SELECT * FROM TBL_TRAVEL WHERE seq = #{seq}
            """)
    public abstract VO select(@Param("seq") Integer seq);
    public abstract Integer delete(Integer seq);

    public abstract Integer update(DTO dto);


} // end interface
