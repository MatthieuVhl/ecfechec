package com.example.EcfEchec.repository;

import com.example.EcfEchec.entity.Tournoi;
import com.example.EcfEchec.service.TournoiService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournoiRepository extends CrudRepository<Tournoi, Integer> {


    public boolean existTournoiByName(String NomTournoi);


}
