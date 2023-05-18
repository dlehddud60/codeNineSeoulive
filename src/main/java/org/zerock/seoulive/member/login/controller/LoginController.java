package org.zerock.seoulive.member.login.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.member.join.domain.UserDTO;
import org.zerock.seoulive.member.join.exception.ControllerException;
import org.zerock.seoulive.member.join.service.MailSendService;
import org.zerock.seoulive.member.join.service.UserService;

import java.util.HashMap;
import java.util.Objects;


@Log4j2
@NoArgsConstructor

@RequestMapping("/member/login")
@Controller
public class LoginController {


    @GetMapping("/main")
    void loginMain() {
        log.trace("loginMain() invoked.");

    } // loginMain

    @GetMapping("/email")
    void emailLogin() {
        log.trace("emailLogin() invoked.");

    } // emailLogin


} // end class
