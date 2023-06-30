package com.example.EcfEchec.controller;

import com.example.EcfEchec.entity.Partie;
import com.example.EcfEchec.entity.Utilisateur;
import com.example.EcfEchec.exception.EmptyEmplacement;
import com.example.EcfEchec.exception.NotAdminException;
import com.example.EcfEchec.exception.NotSignInException;
import com.example.EcfEchec.exception.UserNotExistException;
import com.example.EcfEchec.repository.TournoiRepository;
import com.example.EcfEchec.service.UtilisateurService;
import com.example.EcfEchec.service.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class PartieController {
    @Autowired
    UtilisateurService _utilisateurService;
    @Autowired
    TournoiRepository _tournoiRepository;

    @Autowired
    PartieService _partieService;

    @GetMapping("form")
    public ModelAndView getForm() throws UserNotExistException {
        ModelAndView mv = new ModelAndView("createPartieForm");
        List<Utilisateur> utilisateurs = _utilisateurService.findAll();
        mv.addObject("utilisateur", utilisateurs );
        return mv;
    }

    @PostMapping("create-partie")
    public String postPart(@RequestParam("title") String title, @RequestParam("utilisateur") List<Utilisateur> utilisateurs) throws EmptyEmplacement, NotSignInException, NotAdminException {

        Partie partie = Partie.builder().title(title).utilisateur(utilisateurs).build();
        _partieService.createPartie(partie);


        return "redirect:/user/admin/profile";
    }








    }

