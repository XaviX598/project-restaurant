import api from '../api/axios'

export const getMenuItems = async () => {
  const response = await api.get('/menu')
  return response.data
}

export const getAvailableMenuItems = async () => {
  const response = await api.get('/menu/disponibles')
  return response.data
}

export const getMenuItemsByCategory = async (categoria) => {
  const response = await api.get(`/menu/categoria/${categoria}`)
  return response.data
}

export const getMenuItemById = async (id) => {
  const response = await api.get(`/menu/${id}`)
  return response.data
}

export const getCategories = async () => {
  const response = await api.get('/menu/categorias')
  return response.data
}
