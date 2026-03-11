import './Contact.css'

function Contact({ restaurantInfo }) {
  return (
    <section id="contact" className="contact">
      <div className="contact-container">
        <span className="contact-label animate-fade-in">Contáctanos</span>
        <h2 className="animate-slide-up">Reserva tu Mesa</h2>
        <p className="contact-subtitle animate-fade-in">
          ¿Planeas una cena especial? Estamos listos para recibirte
        </p>
        
        <div className="contact-card">
          <span className="contact-card-icon">💬</span>
          <h3>Reserva por WhatsApp</h3>
          <p>Envíanos un mensaje y te atenderemos inmediatamente</p>
          <a 
            href={restaurantInfo?.linkWhatsapp || 'https://wa.me/593991234567?text=Hola,%20me%20gustaría%20reservar%20una%20mesa'} 
            target="_blank" 
            rel="noopener noreferrer"
            className="contact-cta"
          >
            Reservar Ahora
          </a>
        </div>
      </div>
    </section>
  )
}

export default Contact
