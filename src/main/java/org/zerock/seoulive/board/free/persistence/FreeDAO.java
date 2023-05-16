package org.zerock.seoulive.board.free.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zerock.seoulive.board.free.domain.Criteria;
import org.zerock.seoulive.board.free.domain.FreeDTO;

import java.util.List;

@Mapper
public interface FreeDAO {
    @Select("""
	         SELECT 
	         /*+ index_desc(tbl_free) */
	         *
	         FROM tbl_free
	         OFFSET (#{currPage}-1)* #{amount} ROWS
	         FETCH NEXT #{amount} ROWS ONLY
	         
	         """)
    public List<FreeDTO> getList(Criteria cri);
    public void freeInsert(FreeDTO dto);
    public FreeDTO read(int seq);
    public void delete(int seq);
    public void update(FreeDTO dto);
    public int total_count(int seq);
    @Select("SELECT count(seq) FROM tbl_free WHERE seq>0") //pk값으로 받아야해
    public abstract int getTotalAmount();

}
