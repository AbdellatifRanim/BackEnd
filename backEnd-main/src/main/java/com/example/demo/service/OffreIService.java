package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Offre;


public interface OffreIService {
    public Offre addOffre(Offre offre,Long idUser);
    public List<Offre> ListOffre();
    public Offre ListOffreById(Long idOffre);   
    public Offre updateOffre(Long idOffre, Offre updatedOffre, Long idUser);
    public Offre deleteOffre(Long idOffre);  

}
