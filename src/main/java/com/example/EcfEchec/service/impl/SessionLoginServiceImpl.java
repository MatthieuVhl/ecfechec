package com.example.EcfEchec.service.impl;

import com.example.EcfEchec.entity.Utilisateur;
import com.example.EcfEchec.service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionLoginServiceImpl implements LoginService {
    @Autowired
    HttpSession _httpSession;

    @Override
    public boolean login(Utilisateur utilisateur) {
        _httpSession.setAttribute("isLogged", true);
        _httpSession.setAttribute("fullName", utilisateur.getNom() + " "+utilisateur.getPrenom());
        _httpSession.setAttribute("userId", utilisateur.getId());
        _httpSession.setAttribute("isAdmin", utilisateur.isActive());
        return true;
    }

    @Override
    public boolean isLogged(){
        return _httpSession.getAttribute("isLogged") != null && (boolean)_httpSession.getAttribute("isLogged") == true;
    }
    @Override
    public boolean isAdmin(){
        return _httpSession.getAttribute("isLogged") != null && (boolean)_httpSession.getAttribute("isAdmin") == true;
    }

    @Override
    public int getUtilisateurId(){
        return (int)_httpSession.getAttribute("utilisateurId");
    }
}
