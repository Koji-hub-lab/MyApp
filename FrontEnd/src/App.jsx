import {BrowserRouter, Routes, Route } from 'react-router-dom'
import Login from './pages/login'
import Register from './pages/register'
import ResetPassword from './pages/reset-password'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Register/>} />
        <Route path="/Login" element={<Login/>} />
        <Route path="/reset-password" element={<ResetPassword/>} />
      </Routes>
    </BrowserRouter>
    /*<div>
      <Register />
    </div>*/
  )
}

export default App