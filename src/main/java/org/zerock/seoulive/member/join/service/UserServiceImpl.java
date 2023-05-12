package org.zerock.seoulive.member.join.service;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.domain.UserVO;
import org.zerock.seoulive.member.join.exception.ServiceException;
import org.zerock.seoulive.member.join.mapper.UserMapper;

import java.util.List;
import java.util.Objects;


@Log4j2
@NoArgsConstructor

@Service("userService")
public class UserServiceImpl
        implements UserService, InitializingBean, DisposableBean {

    @Setter(onMethod_ = {@Autowired})
    private UserMapper dao;        // 영속성 계층의 DAO 빈 주입


    // 1. 게시판 목록을 얻어 반환해주는 기능 수행
//    @Override
//    public List<UserVO> getList() throws ServiceException {
//        log.trace("getList() invoked.");
//
//        try {
//            return this.dao.selectList();
//        } catch(Exception e) {
//            throw new ServiceException(e);
//        } // try-catch
//    } // getList

    // 2. 새로운 게시물 등록 기능 수행 (CREATE)
    @Override
    public Boolean register(UserDTO dto) throws ServiceException {
        log.trace("register({}) invoked.", dto);

        try {
            return (this.dao.insert(dto) == 1);
        } catch(Exception e) {
            throw new ServiceException(e);
        } // try-catch
    } // register

//    @Override
//    public UserVO get(Integer bno) throws ServiceException {
//        log.trace("get({}) invoked.", bno);
//
//        try {
//            return this.dao.select(bno);
//        } catch(Exception e) {
//            throw new ServiceException(e);
//        } // try-catch
//    } // get

//    @Override
//    public Boolean modify(UserDTO dto) throws ServiceException {
//        log.trace("modify({}) invoked.", dto);
//
//        try {
//            return (this.dao.update(dto) == 1);
//        } catch(Exception e) {
//            throw new ServiceException(e);
//        } // try-catch
//    } // modify

//    @Override
//    public Boolean remove(Integer bno) throws ServiceException {
//        log.trace("remove({}) invoked.", bno);
//
//        try {
//            return (this.dao.delete(bno) == 1);
//        } catch(Exception e) {
//            throw new ServiceException(e);
//        } // try-catch
//    } // remove


//    InitializingBean, DisposableBean    //
    // 초기화 (전처리)
    @Override
    public void afterPropertiesSet() throws Exception {
        log.trace("afterPropertiesSet() invoked.");

//        assert this.dao != null;
        Objects.requireNonNull(this.dao);
        log.info("\t+ this.dao : {}", this.dao);
    } // afterPropertiesSet

    // 자원 해제 (후처리)
    @Override
    public void destroy() throws Exception {
        log.trace("destroy() invoked.");

    } // destroy

} // end class
