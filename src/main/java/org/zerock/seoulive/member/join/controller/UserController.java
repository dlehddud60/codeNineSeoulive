package org.zerock.seoulive.member.join.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.exception.ControllerException;
import org.zerock.seoulive.member.join.service.UserService;

import java.util.Objects;


@Log4j2
@NoArgsConstructor

@RequestMapping("/member/join")
@Controller
public class UserController {
    @Setter(onMethod_ = @Autowired)
    private UserService service;

//    // 1. 게시판 목록 조회
//    @GetMapping("/list")
//    void list(Model model) throws ControllerException {
//        log.trace("list() invoked.");
//
//        try {
//            List<BoardVO> list = this.service.getList();
//
//            // Request Scope 공유속성 생성
//            model.addAttribute("__LIST__", list);
//        } catch(Exception e) {
//            throw new ControllerException(e);
//        } // try-catch
//    } // list

    // 2. 새로운 게시물 등록
    @PostMapping(value = "/register", params = {"title", "content", "writer"})
    String register(UserDTO dto, RedirectAttributes rttrs) throws ControllerException {
        log.trace("register({}, {}) invoked.", dto, rttrs);

        try {
            Objects.requireNonNull(dto);
            if(this.service.register(dto)) { // if success
                rttrs.addFlashAttribute("result", "true");
                rttrs.addFlashAttribute("email", dto.getUserEmail());
            } // if

            return "redirect:/member/join/register";
        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // register

    @GetMapping("/register")
    void register() {   // 단순 등록화면 요청
        log.trace("register() invoked.");

    } // register

//    // 3. 특정 게시물 상세조회
//    @GetMapping(path = {"/get", "/modify"}, params = "bno")
//    void get(@RequestParam("bno") Integer bno, Model model)
//            throws ControllerException {
//        log.trace("get() invoked.");
//
//        try {
//            BoardVO vo = this.service.get(bno);
//            model.addAttribute("__BOARD__", vo);
//        } catch(Exception e) {
//            throw new ControllerException(e);
//        } // try-catch
//    } // get

//    // 4. 특정 게시물 업데이트 (UPDATE)
//    @PostMapping("/modify")
//    String modify(BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {
//        log.trace("modify() invoked.");
//
//        try {   // 전송파라미터 필요 (title, content, writer)
//            Objects.requireNonNull(dto);
//
//            if(this.service.modify(dto)) {  // if success
//                rttrs.addAttribute("result", "true");
//                rttrs.addAttribute("bno", dto.getBno());
//            } // if
//
//            return "redirect:/board/list";
//        } catch(Exception e) {
//            throw new ControllerException(e);
//        } // try-catch
//    } // modify


//    // 5. 특정 게시물 삭제 (DELETE)
//    @PostMapping("/remove")
//    String remove(Integer bno, RedirectAttributes rttrs) throws ControllerException {
//        log.trace("remove() invoked.");
//
//        try {
//            if(this.service.remove(bno)) {  // if success
//                rttrs.addAttribute("result", "true");
//                rttrs.addAttribute("bno", bno);
//            } // if
//            return "redirect:/board/list";
//        } catch(Exception e) {
//            throw new ControllerException(e);
//        } // try-catch
//    } // remove


} // end class
