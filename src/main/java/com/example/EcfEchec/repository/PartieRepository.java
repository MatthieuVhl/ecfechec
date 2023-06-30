package com.example.EcfEchec.repository;


import com.example.EcfEchec.entity.Partie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartieRepository extends CrudRepository<Partie, Integer> {
}
