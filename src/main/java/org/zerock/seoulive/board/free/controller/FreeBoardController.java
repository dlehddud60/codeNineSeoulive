package org.zerock.seoulive.board.free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.seoulive.board.free.domain.FreeDTO;
import org.zerock.seoulive.board.free.service.FreeService;

import java.util.List;

@Controller
@RequestMapping("/board/free/*")
public class FreeBoardController {
    @Autowired
    FreeService freeService;


//    public FreeBoardController(FreeService freeService) {
//        this.freeService = freeService;
//    }

    @GetMapping("/list")
    public String list(Model model) {
        List<FreeDTO> list = freeService.getList();
        model.addAttribute("list",list);
        return "board/free/list";
    }
    @GetMapping("/write")
    public String write() {
        return "board/free/write";
    }
    @PostMapping("/write")
    public String write(FreeDTO dto) {
        freeService.freeInsert(dto);
        return "redirect:/board/free/list";
    }


    @GetMapping("/view")
    public String view(@RequestParam("seq") String seq, Model model) {
        FreeDTO vo = freeService.view(seq);
        model.addAttribute("vo",vo);
        return "board/free/view";
//        http://localhost:8080/sp07/board/get?idx=3
    }
}
