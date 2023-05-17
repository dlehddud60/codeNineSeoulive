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


    @Test(timeout = 1000 * 2)
    public void testInsert() {
        log.trace("testInsert() invoked.");

        UserDTO dto = new UserDTO();
        dto.setEmail("abc@email.com");
        dto.setPassword("abc1234");
        dto.setNickName("nick");
        dto.setBirthDate("19990203");
        dto.setGender("여");
        dto.setIntroduction("Hello");


        log.info("\t+ dto : {}", dto);

        Integer affectedLines = this.mapper.insert(dto);
        assert affectedLines != null;
        log.info("\t+ result : {}, dto : {}", (affectedLines == 1), dto);
    } // testInsert


} // end class
