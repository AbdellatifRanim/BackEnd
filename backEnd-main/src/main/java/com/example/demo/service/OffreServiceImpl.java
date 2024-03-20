package com.example.demo.service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Offre;
import com.example.demo.model.User;
import com.example.demo.repositiry.OffreRepo;
import com.example.demo.repositiry.UserRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
//cette classe implemente l'interface OffreIService
//@Slf4j
 //c une bonne pratique qui facilite le suivi des erreurs, le débogage et la compréhension du comportement de  l'application 
@AllArgsConstructor //génére automatiquement un constructeur
@FieldDefaults(level = AccessLevel.PRIVATE) //tous les champs de la classe sont définis comme private
 //k tetlalek hamra ctrl+escpace
@Service

public class OffreServiceImpl implements OffreIService   {
    @Autowired //taml injection des dependences
    OffreRepo offreRepo;
    UserRepo userRepo;
    //chtekhdm l body mta fonction yali f serviceInterface
   @Override
    public Offre addOffre(Offre offre,Long idUser)
     {
      User user = userRepo.findById(idUser).orElseThrow(()->new EntityNotFoundException("idUser non trouvée"));
      
      offre.setUser(user);

        return offreRepo.save(offre);  
     }

     public List<Offre> ListOffre()
     {
        return (List<Offre>) offreRepo.findAll();
     }
     @Override
     public Offre ListOffreById(Long idOffre)
     {
        return offreRepo.findById(idOffre).get();

     }

     /*@Override
     public Offre updateOffre(Long idOffre, Offre updatedOffre, Long idUser) {
        // Vérifie si l'offre existe dans la base de données
        Offre existingOffre = offreRepo.findById(idOffre)
                                       .orElseThrow(() -> new EntityNotFoundException("Offre non trouvée avec l'ID : " + idOffre));
        
        // Récupère l'utilisateur associé à l'offre
        User user = userRepo.findById(idUser)
                            .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID : " + idUser));
        
        // Remplace tous les détails de l'offre existante par ceux de l'offre mise à jour
        existingOffre.setTitre(updatedOffre.getTitre());
        existingOffre.setDescription(updatedOffre.getDescription());
        existingOffre.setCategorie(updatedOffre.getCategorie());
        existingOffre.setLieu(updatedOffre.getLieu());
        existingOffre.setImage(updatedOffre.getImage());
        existingOffre.setLastUpdate((java.sql.Date) new Date()); // Met à jour la date de dernière modification
        existingOffre.setCreatedAt(existingOffre.getCreatedAt()); // Garde la date de création inchangée
        // Ajoutez d'autres champs à mettre à jour selon vos besoins
        
        // Mise à jour de l'utilisateur associé à l'offre
        existingOffre.setUser(user);
        
        // Sauvegarde de l'offre mise à jour
        return offreRepo.save(existingOffre);
    }*/
   @Override
public Offre updateOffre(Long idOffre, Offre updatedOffre, Long idUser) {
    // Vérifie si l'offre existe dans la base de données
    /* Offre existingOffre = offreRepo.findById(idOffre)
                                   .orElseThrow(() -> new EntityNotFoundException("Offre non trouvée avec l'ID : " + idOffre));
    // Log existing Offre details for verification
    System.out.println("Existing Offre Details:");
    System.out.println(existingOffre.toString());
    // Récupère l'utilisateur associé à l'offre
    User user = userRepo.findById(idUser)
                        .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID : " + idUser));
    // Log User details for verification
    System.out.println("Associated User Details:");
    System.out.println(user.toString());
    // Remplace tous les détails de l'offre existante par ceux de l'offre mise à jour
    existingOffre.setTitre(updatedOffre.getTitre());
    existingOffre.setDescription(updatedOffre.getDescription());
    existingOffre.setCategorie(updatedOffre.getCategorie());
    existingOffre.setLieu(updatedOffre.getLieu());
    existingOffre.setImage(updatedOffre.getImage());
    existingOffre.setLastUpdate(new java.sql.Date(System.currentTimeMillis())); // Met à jour la date de dernière modification
    // Note: Use new java.sql.Date(System.currentTimeMillis()) for current date
    // Log updated Offre details for verification
    System.out.println("Updated Offre Details:");
    System.out.println(existingOffre.toString());
    // Mise à jour de l'utilisateur associé à l'offre
    existingOffre.setUser(user);
    // Log User association for verification
    System.out.println("Updated Offre User Association:");
    System.out.println(existingOffre.getUser().toString());
    // Sauvegarde de l'offre mise à jour
    Offre savedOffre = offreRepo.save(existingOffre);
    // Log saved Offre details for verification
    System.out.println("Saved Offre Details:");
    System.out.println(savedOffre.toString());
    return savedOffre;*/
    updatedOffre.setIdOffre(idOffre);
    updatedOffre.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
    // Met à jour la date de dernière modification
     // Récupère l'utilisateur associé à l'offre
     User user = userRepo.findById(idUser)
     .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé avec l'ID : " + idUser));
    updatedOffre.setUser(user);
    return offreRepo.save(updatedOffre);

}


    @Override
    public Offre deleteOffre(Long idOffre)
    {
        offreRepo.deleteById(idOffre);
        return null;
    }

    }
