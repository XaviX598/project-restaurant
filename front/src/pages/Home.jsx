import { useState, useEffect } from 'react'
import './Home.css'
import { useMenu } from '../hooks/useMenu'
import { useRestaurant } from '../hooks/useRestaurant'
import Header from '../components/Header'
import Hero from '../components/Hero'
import About from '../components/About'
import Menu from '../components/Menu'
import Location from '../components/Location'
import Contact from '../components/Contact'
import WhatsAppButton from '../components/WhatsAppButton'
import Footer from '../components/Footer'

function Home() {
  const { menuItems, categories, loading: menuLoading } = useMenu()
  const { restaurantInfo, loading: restaurantLoading } = useRestaurant()
  const [scrolled, setScrolled] = useState(false)

  useEffect(() => {
    const handleScroll = () => {
      setScrolled(window.scrollY > 50)
    }
    window.addEventListener('scroll', handleScroll)
    return () => window.removeEventListener('scroll', handleScroll)
  }, [])

  useEffect(() => {
    const observerOptions = {
      threshold: 0.1,
      rootMargin: '0px 0px -50px 0px'
    }

    const observer = new IntersectionObserver((entries) => {
      entries.forEach(entry => {
        if (entry.isIntersecting) {
          entry.target.classList.add('visible')
        }
      })
    }, observerOptions)

    document.querySelectorAll('.fade-in').forEach(el => {
      observer.observe(el)
    })

    return () => observer.disconnect()
  }, [])

  if (menuLoading || restaurantLoading) {
    return (
      <div className="loading-screen">
        <div className="loading-spinner"></div>
        <p>Cargando...</p>
      </div>
    )
  }

  return (
    <div className="home">
      <Header scrolled={scrolled} restaurantInfo={restaurantInfo} />
      <Hero restaurantInfo={restaurantInfo} />
      <About restaurantInfo={restaurantInfo} />
      <Menu menuItems={menuItems} categories={categories} />
      <Location restaurantInfo={restaurantInfo} />
      <Contact restaurantInfo={restaurantInfo} />
      <WhatsAppButton phoneNumber={restaurantInfo?.linkWhatsapp} />
      <Footer restaurantInfo={restaurantInfo} />
    </div>
  )
}

export default Home
