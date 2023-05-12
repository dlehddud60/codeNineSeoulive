package org.zerock.seoulive.member.join.mapper;


import org.zerock.seoulive.member.join.domain.UserDTO;

public interface UserMapper {

    // 1. 게시판 목록조회, CRUD에 필요한 메소드
//    @Select("""
//            SELECT
//                    /*+ index_desc(tbl_board) */
//            		*
//            FROM tbl_board
//            """)
//    public abstract List<UserVO> selectList();

    // 2. 새로운 게시물 등록
//    @Insert("INSERT INTO tbl_board (title, content, writer) VALUES (#{title}, #{content}, #{writer})")
    public abstract Integer insert(UserDTO dto);

    // 3. 특정 게시물 상세조회
//    public abstract UserVO select(Integer bno);

    // 4. 특정 게시물 삭제
//    public abstract Integer delete(Integer bno);

    // 5. 특정 게시물 업데이트 (갱신)
//    public abstract Integer update(UserDTO dto);



} // end interface
