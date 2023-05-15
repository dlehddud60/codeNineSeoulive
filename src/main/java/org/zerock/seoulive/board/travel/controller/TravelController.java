package org.zerock.seoulive.board.travel.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.board.travel.domain.DTO;
import org.zerock.seoulive.board.travel.domain.VO;
import org.zerock.seoulive.board.travel.exception.ControllerException;
import org.zerock.seoulive.board.travel.service.service;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Controller
@RequestMapping("/board/travel/*")
public class TravelController {

    @Setter(onMethod_ = {@Autowired})
    private service service;

    @GetMapping("/list")
    void list(Model model) throws ControllerException {

        try {
            List<VO> list = this.service.getList();

            // Request Scope 공유속성 생성
            model.addAttribute("__LIST__", list);
        } catch(Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // list

    @GetMapping(path = {"/view", "/modify"}, params = "seq")
    void view(@RequestParam("seq") Integer seq, Model model) throws ControllerException {

        try {
            VO vo = this.service.get(seq);
            model.addAttribute("__BOARD__","vo");
        }
        catch (Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // view

    @PostMapping("/modify")
    String modify(DTO dto, RedirectAttributes rttrs) throws ControllerException {

        try {
            Objects.requireNonNull(dto);

                if(this.service.modify(dto)) {
                    rttrs.addAttribute("result", "true");
                    rttrs.addAttribute("seq", dto.getSeq());
                } // end if

                return "redirect:/board/travel/view";
        }
        catch (Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // modify

    @PostMapping("/remove")
    String remove(Integer currPage, Integer seq, RedirectAttributes rttrs) throws ControllerException {

        try {
            rttrs.addAttribute("currPage", currPage);

            if (this.service.remove(seq)) {
                rttrs.addAttribute("result", "true");
                rttrs.addAttribute("seq", seq);
            } // end if

            return "redirect:/board/travel/list";
        }
        catch (Exception e) {
            throw new ControllerException(e);
        } // try-catch
    } // remove
}
