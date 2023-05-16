package org.zerock.seoulive.board.review.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.board.review.domain.BoardDTO;
import org.zerock.seoulive.board.review.domain.BoardVO;
import org.zerock.seoulive.board.review.domain.Criteria;
import org.zerock.seoulive.board.review.domain.PageDTO;
import org.zerock.seoulive.board.review.exception.ControllerException;
import org.zerock.seoulive.board.review.exception.ServiceException;
import org.zerock.seoulive.board.review.service.BoardService;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Log4j2
@Controller
@RequestMapping("/board/review")
public class ReviewBoardController {
    @Setter(onMethod_={@Autowired})
    private BoardService service;
    //게시물 목록 조회


    // 1. 게시판 목록 조회
//    @GetMapping("/list")
//    void list(Model model) throws ControllerException {
//        log.trace("list() invoked.", model);
//
//        try {
//            List<BoardVO> list =this.service.getList();
//
//            // Request Scope 공유속성 생성
//            model.addAttribute("__LIST__", list);
//        } catch (Exception e) {
//            throw new ControllerException(e);
//        } // try-catch
//    } // list

    // 1. 게시판 목록 조회
    @GetMapping("/list")
    void list(Criteria cri,Model model) throws ControllerException {
        log.trace("list({},{}) invoked.",cri, model);

        try {
            List<BoardVO> list = this.service.getList(cri);



            // Request Scope 공유속성 생성
            model.addAttribute("__LIST__", list);

            PageDTO pageDTO = new PageDTO(cri,this.service.getTotal());

            model.addAttribute("pageMaker", pageDTO);

        } catch (Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // list

// 2. 새로운 게시물 등록
    @PostMapping(path="/write", params= {"title", "content", "writer","place"})
    String writer(BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {

        try {
            Objects.requireNonNull(dto);

            if(this.service.register(dto)) { // if success
                rttrs.addAttribute("result", "true");
                rttrs.addAttribute("seq", dto.getSeq());
            } // if

            return "redirect:/board/review/list";
        } catch (Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // writer

    @GetMapping("/write")
    void writer() {	// 단순 등록화면 요청
        log.trace("write() invoked.");

    } // register



    // 3. 특정 게시물 상세조회
    @GetMapping(path={"/view"}, params= "seq")
    void view(@RequestParam("seq") Integer seq, Model model)
            throws ControllerException {
        log.trace("view() invoked.");

        try {
            BoardVO vo = this.service.get(seq);

            model.addAttribute("__BOARD__", vo);
        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // view








}//end class






