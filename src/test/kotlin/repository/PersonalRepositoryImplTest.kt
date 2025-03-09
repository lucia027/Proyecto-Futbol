package repository

import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.repositories.PersonalRepositoryImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PersonalRepositoryImplTest {
    private lateinit var personalRepository: PersonalRepositoryImpl

    @BeforeEach
    fun setUp() {
        personalRepository = PersonalRepositoryImpl()
    }

    @Test
    @DisplayName("Devuelve una lista vacia cuando no exista personal")
    fun returnsEmpty() {
        val personal = personalRepository.getAll()
        assertTrue(personal.isEmpty(), "Tendria que devolver la lista vacia")
    }

    @Test
    @DisplayName("Guardado de personal y getById")
    fun saveGetByID() {
        val jugadorTest = Jugador( 1, "Maria", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Jugador", Jugador.Posicion.DELANTERO, 21, 1.69, 65.0, 40, 20)
        val entrenadorTest = Entrenador(2, "Carlos", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE)

        val saveJugador = personalRepository.save(jugadorTest)
        val saveEntrenador = personalRepository.save(entrenadorTest)

        val retrievedJugador = personalRepository.getById(saveJugador.id)
        assertNotNull(retrievedJugador)
        assertEquals(saveJugador, retrievedJugador)

        val retrievedEntrenador = personalRepository.getById(saveEntrenador.id)
        assertNotNull(saveEntrenador)
        assertEquals(saveEntrenador, retrievedEntrenador)
    }

    @Test
    @DisplayName("Guardado id unico")
    fun uniqueId(){
        val jugadorTest = Jugador( 1, "Maria", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Jugador", Jugador.Posicion.DELANTERO, 21, 1.69, 65.0, 40, 20)
        val entrenadorTest = Entrenador(2, "Carlos", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE)

        val saveJugador = personalRepository.save(jugadorTest)
        val saveEntrenador = personalRepository.save(entrenadorTest)

        assertNotEquals(saveJugador.id, saveEntrenador.id)
    }

    @Test
    @DisplayName("Actualizacion del personal modificado")
    fun updatePersonal() {
        val jugadorTest = Jugador( 1, "Maria", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Jugador", Jugador.Posicion.DELANTERO, 21, 1.69, 65.0, 40, 20)
        val saveJugador = personalRepository.save(jugadorTest)

        val updatedJugador = jugadorTest.copy(nombre = "Update Jugador", salario = 2100.0)
        val result = personalRepository.update(saveJugador.id, updatedJugador)

        assertNotNull(result)
        assertEquals(updatedJugador.nombre, result?.nombre)
        assertEquals(updatedJugador.salario, result?.salario)
    }

    @Test
    @DisplayName("Actualizacion del personal inexistente = null")
    fun updatePersonalNull(){
        val jugador = Jugador( 1, "Maria", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Jugador", Jugador.Posicion.DELANTERO, 21, 1.69, 65.0, 40, 20)
        val result = personalRepository.update(200, jugador)

        assertNull(result)
    }

    @Test
    @DisplayName("Eliminado correcto de personal")
    fun correctDelete() {
        val jugador = Jugador( 1, "Maria", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Jugador", Jugador.Posicion.DELANTERO, 21, 1.69, 65.0, 40, 20)
        val saveJugador = personalRepository.save(jugador)

        val deletedJuagdor = personalRepository.delete(saveJugador.id)
        assertNotNull(deletedJuagdor)

        val retrievedJuagdor = personalRepository.getById(saveJugador.id)
        assertNull(retrievedJuagdor)
    }

    @Test
    @DisplayName("Devuelve null cuando no existe el personal")
    fun nullPersonal(){
        val result = personalRepository.delete(200)
        assertNull(result)
    }
}