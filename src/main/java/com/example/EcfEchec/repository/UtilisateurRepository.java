package com.example.EcfEchec.repository;

import com.example.EcfEchec.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Integer> {
    public  Utilisateur findByEmailAndPassword (String email, String password);

    public Utilisateur findByEmail(String email);
}
