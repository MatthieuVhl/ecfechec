package com.example.EcfEchec.service;

import com.example.EcfEchec.entity.Joueur;
import com.example.EcfEchec.entity.Tournoi;
import com.example.EcfEchec.exception.EmptyFieldsException;
import com.example.EcfEchec.repository.TournoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.ExemptionMechanismException;
import java.io.IOException;
import java.util.List;

@Service
public class TournoiService {

    private TournoiRepository _tournoiRepsository;

    @Autowired
    private LoginService _loginService;

    public boolean saveTournoi(String NomTournoi)throws Exception, ExemptionMechanismException, IOException {
        if (_loginService.isLogged()){
            if (NomTournoi != null){
                if (!_tournoiRepsository.existTournoiByName(NomTournoi)){
                    Tournoi tournoi = Tournoi.builder().NomTournoi(NomTournoi).build();
                    _tournoiRepsository.save(tournoi);
                    return tournoi.getId() > 0 ;
                }
                throw EmptyFieldsException.with("NomTournoi");
            }
            throw new Exception();
        }
        return false;
    }

public List<Joueur>getJoueurByTournoiId(TournoiService id)throws Exception{
        if (_loginService.isLogged()){
 List<Joueur>joueurs = _tournoiRepsository.findById(id).get().getJoueurs();
 return joueurs;
        }
        throw new Exception();
}



}
