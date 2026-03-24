package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "boutiques")
public class BoutiqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boutiqueId;

    @Column(name = "nom", nullable = false, unique = true)
    @JsonProperty("nom")
    private String nomBoutique;

    @Column(name = "adresse", nullable = false)
    @JsonProperty("adresse")
    private String adresseBoutique;

    @Column(name = "email", nullable = false, unique = true)
    @JsonProperty("email")
    private String emailBoutique;

    @Column(name = "telephone", nullable = false, unique = true)
    @JsonProperty("telephone")      
    private String telephoneBoutique;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ACTIF','INACTIF') DEFAULT 'ACTIF'")
    private Status status = Status.ACTIF;

    @Column(name = "created_at", nullable = false, updatable = false)
    private java.time.LocalDateTime createdAt = java.time.LocalDateTime.now();

    public BoutiqueEntity() {}

    public BoutiqueEntity(Long boutiqueId, String nomBoutique, String adresseBoutique,
                          String telephoneBoutique, String emailBoutique, Status status) {
        this.boutiqueId = boutiqueId;
        this.nomBoutique = nomBoutique;
        this.adresseBoutique = adresseBoutique;
        this.emailBoutique = emailBoutique;
        this.telephoneBoutique = telephoneBoutique;
        this.status = Status.ACTIF;
        this.createdAt = java.time.LocalDateTime.now();
    }

    public Long getBoutiqueId() { return boutiqueId; }
    public void setBoutiqueId(Long boutiqueId) { this.boutiqueId = boutiqueId; }
    public String getNomBoutique() { return nomBoutique; }
    public void setNomBoutique(String nomBoutique) { this.nomBoutique = nomBoutique; }
    public String getAdresseBoutique() { return adresseBoutique; }
    public void setAdresseBoutique(String adresseBoutique) { this.adresseBoutique = adresseBoutique; }
    public String getEmailBoutique() { return emailBoutique; }
    public void setEmailBoutique(String emailBoutique) { this.emailBoutique = emailBoutique; }
    public String getTelephoneBoutique() { return telephoneBoutique; }
    public void setTelephoneBoutique(String telephoneBoutique) { this.telephoneBoutique = telephoneBoutique; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public java.time.LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }
}