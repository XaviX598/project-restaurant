import axios from 'axios'

// En desarrollo, usa rutas relativas para aprovechar el proxy de Vite
// En producción, usa la URL completa del API
const baseURL = import.meta.env.VITE_API_URL || 'http://localhost:8080/api'

const api = axios.create({
  baseURL,
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json'
  }
})

api.interceptors.response.use(
  response => response,
  error => {
    console.error('Error en la petición:', error)
    return Promise.reject(error)
  }
)

export default api
