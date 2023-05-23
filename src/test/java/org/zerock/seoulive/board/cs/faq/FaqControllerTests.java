package org.zerock.seoulive.board.cs.faq;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/**/root-*.xml",
        "file:src/main/webapp/WEB-INF/**/servlet-*.xml"
})

@WebAppConfiguration

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FaqControllerTests {

    @Autowired
    private WebApplicationContext ctx;
    private MockMvc mockMvc;

    @BeforeAll
    void beforeAll(){
        log.trace("beforeAll() invoked.");

        Objects.requireNonNull(this.ctx);
        log.info("\t+ ctx : {}", ctx);

        MockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(ctx);
        this.mockMvc = mockMvcBuilder.build();
    } // beforeAll

    @Test
    @Order(1)
    @DisplayName("testRegister")
    @Timeout(value=2, unit= TimeUnit.SECONDS)
    void testRegister() throws Exception{
        log.trace("testRegister() invoked");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/board/cs/faq/write");
        requestBuilder.param("title", "test_title");
        requestBuilder.param("content", "test_content");
        requestBuilder.param("writer", "test_writer");
        requestBuilder.param("category", "test_category");

        ModelAndView modelAndView = this.mockMvc.perform(requestBuilder).andReturn().getModelAndView();

        String viewName = modelAndView.getViewName();
        log.info("\t+ 1. viewName : {}", viewName);

        ModelMap modelMap = modelAndView.getModelMap();

        assert modelMap != null;
        modelMap.forEach((k, v) -> log.info("\t+ 2. k :{}, v : {}", k, v));
    } // testRegister

    @Test
    @Order(3)
    @DisplayName("testGet")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testGet() throws Exception {    // 단위테스트
        log.trace("testGet() invoked.");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/board/cs/faq/modify");
        requestBuilder.param("seq", "31");

        ModelAndView modelAndView = this.mockMvc.perform(requestBuilder).andReturn().getModelAndView();

        String viewName = modelAndView.getViewName();
        log.info("\t+ 1. viewName : {}", viewName);

        ModelMap modelMap = modelAndView.getModelMap();

        assert modelMap != null;
        modelMap.forEach( (k, v) -> log.info("\t+ 2. k : {}, v : {}", k, v) ); // .forEachåå

    } // testGet

    @Test
    @Order(5)
    @DisplayName("testRemove")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testRemove() throws Exception {    // 단위테스트
        log.trace("testRemove() invoked.");

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/board/cs/faq/remove");
        requestBuilder.param("currPage", "1");
        requestBuilder.param("seq", "32");

        ModelAndView modelAndView = this.mockMvc.perform(requestBuilder).andReturn().getModelAndView();

        String viewName = modelAndView.getViewName();
        log.info("\t+ 1. viewName : {}", viewName);

        ModelMap modelMap = modelAndView.getModelMap();

        assert modelMap != null;
        modelMap.forEach( (k, v) -> log.info("\t+ 2. k : {}, v : {}", k, v) ); // .forEach

    } // testRemove
}
