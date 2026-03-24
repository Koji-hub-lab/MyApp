package com.example.demo.repository;
import com.example.demo.entity.BoutiqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
 

public interface BoutiqueRepository extends JpaRepository<BoutiqueEntity, Long> {

    BoutiqueEntity findByBoutiqueId(Long boutiqueId);

    BoutiqueEntity findByNomBoutique(String nomBoutique);
    
}
