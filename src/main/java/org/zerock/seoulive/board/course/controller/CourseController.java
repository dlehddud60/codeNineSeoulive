package org.zerock.seoulive.board.course.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.seoulive.board.course.domain.tbl_courseDTO;
import org.zerock.seoulive.board.course.domain.tbl_courseVO;
import org.zerock.seoulive.board.course.domain.tbl_course_travelDTO;
import org.zerock.seoulive.board.course.exception.ControllerException;
import org.zerock.seoulive.board.course.service.CourseBoardSerivce;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/board/course/*")
@Controller
public class CourseController {
	
	@Setter (onMethod_=@Autowired)
	private CourseBoardSerivce service;
	
//	course게시판 리스트에서 확인... 그리고 쓰기, 게시물 읽기 
	
    @RequestMapping(path="write",params= {"writer","title","review","write_date","duration_start","duration_end",
    		"board_seq","travel_seq","upload_seq","link","user_review"
    		
    })
//	@RequestMapping("/write")
    public String write(tbl_course_travelDTO travelDTO, tbl_courseDTO dto,RedirectAttributes rttrs) throws ControllerException  {
    	
    	log.trace("\t in course's controller write({},{},{}) invoked.",travelDTO,dto,rttrs);
    	
    	try {
    		Objects.requireNonNull(travelDTO);
    		Objects.requireNonNull(dto);
    		Objects.requireNonNull(rttrs);
    		
    		if(this.service.write(dto)) {
    			rttrs.addAttribute("result","true");
    			rttrs.addAttribute("seq",travelDTO.getSeq());
    		}	// end if
    		
    		return "board/course/write";
    	}catch(Exception e) {
    		throw new ControllerException(e);
    	}	// end try-catch
    	
    }	// end write
	
	@GetMapping("/write")
	void write() {
		log.trace("write() invoked.");
	}	// end write
    
	// 게시판 목록 조회 
    @RequestMapping("/list")
    public String list(Model model) throws ControllerException{
    	
    	log.trace("\t course's controller list({}) invoekd.",model);
    	
    	try {
    		
    		List<tbl_courseVO> list= this.service.list();
    		model.addAttribute("__LIST__",list);
    	}catch(Exception e) {
    		throw new ControllerException(e);
    	}	// try-catch
    	
    	
    	return "board/course/list";
//        test1 패키징작업
    }	// end list
    
    
    // 특정 게시물 조회 
    @RequestMapping(path={"/view"},params="seq")
    public String view(@RequestParam("seq") Integer seq, Model model) throws ControllerException{
    	
    	log.trace("view({},{}) invoked.",seq,model);
    	
    	try {
    		tbl_courseVO vo = this.service.view(seq);
    		model.addAttribute("__BOARD__",vo);
    	}catch(Exception e) {
    		throw new ControllerException(e);
    	}	// end tryr-catch
    	
    	return "board/course/view";
//        test1 패키징작업
    }	// end view
    
    // 특정 게시물 수정 
    @PostMapping(path="/modify",params="seq")
    String modify(tbl_courseDTO dto,RedirectAttributes rttrs) throws ControllerException{
    	
    	log.trace("\t modify({},{}) invoked.",dto,rttrs);
    	
    	try {
    		Objects.requireNonNull(dto);
    		
    		if(this.service.modify(dto)) {
    			rttrs.addAttribute("result","true");
    			rttrs.addAttribute("seq",dto.getSeq());
    		}
    		return "redirect:/board/course/list";
    	}catch(Exception e) {
    		throw new ControllerException(e);
    	}	// end try-catch
    	
    }	// end modify
    
    @PostMapping(path="/remove")
    String remove(Integer seq, RedirectAttributes rttrs) throws ControllerException{
    	
    	log.trace("remove({}) invoked.",seq);
    	
    	try {
    		if(this.service.remove(seq)) {
    			rttrs.addAttribute("result","true");
    			rttrs.addAttribute("seq",seq);
    		}	// end if
    		return "redirect:/board/course/list";
    	}catch(Exception e) {
    		throw new ControllerException(e);
    	}	// end try-catch
    }	// end remove
    
}	// end class
