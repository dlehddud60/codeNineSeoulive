package org.zerock.seoulive.member.join.service;

import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.domain.UserVO;
import org.zerock.seoulive.member.join.exception.ServiceException;
import org.zerock.seoulive.member.join.domain.UserDTO;

import java.util.List;

public interface UserService {

    // 1. 게시판 목록을 얻어 반환해주는 기능 수행
//    public abstract List<UserVO> getList() throws ServiceException;

    // 2. 새로운 게시물 등록 기능 수행 (CREATE)
    public abstract Boolean register(UserDTO dto) throws ServiceException;

    // 3. 특정 게시물 상세조회 (READ)
//    public abstract UserVO get(Integer bno) throws ServiceException;

    // 4. 특정 게시물 업데이트 (UPDATE)
//    public abstract Boolean modify(UserDTO dto) throws ServiceException;

    // 5. 특정 게시물 삭제 (DELETE)
//    public abstract Boolean remove(Integer bno) throws ServiceException;

} // end interface
