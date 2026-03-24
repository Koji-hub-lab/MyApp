package com.example.demo.entity;

//import com.example.demo.entity.Status;
import jakarta.persistence.*;

@Entity
@Table(name="users")

public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom", nullable = false)
    private String nom;

    @Column(name="prenom", nullable= false)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "telephone",nullable = false)
    private long telephone;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="ENUM('ADMIN', 'GESTIONNAIRE_ENTREPOT', 'GESTIONNAIRE_BOUTIQUE', 'VENDEUR', 'COMPTABLE', 'OPERATEUR') DEFAULT 'VENDEUR'")
    private Role role = Role.VENDEUR;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="ENUM('ACTIF','INACTIF') DEFAULT 'ACTIF'")
    private Status status = Status.ACTIF;

    @Column(name="created_at", nullable = false, updatable = false)
    private java.time.LocalDateTime createdAt = java.time.LocalDateTime.now();  

    @Column(name="last_login", nullable = true)
    private java.time.LocalDateTime lastLogin;  

    // constructeur par defaut obligatoire pour JPA//
    public UserEntity(){}

    // constructeur avec parametres
    public UserEntity(String nom,String prenom,String email,String password,Status status){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.password=password;
        this.status=status;
        this.createdAt=java.time.LocalDateTime.now();
        this.lastLogin=null;
        this.role=Role.VENDEUR;
    }

    // Getter et Setter //
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public String getPrenom(){
        return prenom;
    }

    public void setPrenom(String prenom){
        this.prenom=prenom;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status=status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public java.time.LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(java.time.LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

}
