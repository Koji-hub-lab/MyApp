package com.example.demo.entity;

//import com.example.demo.entity.Status;
import jakarta.persistence.*;

@Entity
@Table(name="boutiques")

public class BoutiqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boutiqueId;

    @Column(name = "nomBoutique",nullable = false)
    private String nomBoutique;

    @Column(name = "adresse",nullable = false)
    private String adresseBoutique;

    @Column(name = "email",nullable = false, unique = true)
    private String emailBoutique;

    @Column(name = "telephone",nullable = false, unique = true)
    private Long telephoneBoutique;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="ENUM('ACTIF','INACTIF') DEFAULT 'ACTIF'")
    private Status status = Status.ACTIF;

    @Column(name="created_at", nullable = false, updatable = false)
    private java.time.LocalDateTime createdAt = java.time.LocalDateTime.now();  

    public BoutiqueEntity(Long boutiqueId, String nomBoutique, String adresseBoutique,Long telephoneBoutique, String emailBoutique, Status status){
        this.boutiqueId=boutiqueId;
        this.nomBoutique=nomBoutique;
        this.adresseBoutique=adresseBoutique;
        this.emailBoutique=emailBoutique;
        this.telephoneBoutique=telephoneBoutique;
        this.status=status;
        this.createdAt=java.time.LocalDateTime.now();
    }

    

}
