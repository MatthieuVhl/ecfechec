package com.example.EcfEchec.controller;

import com.example.EcfEchec.exception.NotSignInException;
import com.example.EcfEchec.service.TournoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tournoi")
public class TournoiController {
    @Autowired
    private TournoiService _tournoiService;

    @GetMapping("")
    public ModelAndView get() throws Exception {
       ModelAndView mv = new ModelAndView("tournoi");
 mv.addObject("tournoi",_tournoiService.getJoueurByTournoiId(_tournoiService));
 return mv;
    }
}
