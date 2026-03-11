import './About.css'

function About({ restaurantInfo }) {
  return (
    <section id="about" className="about">
      <div className="about-container">
        <span className="about-label animate-fade-in">Nuestra Historia</span>
        <h2 className="animate-slide-up">Pasión por la Cocina Italiana</h2>
        <p className="about-subtitle animate-fade-in">
          Tradición italiana con un toque moderno en el corazón de Quito
        </p>
        
        <div className="about-content">
          <div className="about-image">
            <img 
              src="https://images.unsplash.com/photo-1555396273-367ea4eb4db5?w=600" 
              alt="Interior del restaurante" 
            />
            <div className="about-image-accent"></div>
          </div>
          
          <div className="about-text">
            <p>
              {restaurantInfo?.descripcion || `En Trattoria Roma, creemos que la buena comida es una forma de amor. 
              Desde 2015, hemos traído los auténticos sabores de Italia a Quito, usando solo los ingredientes 
              más frescos y recetas tradicionales transmitidas por generaciones.`}
            </p>
            <p>
              Nuestro chef, avecinado en Roma, combina técnicas ancestrales con creatividad 
              moderna para crear platillos que conquistan paladares. Cada pasta se hace a mano 
              diariamente, cada pizza hornea en nuestro horno de leña, y cada detalle está 
              pensado para brindarte una experiencia gastronómica inolvidable.
            </p>
            <div className="about-features">
              <div className="feature">
                <span className="feature-icon">🍝</span>
                <span className="feature-text">Pasta Casera</span>
              </div>
              <div className="feature">
                <span className="feature-icon">🔥</span>
                <span className="feature-text">Horno de Leña</span>
              </div>
              <div className="feature">
                <span className="feature-icon">🍷</span>
                <span className="feature-text">Vinos Selectos</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  )
}

export default About
