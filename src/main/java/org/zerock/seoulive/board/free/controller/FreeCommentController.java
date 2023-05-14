package org.zerock.seoulive.board.free.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zerock.seoulive.board.free.domain.FreeCommentDTO;
import org.zerock.seoulive.board.free.service.FreeCommentService;

import java.util.List;

@RestController
@RequestMapping("/board/free/comment/*")
public class FreeCommentController {


    FreeCommentService freeCommentService;

    @Autowired
    public FreeCommentController(FreeCommentService freeCommentService) {
        this.freeCommentService = freeCommentService;
    }

    @GetMapping("/{post_seq}")
    public List<FreeCommentDTO> freeCommentList(@PathVariable("post_seq") int post_seq) {
        List<FreeCommentDTO> commentList = freeCommentService.freeCommentList(post_seq);
        return commentList;
    }




}
