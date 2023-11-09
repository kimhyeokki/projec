package com.khk11.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String index(@ModelAttribute("isState") String isState, Model model){
        model.addAttribute("isState",isState);
        //model.addAttribute("name",name);
       // model.addAttribute("age",age);
        /*log.info("addFlashAttribute로 보낸 name={}",name);
        log.info("addAttribute로 보낸 age={}",age);*/
        return "index";
    }
}
