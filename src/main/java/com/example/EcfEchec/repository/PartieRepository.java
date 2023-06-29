package com.example.EcfEchec.repository;

import com.example.EcfEchec.entity.Joueur;
import com.example.EcfEchec.entity.Partie;
import org.springframework.data.repository.CrudRepository;

public interface PartieRepository extends CrudRepository<Partie, Integer> {
}
