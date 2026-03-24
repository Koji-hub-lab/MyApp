import {BrowserRouter, Routes, Route } from 'react-router-dom'
import Login from './pages/login'
import Register from './pages/register'
import ResetPassword from './pages/reset-password'
import RegisterBoutique from './pages/registerBoutique'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Register/>} />
        <Route path="/Login" element={<Login/>} />
        <Route path="/reset-password" element={<ResetPassword/>} />
        <Route path="/registerBoutique" element={<RegisterBoutique/>} /> {/* Ajoutez cette ligne pour la page d'inscription de la boutique */}
      </Routes>
    </BrowserRouter>
    /*<div>
      <Register />
    </div>*/
  )
}

export default App