package com.example.EcfEchec.repository;

import com.example.EcfEchec.entity.Tournoi;
import com.example.EcfEchec.service.TournoiService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TournoiRepository extends CrudRepository<Tournoi, Integer> {


    public boolean existTournoiByName(String NomTournoi);


}
