package com.groupeisi.restful1.controller;

import com.groupeisi.restful1.entities.Etudiant;
import com.groupeisi.restful1.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")

public class EtudiantController {
   private  final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping("/create")
   public Etudiant create(@RequestBody Etudiant etudiant){
       return etudiantService.creer(etudiant);
   }
   @GetMapping("/read")
   public List<Etudiant> read(){
       return etudiantService.lire();
   }
   @PutMapping("/update/{id}")
   public Etudiant update(Long id, Etudiant etudiant){
       return  etudiantService.modifier(id,etudiant);
   }
   @DeleteMapping("/delete")
   public String delete(@PathVariable Long id){
       return  etudiantService.supprimer(id);
   }

}
