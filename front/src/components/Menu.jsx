import { useState } from 'react'
import './Menu.css'

function Menu({ menuItems, categories }) {
  const [activeCategory, setActiveCategory] = useState('all')

  const filteredItems = activeCategory === 'all' 
    ? menuItems 
    : menuItems.filter(item => item.categoria === activeCategory)

  const formatPrice = (price) => {
    return `$${parseFloat(price).toFixed(2)}`
  }

  return (
    <section id="menu" className="menu">
      <div className="menu-container">
        <span className="menu-label">Nuestro Menú</span>
        <h2>Delicias Italianas</h2>
        <p className="menu-subtitle">
          Descubre nuestra selección de platillos preparados con ingredientes frescos y recetas auténticas
        </p>

        <div className="menu-categories">
          <button 
            className={`category-btn ${activeCategory === 'all' ? 'active' : ''}`}
            onClick={() => setActiveCategory('all')}
          >
            Todos
          </button>
          {categories.map((category, index) => (
            <button 
              key={category}
              className={`category-btn ${activeCategory === category ? 'active' : ''}`}
              onClick={() => setActiveCategory(category)}
              style={{ animationDelay: `${index * 0.05}s` }}
            >
              {category}
            </button>
          ))}
        </div>

        <div className="menu-grid">
          {filteredItems.map((item, index) => (
            <div 
              key={item.id} 
              className="menu-item"
              style={{ animationDelay: `${index * 0.08}s` }}
            >
              <div className="menu-item-image">
                <img src={item.imagen} alt={item.nombre} />
                <span className="menu-item-category">{item.categoria}</span>
              </div>
              <div className="menu-item-content">
                <div className="menu-item-header">
                  <h3 className="menu-item-name">{item.nombre}</h3>
                  <span className="menu-item-price">{formatPrice(item.precio)}</span>
                </div>
                <p className="menu-item-description">{item.descripcion}</p>
                {item.ingredientes && (
                  <span className="menu-item-ingredients">
                    {item.ingredientes}
                  </span>
                )}
              </div>
            </div>
          ))}
        </div>
      </div>
    </section>
  )
}

export default Menu
