package com.example.EcfEchec.service;

import com.example.EcfEchec.entity.Utilisateur;
import com.example.EcfEchec.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository _utilisateurRepository;

    @Autowired
    private LoginService _loginService;

    public boolean signUp(String nom,String prenom,String email,String password) throws Exception{
        try{
     _utilisateurRepository.findByEmail(email);
     throw  new Exception();
        }
        catch (Exception ex){
            Utilisateur utilisateur = Utilisateur.builder().nom(nom).prenom(prenom).email(email).password(password).build();
            _utilisateurRepository.save(utilisateur);
            return  utilisateur.getId() >0 ;
        }
    }
    public boolean signIn(String email, String password) throws Exception {
        try {
            Utilisateur utilisateur = _utilisateurRepository.findByEmailAndPassword(email, password);
            if(utilisateur.isActive()) {
                return _loginService.login(utilisateur);
            }

        }catch (Exception ex) {
            throw new Exception(ex);
        }
        return false;
    }


}
