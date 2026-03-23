import {BrowserRouter, Routes, Route } from 'react-router-dom'
import Login from './pages/login'
import Register from './pages/register'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Register/>} />
        <Route path="/Login" element={<Login/>} />
      </Routes>
    </BrowserRouter>
    /*<div>
      <Register />
    </div>*/
  )
}

export default App