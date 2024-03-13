package com.groupeisi.restful1.service;

import com.groupeisi.restful1.entities.Etudiant;
import com.groupeisi.restful1.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantServiceImp implements EtudiantService{
    private  final EtudiantRepository etudiantRepository;
    public EtudiantServiceImp(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant creer(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> lire() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant modifier(Long id, Etudiant etudiant) {
        return etudiantRepository.findById(id).map(e -> {
            e.setFirstName(etudiant.getFirstName());
            e.setLastName(etudiant.getLastName());
            return etudiantRepository.save(e);
        }).orElseThrow(() -> new RuntimeException("Etudiant non trouve !"));
    }

    @Override
    public String supprimer(Long id) {
        etudiantRepository.deleteById(id);
        return "Etudiant supprime avec succes !";
    }
}
