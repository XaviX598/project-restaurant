import './Footer.css'

function Footer({ restaurantInfo }) {
  const currentYear = new Date().getFullYear()

  return (
    <footer className="footer">
      <div className="container">
        <div className="footer-content">
          <div className="footer-brand">
            <h3>{restaurantInfo?.nombre || 'Trattoria Roma'}</h3>
            <p>Auténtica cocina italiana en Quito</p>
          </div>
          <div className="footer-links">
            <h4>Enlaces</h4>
            <a href="#hero">Inicio</a>
            <a href="#about">Nosotros</a>
            <a href="#menu">Menú</a>
            <a href="#location">Ubicación</a>
          </div>
          <div className="footer-contact">
            <h4>Contacto</h4>
            <p>{restaurantInfo?.direccion || 'Av. González Suárez N27-187, Quito'}</p>
            <p>{restaurantInfo?.telefono || '+593 2 123 4567'}</p>
            <p>{restaurantInfo?.email || 'reservas@trattoriaroma.ec'}</p>
          </div>
          <div className="footer-social">
            <h4>Síguenos</h4>
            <div className="social-icons">
              <a href="#" aria-label="Instagram">📷</a>
              <a href="#" aria-label="Facebook">📘</a>
              <a href="#" aria-label="Twitter">🐦</a>
            </div>
          </div>
        </div>
        <div className="footer-bottom">
          <p>© {currentYear} Trattoria Roma. Todos los derechos reservados.</p>
          <p>Desarrollado con ❤️ para los amantes de la buena comida</p>
        </div>
      </div>
    </footer>
  )
}

export default Footer
