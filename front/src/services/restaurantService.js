import api from '../api/axios'

export const getRestaurantInfo = async () => {
  const response = await api.get('/restaurant')
  return response.data
}
