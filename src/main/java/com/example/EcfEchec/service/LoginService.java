package com.example.EcfEchec.service;

import com.example.EcfEchec.entity.Utilisateur;

public interface LoginService {
    public boolean login(Utilisateur utilisateur);
    public boolean isLogged();


    public int getUtilisateurId() ;


}
