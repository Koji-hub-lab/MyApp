import { useNavigate } from 'react-router-dom'
import { useState } from 'react'
import '../css/register.css'

function RegisterBoutique() {
  const [email, setEmail] = useState('')
  const [nom, setNom] = useState('')
  const [adresse, setAdresse] = useState('')
  const [telephone, setTelephone]=useState('')
  const navigate = useNavigate()
  //const [status, setStatus] = useState('')
  const [message, setMessage] = useState('')

  const handleRegister = async () => {
    try {
      const response = await fetch(
        'http://localhost:8080/api/boutiques',
        {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({ nom, email, telephone, adresse, status: "ACTIF" })
        }
      )

      if (response.ok) {
          navigate('/Login')
        } else {
        setMessage('Une boutique avec ce nom existe déjà ❌')
      }
    } catch (error) {
      setMessage('Erreur de connexion au serveur ❌')
    }
  }

  return (
    <div className="register-container">
      <div className="register-box">
        <h2>Ajout d'une Boutique</h2>

        <input
          type="text"
          placeholder="Nom"
          value={nom}
          onChange={(e) => setNom(e.target.value)}
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

        <input
          type="text"
          placeholder="Adresse"
          value={adresse}
          onChange={(e) => setAdresse(e.target.value)}
        />

        <button onClick={handleRegister}>Enregister</button>

        {message && <p className="message">{message}</p>}
      </div>
    </div>
  )
}

export default RegisterBoutique