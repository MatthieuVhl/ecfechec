package com.example.EcfEchec.controller;

import com.example.EcfEchec.entity.Utilisateur;
import com.example.EcfEchec.exception.UserExistException;
import com.example.EcfEchec.exception.UserNotExistException;
import com.example.EcfEchec.service.UtilisateurService;
import jakarta.servlet.http.HttpSession;
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
    private HttpSession _session;


    @GetMapping("signin")
    public ModelAndView signIn(){
        ModelAndView mv = new ModelAndView("signin");
        return mv;
    }
    @PostMapping("/update")
    public  String update(@RequestParam String nom,@RequestParam String prenom, @RequestParam String email, @RequestParam String password) {

        Utilisateur utilisateur = (Utilisateur) _session.getAttribute("utilisateur");
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setPassword(password);


        _utilisateurService.update(utilisateur);
        return "redirect:/user/profil";
    }

    @PostMapping("signin")
    public String signUp(@RequestParam String email,@RequestParam String password)throws UserNotExistException{
        Utilisateur utilisateur = Utilisateur.builder().email(email).password(password).build();
        if(_utilisateurService.signIn(email,password)) {

            utilisateur = (Utilisateur) _session.getAttribute("user");
            if (utilisateur.isActive()){
                return "redirect:/utilisateur/admin/profil";
            } else {

                return "redirect:/utilisateur/profil";
            }
        }
        return null;
    }

    @GetMapping("signup")
    public ModelAndView SignUp() {
        ModelAndView mv = new ModelAndView("signup");
        return mv;
    }
    @ExceptionHandler(UserNotExistException.class)
    public ModelAndView handleNotExist(UserNotExistException ex){
        ModelAndView mv = new ModelAndView("signup");
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
            return "redirect:/";
        }
        return null;
    }


    @ExceptionHandler(UserExistException.class)
    public ModelAndView handleUserExist(UserExistException ex) {
        ModelAndView mv = new ModelAndView("signup");
        mv.addObject("message", ex.getMessage());
        return mv;
    }


}
