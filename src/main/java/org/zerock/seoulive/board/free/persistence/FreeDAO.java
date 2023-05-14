package org.zerock.seoulive.board.free.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.seoulive.board.free.domain.FreeDTO;

import java.util.List;

@Mapper
public interface FreeDAO {
    public List<FreeDTO> getList();
    public void freeInsert(FreeDTO dto);
    public FreeDTO read(int seq);
    public void delete(int seq);
    public void update(FreeDTO dto);
    public int total_count(int seq);

}
