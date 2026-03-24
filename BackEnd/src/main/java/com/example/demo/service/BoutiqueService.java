package com.example.demo.service;

import com.example.demo.entity.BoutiqueEntity;
import com.example.demo.repository.BoutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BoutiqueService {
    @Autowired
    private BoutiqueRepository boutiqueRepository;

    public java.util.List<BoutiqueEntity> getAllBoutiques() {
        return boutiqueRepository.findAll();
    }

    public BoutiqueEntity getBoutiqueById(Long id) {
        return boutiqueRepository.findById(id).orElse(null);
    }

    public BoutiqueEntity getBoutiqueByNom(String nom) {
        return boutiqueRepository.findByNomBoutique(nom);
    }

    public BoutiqueEntity createBoutique(BoutiqueEntity boutique) {
        return boutiqueRepository.save(boutique);
    }

    public BoutiqueEntity updateBoutique(Long id, BoutiqueEntity boutique) {
        BoutiqueEntity existantBoutique = boutiqueRepository.findById(id).orElse(null);
        if (existantBoutique != null) {
            existantBoutique.setNomBoutique(boutique.getNomBoutique());
            existantBoutique.setAdresseBoutique(boutique.getAdresseBoutique());
            existantBoutique.setEmailBoutique(boutique.getEmailBoutique());
            existantBoutique.setTelephoneBoutique(boutique.getTelephoneBoutique());
            existantBoutique.setStatus(boutique.getStatus());
            existantBoutique.setCreatedAt(boutique.getCreatedAt());
            return boutiqueRepository.save(existantBoutique);
        }
        return null;
    }

    public void deleteBoutique(Long id) {
        boutiqueRepository.deleteById(id);
    }

}
