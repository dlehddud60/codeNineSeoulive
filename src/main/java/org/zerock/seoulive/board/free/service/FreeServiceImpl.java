package org.zerock.seoulive.board.free.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.free.domain.FreeDTO;
import org.zerock.seoulive.board.free.persistence.FreeDAO;

import java.util.List;

@Service
public class FreeServiceImpl implements FreeService{

    @Autowired
    FreeDAO freeDAO;

//    public FreeServiceImpl(FreeDAO freeDAO) {
//        this.freeDAO = freeDAO;
//    }

    @Override
    public List<FreeDTO> getList() {
        List<FreeDTO> list = freeDAO.getList();
        return list;
    }
    @Override
    public void freeInsert(FreeDTO dto) {
        freeDAO.freeInsert(dto);
    }

    @Override
    public FreeDTO view(int seq) {
        FreeDTO dto = freeDAO.read(seq);
        return dto;
    }

    @Override
    public void remove(int seq) {
        freeDAO.delete(seq);
    }

    @Override
    public void modify(FreeDTO dto) {
        freeDAO.update(dto);
    }

    @Override
    public void total_count(int seq) {
        freeDAO.total_count(seq);
    }
}
