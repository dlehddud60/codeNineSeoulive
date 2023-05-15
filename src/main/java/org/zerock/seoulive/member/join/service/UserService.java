package org.zerock.seoulive.member.join.service;

import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.exception.ServiceException;

public interface UserService {

    // 등록 기능 수행 (CREATE)
    public abstract Boolean register(UserDTO dto) throws ServiceException;

} // end interface
