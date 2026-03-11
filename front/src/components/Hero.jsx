import { Link } from 'react-scroll'
import './Hero.css'

function Hero({ restaurantInfo }) {
  return (
    <section id="hero" className="hero">
      <div className="hero-overlay"></div>
      <div className="hero-content">
        <span className="hero-tagline fade-in">Auténtica Cocina Italiana</span>
        <h1 className="hero-title fade-in" style={{ animationDelay: '0.2s' }}>
          {restaurantInfo?.nombre || 'Trattoria Roma'}
        </h1>
        <p className="hero-description fade-in" style={{ animationDelay: '0.4s' }}>
          Experimenta los sabores de Italia en el corazón de Quito
        </p>
        <div className="hero-buttons fade-in" style={{ animationDelay: '0.6s' }}>
          <Link to="menu" smooth={true} duration={500} className="btn btn-primary">
            Ver Menú
          </Link>
          <Link to="location" smooth={true} duration={500} className="btn btn-outline">
            Visitarnos
          </Link>
        </div>
      </div>
      <div className="hero-scroll-indicator">
        <span>Scroll</span>
        <div className="scroll-arrow"></div>
      </div>
    </section>
  )
}

export default Hero
