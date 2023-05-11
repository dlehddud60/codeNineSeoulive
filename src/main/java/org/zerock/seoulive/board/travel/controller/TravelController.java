package org.zerock.seoulive.board.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/travel/*")
public class TravelController {

    @RequestMapping("/view")
    public String view() {
        return "board/travel/view";
    }
}
