import { useNavigate } from 'react-router-dom'
import { useState } from 'react'
import '../css/register.css'

function Register() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [prenom, setPrenom] = useState('')
  const [nom, setNom] = useState('')
  const [role, setRole] = useState('VENDEUR')
  const [telephone, setTelephone]=useState('')
  const navigate = useNavigate()
  //const [status, setStatus] = useState('')
  const [message, setMessage] = useState('')

  const handleRegister = async () => {
    try {
      const response = await fetch(
        '/api/users',
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ nom, prenom, email,telephone,role, password, status:"ACTIF"})
        }
      )

      if (response.ok) {
        if(role === 'ADMIN') {
          navigate('/Login')
        }
        if(role === 'VENDEUR') {
          setMessage('Inscription réussie ✅ Veuillez vous connecter pour accéder à votre espace vendeur')
        }
        if(role === 'GESTIONNAIRE_ENTREPOT') {
          setMessage('Inscription réussie ✅ Veuillez vous connecter pour accéder à votre espace gestionnaire entrepot')
        }
        if(role === 'GESTIONNAIRE_BOUTIQUE') {
          setMessage('Inscription réussie ✅ Veuillez vous connecter pour accéder à votre espace gestionnaire boutique')
        }
        if(role === 'COMPTABLE') {
          setMessage('Inscription réussie ✅ Veuillez vous connecter pour accéder à votre espace comptable')
        }
        if(role === 'OPERATEUR') {
          setMessage('Inscription réussie ✅ Veuillez vous connecter pour accéder à votre espace operateur')
        }

      } else {
        setMessage('Un utilisateur avec cet email existe déjà ❌')
      }
    } catch (error) {
      setMessage('Erreur de connexion au serveur ❌')
    }
  }

  return (
    <div className="register-container">
      <div className="register-box">
        <h2>Inscription</h2>

        <input
          type="text"
          placeholder="Nom"
          value={nom}
          onChange={(e) => setNom(e.target.value)}
        />

        <input
          type="text"
          placeholder="Prenom"
          value={prenom}
          onChange={(e) => setPrenom(e.target.value)}
        />

        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <input
          type="text"
          placeholder="Telephone"
          value={telephone}
          onChange={(e) => setTelephone(e.target.value)}
        />

        <select
          value={role}
          onChange={(e) => setRole(e.target.value)}
        >
          <option value="VENDEUR">Vendeur</option>
          <option value="GESTIONNAIRE_ENTREPOT">Gestionnaire Entrepot</option>
          <option value="GESTIONNAIRE_BOUTIQUE">Gestionnaire Boutique</option>
          <option value="COMPTABLE">Comptable</option>
          <option value="OPERATEUR">Operateur</option>
          <option value="ADMIN">Administrateur</option>
        </select>

        <input
          type="password"
          placeholder="Mot de passe"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <button onClick={handleRegister}>S'inscrire</button>

        {message && <p className="message">{message}</p>}
      </div>
    </div>
  )
}

export default Register