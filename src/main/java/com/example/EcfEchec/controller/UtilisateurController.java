package com.example.EcfEchec.controller;

import com.example.EcfEchec.exception.UserNotExistException;
import com.example.EcfEchec.service.UtilisateurService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurService _utilisateurService;
    @Autowired
    private HttpServletResponse response;

    @GetMapping("signin")
    public ModelAndView signIn(){
        ModelAndView mv = new ModelAndView("signin");
        return mv;
    }

    @PostMapping("signin")
    public String signUp(@RequestParam String email,@RequestParam String password)throws Exception{
        if (_utilisateurService.signIn(email,password)){
            return "redirect:/";
    }
        return null;
    }

    @GetMapping("signup")
    public ModelAndView postSignIn() {
        ModelAndView mv = new ModelAndView("signup");
        return mv;
    }
    @ExceptionHandler(UserNotExistException.class)
    public ModelAndView utilisateurNotExist(UserNotExistException ex){
        ModelAndView mv = new ModelAndView("signin");
        mv.addObject("message", ex.getMessage());
        return mv;
    }

    @GetMapping("signup")
    public  ModelAndView postSignin(){
        ModelAndView mv = new ModelAndView("signup");
        return mv;
    }
    @PostMapping("signup")
    public String postSignUp(@RequestParam String nom, @RequestParam String prenom, @RequestParam String email, @RequestParam String password) throws Exception, IOException {
        if(_utilisateurService.signUp(nom, prenom, email, password)) {
            return "redirect:/utilisateur/signin";
        }
        return null;
    }

}
