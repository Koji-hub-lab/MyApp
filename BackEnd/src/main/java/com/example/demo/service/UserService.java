package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity existantUser = userRepository.findById(id).orElse(null);
        if (existantUser != null) {
            existantUser.setNom(user.getNom());
            existantUser.setEmail(user.getEmail());
            existantUser.setPassword(user.getPassword());
            existantUser.setPrenom(user.getPrenom());
            existantUser.setTelephone(user.getTelephone());
            existantUser.setStatus(user.getStatus());
            existantUser.setRole(user.getRole());
            existantUser.setCreatedAt(user.getCreatedAt());
            existantUser.setLastLogin(user.getLastLogin());
            return userRepository.save(existantUser);
        }
        return null;
    }

    public ResponseEntity<String> updatePassword(Long id,String password) {
        UserEntity existantUser = userRepository.findById(id).orElse(null);
        if (existantUser != null) {
            existantUser.setPassword(password);
            userRepository.save(existantUser);
            return ResponseEntity.ok("Mot de passe modifier");
        }
        return null;
    }

    private String genererMotDePasseTemporaire() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder mdp = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < 8; i++) {
            mdp.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return mdp.toString();
    }

    public ResponseEntity<String> resetPassword(String email) {
        UserEntity user = userRepository.findByEmail(email);
    
        if (user == null) {
            return ResponseEntity.status(404).body("Aucun compte associe a cet email");
        }
    
        // Generer un mot de passe temporaire
        String nouveauMotDePasse = genererMotDePasseTemporaire();
    
        user.setPassword(nouveauMotDePasse);
        userRepository.save(user);
    
        return ResponseEntity.ok("Nouveau mot de passe : " + nouveauMotDePasse);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /*public void loginUser(UserEntity user){
        String email = user.getEmail();
        String password=user.getPassword();
        UserEntity existant = userRepository.findByEmail(email);

        if (existant != null){
            String pass = existant.getPassword();
            if(pass.equals(password)){
                System.out.println("Connexion Reussi"); 
            }
            else{
                System.out.println("Email ou mot de passe incorect");
            }
        }
    }*/

    public ResponseEntity<String> loginUser(String identifiant ,String password) {
        UserEntity existant = userRepository.findByEmail(identifiant);
        if (existant == null) {
            existant = userRepository.findByNom(identifiant);
        }
        
        if (existant != null) {
            if (existant.getPassword().equals(password)) {
                System.out.println("Connexion Reussie");
                return ResponseEntity.ok(existant.getRole().toString());
            } else {
                return ResponseEntity.status(401).body("Mot de passe incorrect");
            }
        } else {
            System.out.println("Utilisateur non trouvé");
            return ResponseEntity.ok("Utilisateur non trouvé");
        }
    }


// ── Télécharger un fichier ─────────────────────
    public ResponseEntity<ByteArrayResource> downloadFichier(Long id) {
        // 1 — Chercher le user
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        // 2 — Générer le contenu du fichier
        byte[] contenu = generateFileContent(user);
        ByteArrayResource resource = new ByteArrayResource(contenu);

        // 3 — Retourner le fichier en réponse
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"user_" + id + ".txt\"")
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .contentLength(contenu.length)
            .body(resource);
    }

    // ── Générer le contenu du fichier ─────────────
    private byte[] generateFileContent(UserEntity user) {
        String contenu =
            "===== FICHE UTILISATEUR =====\n" +
            "ID       : " + user.getId()       + "\n" +
            "Nom      : " + user.getNom()      + "\n" +
            "Prénom   : " + user.getPrenom()   + "\n" +
            "Email    : " + user.getEmail()    + "\n" +
            "=============================\n";

        return contenu.getBytes();
    }
}