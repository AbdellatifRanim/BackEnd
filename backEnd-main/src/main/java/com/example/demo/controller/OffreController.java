package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Offre;
import com.example.demo.service.OffreIService;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController // hethy bsh tdol eli l class mteena controller
@AllArgsConstructor //tebaa l constructeur 
@FieldDefaults(level = AccessLevel.PRIVATE) //tous les champs de la classe sont définis comme private
@RequestMapping("/offre")


public class OffreController {
@Autowired
OffreIService offreIService; 

@PostMapping("/addoffre/{idUser}")
    public Offre addOffre(@RequestBody Offre offre , @PathVariable("idUser") Long idUser) {
        return offreIService.addOffre(offre,idUser);
    }
    @GetMapping("/GetListOffre")
    public List<Offre> getListCart() {
        List <Offre> offreList = offreIService.ListOffre();
        return offreList;
    }
    @GetMapping("/GetListOffreById/{id}")
    public Offre ListOffreById(@PathVariable("id") Long idOffre) {

        return offreIService.ListOffreById(idOffre);
    }
    @PutMapping("/updateOffre/{idOffre}")
    public Offre updateOffre(@PathVariable Long idOffre, @RequestBody Offre updatedOffre, @RequestParam("idUser") Long idUser) {
        return offreIService.updateOffre(idOffre, updatedOffre, idUser);
    }



    @PutMapping("/deleteOffre/{id}")
    public Offre deleteOffre( @PathVariable("id") Long idOffre) {
        return offreIService.deleteOffre(idOffre);
    }
}
