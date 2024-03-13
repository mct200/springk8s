package com.groupeisi.restful1.service;

import com.groupeisi.restful1.entities.Etudiant;

import java.util.List;
public interface EtudiantService {
    Etudiant creer(Etudiant etudiant);
    List<Etudiant> lire();
    Etudiant modifier(Long id, Etudiant etudiant);
    String supprimer(Long id);
}
