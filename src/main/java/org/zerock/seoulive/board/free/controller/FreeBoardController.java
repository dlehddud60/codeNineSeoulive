package org.zerock.seoulive.board.free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.seoulive.board.free.domain.FreeDTO;
import org.zerock.seoulive.board.free.persistence.FreeDAO;
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
    public String view(@RequestParam("seq") int seq, Model model) {

        freeService.total_count(seq);

        FreeDTO dto = freeService.view(seq);
        model.addAttribute("dto",dto);
        return "board/free/view";
    }

    @GetMapping("/modify")
    public String modify(@RequestParam("seq") int seq, Model model) {
        FreeDTO dto = freeService.view(seq);
        model.addAttribute("dto",dto);
        return "board/free/modify";
    }

    @PostMapping("/modify")
    public String modify(FreeDTO dto) {
        freeService.modify(dto);
        return "redirect:/board/free/list";
    }



    @GetMapping("/remove")
    public String remove(@RequestParam("seq") int seq) {
        freeService.remove(seq);
        return "redirect:/board/free/list";
    }


}
