import './Location.css'

function Location({ restaurantInfo }) {
  return (
    <section id="location" className="location">
      <div className="location-container">
        <span className="location-label animate-fade-in">Encuéntranos</span>
        <h2 className="animate-slide-up">Nuestra Ubicación</h2>
        
        <div className="location-content">
          <div className="location-info">
            <div className="info-item">
              <span className="info-icon">📍</span>
              <div>
                <h3>Dirección</h3>
                <p>{restaurantInfo?.direccion || 'Av. González Suárez N27-187, La Floresta, Quito'}</p>
              </div>
            </div>
            <div className="info-item">
              <span className="info-icon">🕐</span>
              <div>
                <h3>Horario</h3>
                <p>{restaurantInfo?.horario || 'Lunes a Domingo: 12:00 - 22:00'}</p>
              </div>
            </div>
            <div className="info-item">
              <span className="info-icon">📞</span>
              <div>
                <h3>Teléfono</h3>
                <p>{restaurantInfo?.telefono || '+593 2 123 4567'}</p>
              </div>
            </div>
            <div className="info-item">
              <span className="info-icon">✉️</span>
              <div>
                <h3>Email</h3>
                <p>{restaurantInfo?.email || 'reservas@trattoriaroma.ec'}</p>
              </div>
            </div>
          </div>

          <div className="location-map animate-scale-in">
            <iframe
              src={restaurantInfo?.linkMapa || 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3989.814456789012!2d-78.483409!3d-0.183762!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x91d5918575456789%3A0x1234567890abcdef!2sAv.%20Gonz%C3%A1lez%20Su%C3%A1rez%20N27-187%2C%20Quito!5e0!3m2!1ses!2sec!4v1234567890'}
              width="100%"
              height="100%"
              style={{ border: 0 }}
              allowFullScreen=""
              loading="lazy"
              referrerPolicy="no-referrer-when-downgrade"
              title="Ubicación del restaurante"
            ></iframe>
          </div>
        </div>
      </div>
    </section>
  )
}

export default Location
