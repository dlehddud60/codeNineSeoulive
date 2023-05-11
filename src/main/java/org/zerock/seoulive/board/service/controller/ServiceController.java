package org.zerock.seoulive.board.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/service/*")
public class ServiceController {

    @RequestMapping("/view")
    public String view() {
        return "board/service/view";
    }
}
