package org.zerock.seoulive.board.travel.service;

import org.zerock.seoulive.board.travel.domain.DTO;
import org.zerock.seoulive.board.travel.domain.VO;

import java.util.List;

public interface service {

    public abstract List<VO> getList();

    public abstract Boolean register(DTO dto);
    public abstract VO get(Integer seq);
    public abstract Boolean modify(DTO dto);
    public abstract Boolean remove(Integer seq);


} // end interface
