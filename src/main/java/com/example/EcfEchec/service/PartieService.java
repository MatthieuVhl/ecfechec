package com.example.EcfEchec.service;

import com.example.EcfEchec.entity.Partie;
import com.example.EcfEchec.exception.EmptyEmplacement;
import com.example.EcfEchec.exception.NotAdminException;
import com.example.EcfEchec.exception.NotSignInException;
import com.example.EcfEchec.repository.PartieRepository;
import com.example.EcfEchec.repository.UtilisateurRepository;
import com.example.EcfEchec.service.LoginService;
import com.example.EcfEchec.service.UtilisateurService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartieService {
    @Autowired
    private  PartieRepository _partieRepository;

    @Autowired
    private LoginService _loginService;
    @Autowired
    private UtilisateurRepository _utilisateur;
    @Autowired
    private HttpSession _session;


    public boolean createPartie(Partie partie)throws EmptyEmplacement, NotAdminException,NotSignInException{
        if(_loginService.isLogged()){
            if (_loginService.isAdmin()){
                if (partie.getTitle() == null || partie.getUtilisateur().size() != 2){
                    throw new EmptyEmplacement();
                }
                _partieRepository.save(partie);
                return true;
            }
            throw new NotAdminException();
        }
        throw new NotSignInException();
    }



}
