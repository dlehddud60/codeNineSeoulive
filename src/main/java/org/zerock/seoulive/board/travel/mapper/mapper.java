package org.zerock.seoulive.board.travel.mapper;

import org.zerock.seoulive.board.travel.domain.DTO;
import org.zerock.seoulive.board.travel.domain.VO;

import java.util.List;

public interface mapper {

    public abstract List<VO> selectList();

    public abstract Integer insert(DTO dto);
    public abstract VO select(Integer seq);
    public abstract Integer delete(Integer seq);
    public abstract Integer update(DTO dto);


} // end interface
