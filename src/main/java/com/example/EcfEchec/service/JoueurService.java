package com.example.EcfEchec.service;

import com.example.EcfEchec.entity.Joueur;
import com.example.EcfEchec.entity.Tournoi;
import com.example.EcfEchec.exception.EmptyFieldsException;
import com.example.EcfEchec.repository.JoueurRepository;
import com.example.EcfEchec.repository.TournoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;

@Service
public class JoueurService {
    @Autowired
    private JoueurRepository _joueurRepository;

    @Autowired
    private TournoiRepository _tournoiRepository;

    @Autowired
    private LoginService _loginService;

    public boolean createJoueur( String nom, String prenom,String score, List<Integer> tournoiId)throws Exception,IOException{
        if (_loginService.isLogged()){
            if (nom == null || prenom == null||score == null ||tournoiId == null|| tournoiId.size() ==0){
                EmptyFieldsException.with("nom","prenom","score","tournoi");
            }
            Joueur joueur = Joueur.builder().nom(nom).prenom(prenom).score(score).build();
            _joueurRepository.save(joueur);
        }
        return true;
    }

    public List<Joueur>getJoueur()throws Exception{
        if (_loginService.isLogged()){
            return (List<Joueur>) _joueurRepository.findAll();
        }
        throw  new Exception();
    }

}
