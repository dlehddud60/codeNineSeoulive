package org.zerock.seoulive.board.travel.service;

import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.board.travel.domain.DTO;
import org.zerock.seoulive.board.travel.domain.VO;
import org.zerock.seoulive.board.travel.mapper.mapper;

import java.util.List;

@Service("service")
public class serviceImpl implements service {

    @Setter(onMethod_ ={@Autowired})
    private mapper dao;

    @Override
    public List<VO> getList() {
        return this.dao.selectList();
    }

    @Override
    public Boolean register(DTO dto) {
        return this.dao.insert(dto) == 1;
    }

    @Override
    public VO get(Integer seq) {
        return this.dao.select(seq);
    }

    @Override
    public Boolean modify(DTO dto) {
        return this.dao.update(dto) == 1;
    }

    @Override
    public Boolean remove(Integer seq) {
        return this.dao.delete(seq) == 1;
    }
}
