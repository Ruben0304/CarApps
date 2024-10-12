import React, { useState } from 'react'
import { motion, AnimatePresence } from 'framer-motion'
import { ChevronRight, Calendar, MapPin, Search, Filter, Star, DollarSign, Clock, Car, Home, Grid, User, ArrowRight } from 'lucide-react'

const GlassCard = ({ children, className = '' }) => (
    <div className={`bg-white/30 backdrop-blur-lg rounded-3xl shadow-lg p-6 ${className}`}>
        {children}
    </div>
)

const ExoticButton = ({ children, onClick, className = '', variant = 'default' }) => {
    const baseStyle = "font-bold py-3 px-6 rounded-full shadow-lg hover:shadow-xl transition duration-300"
    const variantStyles = {
        default: "bg-black text-white hover:bg-gray-800",
        outline: "bg-transparent border-2 border-black text-black hover:bg-black hover:text-white",
        glass: "bg-black/30 backdrop-blur-lg text-white hover:bg-black/50"
    }

    return (
        <motion.button
            whileHover={{ scale: 1.05 }}
            whileTap={{ scale: 0.95 }}
            className={`${baseStyle} ${variantStyles[variant]} ${className}`}
            onClick={onClick}
        >
            {children}
        </motion.button>
    )
}

const Logo = () => (
    <div className="flex items-center space-x-2">
        <motion.div
            className="w-10 h-10 bg-blue-600 rounded-full flex items-center justify-center"
            whileHover={{ rotate: 360 }}
            transition={{ duration: 0.5 }}
        >
            <Car className="w-6 h-6 text-white" />
        </motion.div>
        <span className="text-2xl font-bold text-blue-600">ExoticRide</span>
    </div>
)

const Navigation = ({ currentScreen, setScreen }) => (
    <div className="fixed bottom-0 left-0 right-0 bg-white/70 backdrop-blur-lg py-4 px-6 flex justify-around z-50">
        {['Home', 'Search', 'Brands', 'Profile'].map((screen) => (
            <motion.button
                key={screen}
                onClick={() => setScreen(screen)}
                whileHover={{ scale: 1.1 }}
                whileTap={{ scale: 0.9 }}
                className={`p-2 rounded-full ${currentScreen === screen ? 'bg-black text-white' : 'bg-black/10 text-black'}`}
            >
                {screen === 'Home' && <Home className="w-6 h-6" />}
                {screen === 'Search' && <Search className="w-6 h-6" />}
                {screen === 'Brands' && <Grid className="w-6 h-6" />}
                {screen === 'Profile' && <User className="w-6 h-6" />}
            </motion.button>
        ))}
    </div>
)

const screens = ['Home', 'Search', 'CarDetails', 'Brands', 'PostOffer', 'Profile']

export default function App() {
    const [currentScreen, setCurrentScreen] = useState('Home')

    const renderScreen = () => {
        switch (currentScreen) {
            case 'Home':
                return <HomeScreen setScreen={setCurrentScreen} />
            case 'Search':
                return <SearchScreen setScreen={setCurrentScreen} />
            case 'CarDetails':
                return <CarDetailsScreen setScreen={setCurrentScreen} />
            case 'Brands':
                return <BrandsScreen setScreen={setCurrentScreen} />
            case 'PostOffer':
                return <PostOfferScreen setScreen={setCurrentScreen} />
            case 'Profile':
                return <ProfileScreen setScreen={setCurrentScreen} />
            default:
                return <HomeScreen setScreen={setCurrentScreen} />
        }
    }

    return (
        <div className="min-h-screen font-sans text-gray-800 bg-gradient-to-br from-pink-100 via-purple-100 to-indigo-100">
            <AnimatePresence mode="wait">
                <motion.div
                    key={currentScreen}
                    initial={{ opacity: 0, y: 20 }}
                    animate={{ opacity: 1, y: 0 }}
                    exit={{ opacity: 0, y: -20 }}
                    transition={{ duration: 0.3 }}
                    className="relative z-10 pb-24"
                >
                    {renderScreen()}
                </motion.div>
            </AnimatePresence>
            <Navigation currentScreen={currentScreen} setScreen={setCurrentScreen} />
        </div>
    )
}

function HomeScreen({ setScreen }) {
    return (
        <div className="p-6 space-y-8">
            <header>
                <Logo />
            </header>

            <GlassCard>
                <h2 className="text-3xl font-bold mb-4">Bienvenido a ExoticRide</h2>
                <p className="mb-4">Descubre y alquila los carros más exclusivos del mundo.</p>
                <ExoticButton onClick={() => setScreen('Search')} className="w-full">
                    <Search className="inline-block mr-2" size={18} />
                    Explorar carros exóticos
                </ExoticButton>
            </GlassCard>

            <section className="space-y-4">
                <h3 className="text-2xl font-semibold">Dashboard</h3>
                <div className="grid grid-cols-2 gap-4">
                    <GlassCard className="space-y-2">
                        <Car className="w-8 h-8 text-blue-600" />
                        <h4 className="font-semibold">Carros disponibles</h4>
                        <p className="text-2xl font-bold">42</p>
                    </GlassCard>
                    <GlassCard className="space-y-2">
                        <Clock className="w-8 h-8 text-blue-600" />
                        <h4 className="font-semibold">Reservas activas</h4>
                        <p className="text-2xl font-bold">7</p>
                    </GlassCard>
                    <GlassCard className="space-y-2">
                        <Star className="w-8 h-8 text-blue-600" />
                        <h4 className="font-semibold">Calificación promedio</h4>
                        <p className="text-2xl font-bold">4.9</p>
                    </GlassCard>
                    <motion.div
                        whileHover={{ scale: 1.05 }}
                        whileTap={{ scale: 0.95 }}
                        className="bg-blue-600 rounded-3xl shadow-lg p-6 text-white flex flex-col justify-between cursor-pointer"
                        onClick={() => setScreen('Profile')}
                    >
                        <DollarSign className="w-8 h-8" />
                        <div>
                            <h4 className="font-semibold">Ingresos del mes</h4>
                            <p className="text-2xl font-bold">$24,500</p>
                        </div>
                        <ArrowRight className="w-6 h-6 self-end" />
                    </motion.div>
                </div>
            </section>

            <section className="space-y-4">
                <h3 className="text-2xl font-semibold">Carros destacados</h3>
                <div className="overflow-x-auto flex space-x-4 pb-4">
                    {[1, 2, 3].map((car) => (
                        <motion.div
                            key={car}
                            className="flex-shrink-0 w-64"
                            whileHover={{ scale: 1.05 }}
                        >
                            <GlassCard className="space-y-2">
                                <img src={`/placeholder.svg?height=120&width=200`} alt="Car" className="w-full h-32 object-cover rounded-lg" />
                                <h4 className="font-semibold">Carro Exótico {car}</h4>
                                <p className="text-sm">Una experiencia de conducción única</p>
                                <ExoticButton onClick={() => setScreen('CarDetails')} className="w-full text-sm py-2" variant="outline">
                                    Ver detalles
                                </ExoticButton>
                            </GlassCard>
                        </motion.div>
                    ))}
                </div>
            </section>
        </div>
    )
}

function SearchScreen({ setScreen }) {
    return (
        <div className="p-6 space-y-8">
            <header className="flex justify-between items-center">
                <h2 className="text-3xl font-bold">Búsqueda</h2>
                <Logo />
            </header>

            <GlassCard>
                <form className="space-y-4">
                    <div className="space-y-2">
                        <label htmlFor="location" className="block text-sm font-medium">Ubicación</label>
                        <div className="relative">
                            <MapPin className="absolute left-3 top-1/2 transform -translate-y-1/2 text-blue-600" size={18} />
                            <input
                                type="text"
                                id="location"
                                placeholder="¿Dónde quieres recoger el carro?"
                                className="pl-10 w-full px-4 py-2 rounded-full bg-white/50 border border-blue-200 focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                            />
                        </div>
                    </div>
                    <div className="space-y-2">
                        <label htmlFor="dates" className="block text-sm font-medium">Fechas</label>
                        <div className="relative">
                            <Calendar className="absolute left-3 top-1/2 transform -translate-y-1/2 text-blue-600" size={18} />
                            <input
                                type="text"
                                id="dates"
                                placeholder="Selecciona las fechas"
                                className="pl-10 w-full px-4 py-2 rounded-full bg-white/50 border border-blue-200 focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                            />
                        </div>
                    </div>
                    <div className="space-y-2">
                        <label htmlFor="price" className="block text-sm font-medium">Rango de precio</label>
                        <div className="relative">
                            <DollarSign className="absolute left-3 top-1/2 transform -translate-y-1/2 text-blue-600" size={18} />
                            <input
                                type="text"
                                id="price"
                                placeholder="Precio mínimo - máximo"
                                className="pl-10 w-full px-4 py-2 rounded-full bg-white/50 border border-blue-200 focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                            />
                        </div>
                    </div>
                    <ExoticButton type="submit" className="w-full">
                        <Search size={18} className="mr-2 inline-block" />
                        Buscar carros exóticos
                    </ExoticButton>
                </form>
            </GlassCard>

            <section className="space-y-4">
                <h3 className="text-2xl font-semibold">Resultados</h3>
                <div className="space-y-4">
                    {[1, 2, 3].map((car) => (
                        <motion.div
                            key={car}
                            initial={{ opacity: 0, y: 20 }}
                            animate={{ opacity: 1, y: 0 }}
                            transition={{ duration: 0.5, delay: car * 0.1 }}
                        >
                            <GlassCard className="flex items-center space-x-4">
                                <img src={`/placeholder.svg?height=80&width=120`} alt="Car" className="w-30 h-20 object-cover rounded-lg" />
                                <div className="flex-grow">
                                    <h4 className="font-semibold">Carro Exótico {car}</h4>
                                    <p className="text-sm text-blue-600">$XXX/día</p>
                                </div>
                                <ExoticButton onClick={() => setScreen('CarDetails')} className="text-sm py-2 px-4" variant="glass">
                                    Ver
                                </ExoticButton>
                            </GlassCard>
                        </motion.div>
                    ))}
                </div>
            </section>
        </div>
    )
}

function CarDetailsScreen({ setScreen }) {
    return (
        <div className="p-6 space-y-8">
            <header className="flex justify-between items-center">
                <h2 className="text-3xl font-bold">Detalles del Carro</h2>
                <Logo />
            </header>

            <img src="/placeholder.svg?height=300&width=600" alt="Car" className="w-full h-48 object-cover rounded-lg" />

            <GlassCard>
                <h3 className="text-2xl font-bold mb-2">Nombre del Carro Exótico</h3>
                <div className="flex items-center space-x-2 mb-4">
                    <Star className="text-yellow-400" size={18} />
                    <span>4.9 (120 reseñas)</span>
                </div>
                <p className="text-gray-600 mb-4">
                    Descripción detallada del carro exótico, incluyendo sus características únicas y por qué es una experiencia inolvidable conducirlo.
                </p>
                <div className="grid grid-cols-2 gap-4 mb-6">
                    <div className="flex items-center space-x-2">
                        <Clock size={18} className="text-blue-600" />
                        <span>0-100 km/h: 3.2s</span>
                    </div>
                    <div className="flex items-center space-x-2">
                        <Car size={18} className="text-blue-600" />
                        <span>Potencia: 700 HP</span>
                    </div>
                    <div className="flex items-center space-x-2">
                        <MapPin size={18} className="text-blue-600" />
                        <span>Ubicación: Miami, FL</span>
                    </div>
                    <div className="flex items-center space-x-2">
                        <DollarSign size={18} className="text-blue-600" />
                        <span>Precio: $1,000/día</span>
                    </div>
                </div>
                <ExoticButton className="w-full">Reservar ahora</ExoticButton>
            </GlassCard>
        </div>
    )
}

function BrandsScreen({ setScreen }) {
    const brands = [
        { name: 'Ferrari', image: '/placeholder.svg?height=100&width=100' },
        { name: 'Lamborghini', image: '/placeholder.svg?height=100&width=100' },
        { name: 'Porsche', image: '/placeholder.svg?height=100&width=100' },
        { name: 'Aston Martin', image: '/placeholder.svg?height=100&width=100' },
        { name: 'McLaren', image: '/placeholder.svg?height=100&width=100' },
        { name: 'Bugatti', image: '/placeholder.svg?height=100&width=100' },
        { name: 'Koenigsegg', image: '/placeholder.svg?height=100&width=100' },
        { name: 'Pagani', image: '/placeholder.svg?height=100&width=100' },
    ]

    return (
        <div className="p-6 space-y-8">
            <header className="flex justify-between items-center">
                <h2 className="text-3xl font-bold">Marcas</h2>
                <Logo />
            </header>

            <GlassCard>
                <h3 className="text-xl font-semibold mb-4">Selecciona una marca</h3>
                <div className="grid grid-cols-2 gap-6">
                    {brands.map((brand) => (
                        <motion.div
                            key={brand.name}
                            className="flex flex-col items-center"
                            whileHover={{ scale: 1.05 }}
                            whileTap={{ scale: 0.95 }}
                            onClick={() => setScreen('Search')}
                        >
                            <img src={brand.image} alt={brand.name} className="w-20 h-20 rounded-full object-cover mb-2" />
                            <p className="text-sm font-medium text-center">{brand.name}</p>
                        </motion.div>
                    ))}
                </div>
            </GlassCard>
        </div>
    )
}

function PostOfferScreen({ setScreen }) {
    return (
        <div className="p-6 space-y-8">
            <header className="flex justify-between items-center">
                <h2 className="text-3xl font-bold">Publicar Oferta</h2>
                <Logo />
            </header>

            <GlassCard>
                <form className="space-y-4">
                    <div className="space-y-2">
                        <label htmlFor="carName" className="block text-sm font-medium">Nombre del carro</label>
                        <input
                            type="text"
                            id="carName"
                            placeholder="Ej. Lamborghini Aventador"
                            className="w-full px-4 py-2 rounded-full bg-white/50 border border-blue-200 focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                        />
                    </div>
                    <div className="space-y-2">
                        <label htmlFor="description" className="block text-sm font-medium">Descripción</label>
                        <textarea
                            id="description"
                            placeholder="Describe tu carro exótico..."
                            className="w-full px-4 py-2 rounded-2xl bg-white/50 border border-blue-200 focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                            rows={4}
                        ></textarea>
                    </div>
                    <div className="space-y-2">
                        <label htmlFor="price" className="block text-sm font-medium">Precio por día</label>
                        <div className="relative">
                            <DollarSign className="absolute left-3 top-1/2 transform -translate-y-1/2 text-blue-600" size={18} />
                            <input
                                type="text"
                                id="price"
                                placeholder="Ej. 1000"
                                className="pl-10 w-full px-4 py-2 rounded-full bg-white/50 border border-blue-200 focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                            />
                        </div>
                    </div>
                    <div className="space-y-2">
                        <label htmlFor="location" className="block text-sm font-medium">Ubicación</label>
                        <div className="relative">
                            <MapPin className="absolute left-3 top-1/2 transform -translate-y-1/2 text-blue-600" size={18} />
                            <input
                                type="text"
                                id="location"
                                placeholder="Ej. Miami, FL"
                                className="pl-10 w-full px-4 py-2 rounded-full bg-white/50 border border-blue-200 focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                            />
                        </div>
                    </div>
                    <ExoticButton type="submit" className="w-full">
                        Publicar oferta
                    </ExoticButton>
                </form>
            </GlassCard>
        </div>
    )
}

function ProfileScreen({ setScreen }) {
    return (
        <div className="p-6 space-y-8">
            <header className="flex justify-between items-center">
                <h2 className="text-3xl font-bold">Perfil</h2>
                <Logo />
            </header>

            <GlassCard className="flex items-center space-x-4">
                <img src="/placeholder.svg?height=100&width=100" alt="Profile" className="w-20 h-20 rounded-full object-cover" />
                <div>
                    <h3 className="text-xl font-semibold">John Doe</h3>
                    <p className="text-blue-600">Miembro desde 2021</p>
                </div>
            </GlassCard>

            <GlassCard>
                <h3 className="text-xl font-semibold mb-4">Estadísticas</h3>
                <div className="grid grid-cols-2 gap-4">
                    <div>
                        <p className="text-sm text-blue-600">Alquileres completados</p>
                        <p className="text-2xl font-bold">23</p>
                    </div>
                    <div>
                        <p className="text-sm text-blue-600">Calificación promedio</p>
                        <p className="text-2xl font-bold">4.9</p>
                    </div>
                    <div>
                        <p className="text-sm text-blue-600">Carros publicados</p>
                        <p className="text-2xl font-bold">3</p>
                    </div>
                    <div>
                        <p className="text-sm text-blue-600">Ingresos totales</p>
                        <p className="text-2xl font-bold">$12,450</p>
                    </div>
                </div>
            </GlassCard>

            <GlassCard>
                <h3 className="text-xl font-semibold mb-4">Mis carros publicados</h3>
                <div className="space-y-4">
                    {[1, 2, 3].map((car) => (
                        <div key={car} className="flex items-center space-x-4">
                            <img src={`/placeholder.svg?height=60&width=100`} alt="Car" className="w-20 h-12 object-cover rounded-lg" />
                            <div className="flex-grow">
                                <h4 className="font-semibold">Carro Exótico {car}</h4>
                                <p className="text-sm text-blue-600">$XXX/día</p>
                            </div>
                            <ExoticButton onClick={() => setScreen('CarDetails')} className="text-sm py-1 px-3" variant="glass">
                                Editar
                            </ExoticButton>
                        </div>
                    ))}
                </div>
            </GlassCard>

            <ExoticButton className="w-full" variant="outline">Cerrar sesión</ExoticButton>
        </div>
    )
}