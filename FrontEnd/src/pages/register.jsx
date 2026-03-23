import { useNavigate } from 'react-router-dom'
import { useState } from 'react'
import '../css/register.css'

function Register() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [prenom, setPrenom] = useState('')
  const [nom, setNom] = useState('')
  const navigate = useNavigate()
  //const [status, setStatus] = useState('')
  const [message, setMessage] = useState('')

  const handleRegister = async () => {
    try {
      const response = await fetch(
        'http://localhost:8080/api/users',
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ nom, prenom, email, password, status:"ACTIF"})
        }
      )

      if (response.ok) {
        navigate('/Login')
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