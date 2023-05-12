package org.zerock.seoulive.board.free.service;

import org.zerock.seoulive.board.free.domain.FreeDTO;

import java.util.List;

public interface FreeService {
    public List<FreeDTO> getList();
    public void freeInsert(FreeDTO dto);
    public FreeDTO view(int seq);
    public void remove(int seq);
    public void modify(FreeDTO dto);
    public void total_count(int seq);



}
