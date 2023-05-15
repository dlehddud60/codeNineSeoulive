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


    @PostMapping(
            value = "/register",
            params = {"userEmail", "userPassword", "userNickName", "birthDate", "userGender", "userIntroduction"}
            )
//            , params = {"title", "content", "writer"})
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


} // end class
