import axios from 'axios'

const api = axios.create({
  baseURL: 'https://api.exemplo.com',
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json',
    // Authorization: `Bearer ${token}`
  }
})

export default api
