import { useState } from 'react'
import '../css/reset-password.css'
import { useNavigate } from 'react-router-dom'

function ResetPassword() {
  const [email, setEmail] = useState('')
  const [message, setMessage] = useState('')
  const navigate=useNavigate()
  const handleReset = async () => {
    try {
      const response = await fetch(
        `http://localhost:8080/api/users/resetPassword?email=${email}`,
        { method: 'POST' }
      )

      const data = await response.text()
      if (response.ok) {
        setMessage(data)
      } 
      else {
        setMessage(data)
      }
    } catch (error) {
      setMessage('Erreur de connexion au serveur ❌')
    }
  }

  return (
    <div className="reset-container">
      <div className="reset-box">
        <h2>Reset Password </h2>

        <input
          type="email"
          placeholder="Entrer votre email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <button onClick={handleReset}>Recevoir le nouveau mot de passe</button>
        <button onClick={() => navigate('/Login')}>Retour à la page de connexion</button>

        {message && <p className="message">{message}</p>}
      </div>
    </div>
  )
}   

export default ResetPassword