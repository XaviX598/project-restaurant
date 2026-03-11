import { useState } from 'react'
import { Link } from 'react-scroll'
import './Header.css'

function Header({ scrolled, restaurantInfo }) {
  const [menuOpen, setMenuOpen] = useState(false)

  const toggleMenu = () => {
    setMenuOpen(!menuOpen)
  }

  const navItems = [
    { name: 'Inicio', to: 'hero' },
    { name: 'Nosotros', to: 'about' },
    { name: 'Menú', to: 'menu' },
    { name: 'Ubicación', to: 'location' },
    { name: 'Contacto', to: 'contact' }
  ]

  return (
    <header className={`header ${scrolled ? 'scrolled' : ''}`}>
      <div className="header-container">
        <Link to="hero" smooth={true} duration={500} className="logo">
          <span className="logo-text">{restaurantInfo?.nombre || 'Trattoria Roma'}</span>
        </Link>

        <nav className={`nav ${menuOpen ? 'open' : ''}`}>
          {navItems.map(item => (
            <Link
              key={item.to}
              to={item.to}
              smooth={true}
              duration={500}
              className="nav-link"
              onClick={() => setMenuOpen(false)}
            >
              {item.name}
            </Link>
          ))}
        </nav>

        <button className={`menu-toggle ${menuOpen ? 'open' : ''}`} onClick={toggleMenu} aria-label="Menu">
          <span></span>
          <span></span>
          <span></span>
        </button>
      </div>
    </header>
  )
}

export default Header
