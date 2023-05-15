package org.zerock.myapp.mapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.mapper.UserMapper;

import static junit.framework.TestCase.assertNotNull;


@Log4j2
@NoArgsConstructor

// JUnit4
// Spring Framework 구동
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/**/root-*.xml"})
public class UserMapperTests {

    @Setter(onMethod_ = {@Autowired})
    private UserMapper mapper;


    @Before
    public void setup() {
        log.trace("setup() invoked.");

        assertNotNull(this.mapper);
        log.info("\t+ this.mapper : {}", this.mapper);
    } // setup


//    @Test(timeout = 1000 * 2)
//    public void testSelectList() {
//        log.trace("testSelectList() invoked.");
//
//        List<BoardVO> boards = this.mapper.selectList();
//        Objects.requireNonNull(boards);
//        boards.forEach(log::info);
//    } // testSelectList

    @Test(timeout = 1000 * 2)
    public void testInsert() {
        log.trace("testInsert() invoked.");

        UserDTO dto = new UserDTO();
        dto.setUserEmail("abc@email.com");
        dto.setUserPassword("abc1234");
        dto.setUserNickName("nick");
        dto.setBirthDate("19990203");
        dto.setUserGender("여");
        dto.setUserIntroduction("Hello");
        log.info("\t+ dto : {}", dto);

        Integer affectedLines = this.mapper.insert(dto);
        assert affectedLines != null;
        log.info("\t+ result : {}, dto : {}", (affectedLines == 1), dto);
    } // testInsert

//    @Test(timeout = 1000 * 3)
//    public void testSelect() {
//        log.trace("testSelect() invoked.");
//
//        Integer bno = 300;
//
//        BoardVO vo = this.mapper.select(bno);
//        log.info("\t+ bno : {}, vo : {}", bno, vo);
//
//    } // testSelect
//
//    @Test(timeout = 1000 * 2)
//    public void testDelete() {
//        log.trace("testDelete() invoked.");
//
//        Integer bno = -1;
//        Integer affectedLines = this.mapper.delete(bno);
//        log.info("bno : {}, affectedLines : {}, isSuccess : {}", bno, affectedLines, (affectedLines == 1));
//
//    } // testDelete
//
//    @Test(timeout = 1000 * 2)
//    public void testUpdate() {
//        log.trace("testUpdate() invoked.");
//
//        Integer bno = 301;
//        BoardVO vo = this.mapper.select(bno);
//
//        assertNotNull(vo);
//
//        // VO => DTO
//        BoardDTO dto = vo.toDTO();
//
//        dto.setTitle("MODIFED_TITLE");
//
////        BoardDTO dto = new BoardDTO();
////        dto.setBno(301);
////        dto.setTitle("UPDATE_TITLE");
////        dto.setContent("UPDATE_CONTENT");
////        dto.setWriter("UPDATE_WRITER");
//
//        log.info("\t+ dto : {}", dto);
//
//        // 필드에 주입받은 maaper interface를 이용해서 update
//        Integer affectedLines = this.mapper.update(dto);
//        log.info("affectedLines : {}, isSuccess : {}", affectedLines, (affectedLines == 1));
//
//    } // testUpdate

} // end class
