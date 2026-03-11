import { useState, useEffect } from 'react'
import { getMenuItems, getCategories } from '../services/menuService'

export const useMenu = () => {
  const [menuItems, setMenuItems] = useState([])
  const [categories, setCategories] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true)
        const [items, cats] = await Promise.all([
          getMenuItems(),
          getCategories()
        ])
        setMenuItems(items)
        setCategories(cats)
      } catch (err) {
        setError(err.message)
      } finally {
        setLoading(false)
      }
    }
    fetchData()
  }, [])

  const getItemsByCategory = (categoria) => {
    if (!categoria) return menuItems
    return menuItems.filter(item => item.categoria === categoria)
  }

  return { menuItems, categories, loading, error, getItemsByCategory }
}
