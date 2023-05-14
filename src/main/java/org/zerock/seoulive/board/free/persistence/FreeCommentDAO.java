package org.zerock.seoulive.board.free.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.seoulive.board.free.domain.FreeCommentDTO;

import java.util.List;

@Mapper
public interface FreeCommentDAO {
    List<FreeCommentDTO> freeCommentList(int seq);

}
