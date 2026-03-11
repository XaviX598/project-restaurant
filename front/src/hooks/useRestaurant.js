import { useState, useEffect } from 'react'
import { getRestaurantInfo } from '../services/restaurantService'

export const useRestaurant = () => {
  const [restaurantInfo, setRestaurantInfo] = useState(null)
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true)
        const info = await getRestaurantInfo()
        setRestaurantInfo(info)
      } catch (err) {
        setError(err.message)
      } finally {
        setLoading(false)
      }
    }
    fetchData()
  }, [])

  return { restaurantInfo, loading, error }
}
