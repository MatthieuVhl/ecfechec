package com.example.EcfEchec.controller;

import com.example.EcfEchec.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/joueur")
public class JoueurController {
    @Autowired
    private JoueurService _joueurService;

    @GetMapping("")
    public ModelAndView createJoueur() throws Exception{
        ModelAndView mv = new ModelAndView("joueur");
        mv.addObject("joueur",_joueurService.getJoueur());
        return mv;

    }

}
