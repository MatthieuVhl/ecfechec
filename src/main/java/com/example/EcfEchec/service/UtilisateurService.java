package com.example.EcfEchec.service;

import com.example.EcfEchec.entity.Utilisateur;
import com.example.EcfEchec.exception.UserExistException;
import com.example.EcfEchec.exception.UserNotExistException;
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
     throw  new UserExistException();
        }
        catch (Exception ex){
            Utilisateur utilisateur = Utilisateur.builder().nom(nom).prenom(prenom).email(email).password(password).build();
            _utilisateurRepository.save(utilisateur);
            return  _loginService.login(utilisateur);
        }
    }
    public void  update(Utilisateur utilisateur){
        _utilisateurRepository.save(utilisateur);
    }

    public boolean signIn(Utilisateur utilisateur) throws UserNotExistException {
        try {
            Utilisateur utilisateurSearch = _utilisateurRepository.findByEmailAndPassword(utilisateur.getEmail(),utilisateur.getPassword() );

                return _loginService.login(utilisateur);


        }catch (Exception ex) {
            throw new UserNotExistException();
        }

    }
    public List<Utilisateur> findAll() throws UserNotExistException {
        List<Utilisateur> utilisateurs = (List<Utilisateur>) _utilisateurRepository.findAll();
        if (utilisateurs.size()!= 0){

            return utilisateurs;
        } else {
            throw new UserNotExistException();
        }

    }


}
