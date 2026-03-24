package com.example.demo.controller;

import com.example.demo.entity.BoutiqueEntity;
import com.example.demo.service.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/boutiques")
public class BoutiqueController {
    @Autowired
    private BoutiqueService boutiqueService;

    @GetMapping
    public List<BoutiqueEntity> getAllBoutiques() {
        return boutiqueService.getAllBoutiques();
    }

    @GetMapping("/{id}")
    public BoutiqueEntity getBoutiqueById(@PathVariable Long id) {
        return boutiqueService.getBoutiqueById(id);
    }

    @GetMapping("/boutique/{nom}")
    public BoutiqueEntity getBoutiqueByNom(@PathVariable String nom) {
        return boutiqueService.getBoutiqueByNom(nom);
    }

    @PostMapping
    public BoutiqueEntity createBoutique(@RequestBody BoutiqueEntity boutique) {
        return boutiqueService.createBoutique(boutique);
    }
    
    @PutMapping("/{id}")
    public BoutiqueEntity updateBoutique(@PathVariable Long id, @RequestBody BoutiqueEntity boutique) {
        return boutiqueService.updateBoutique(id, boutique);
    }

    @DeleteMapping("/{id}")
    public void deleteBoutique(@PathVariable Long id) {
        boutiqueService.deleteBoutique(id);
    }
    
}
