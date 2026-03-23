import { useState } from 'react'
import '../css/login.css'
import { useNavigate } from 'react-router-dom'

function Login() {
  const [identifiant, setIdentifiant] = useState('')
  const [password, setPassword] = useState('')
  const [message, setMessage] = useState('')

  const handleLogin = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/api/users/login?identifiant=${identifiant}&password=${password}`,
        { method: 'POST' }
      )

      if (response.ok) {
        setMessage('Connexion réussie ✅')
      } else {
        setMessage('Email ou mot de passe incorrect ❌')
      }
    } catch (error) {
      setMessage('Erreur de connexion au serveur ❌')
    }
  }

  return (
    <div className="login-container">
      <div className="login-box">
        <h2>Connexion</h2>

        <input
          type="text"
          placeholder="Email ou Nom d'utilisateur"
          value={identifiant}
          onChange={(e) => setIdentifiant(e.target.value)}
        />

        <input
          type="password"
          placeholder="Mot de passe"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />

        <button onClick={handleLogin}>Se connecter</button>
        <a href='/'>Pas de compte ? Inscrivez-vous</a>
        <a href='/reset-password'>Mot de passe oublié ?</a>

        {message && <p className="message">{message}</p>}
      </div>
    </div>
  )
}

export default Login