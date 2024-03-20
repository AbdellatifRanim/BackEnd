package com.example.demo.repositiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Offre;

@Repository //Cette annotation indique à Spring que cette interface est un repository
public interface OffreRepo extends JpaRepository<Offre, Long> {
   
    // Cette interface étend JpaRepository, qui fournit des méthodes pour interagir avec la base de données
  
  
}
