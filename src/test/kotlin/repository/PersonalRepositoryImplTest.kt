package repository

import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.repositories.PersonalRepositoryImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

//Clase que implementa lso test del PersoanlRepositoryImpl
class PersonalRepositoryImplTest {

    //Inicia la variable que crea la instancia del PersonalRepositoryImpl antes de ser usada
    private lateinit var personalRepository: PersonalRepositoryImpl

    //Ejecuta antes de cada prueba la funcion setup donde se asigna la instancia de PersonalREpositoryImpl
    @BeforeEach
    fun setUp() {
        personalRepository = PersonalRepositoryImpl()
    }

    //Test encargado de que cuando no exista personal devolver una lista vacia
    @Test
    @DisplayName("Devuelve una lista vacia cuando no exista personal")
    fun returnsEmpty() {
        val personal = personalRepository.getAll()
        assertTrue(personal.isEmpty(), "Tendria que devolver la lista vacia")
    }

    //Test que guarda objetos de personal para luego bsucarlos por id y comrprobar si es correcto el guardado y la busqueda
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

    //Test que comprueba si al guardar objetos con un id existente lo cambia asegurandose de que sea unico
    @Test
    @DisplayName("Guardado id unico")
    fun uniqueId(){
        val jugadorTest = Jugador( 1, "Maria", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Jugador", Jugador.Posicion.DELANTERO, 21, 1.69, 65.0, 40, 20)
        val entrenadorTest = Entrenador(2, "Carlos", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE)

        val saveJugador = personalRepository.save(jugadorTest)
        val saveEntrenador = personalRepository.save(entrenadorTest)

        assertNotEquals(saveJugador.id, saveEntrenador.id)
    }

    //Test que comprueba si al modificar un objeto y actualizarlo se ha hecho correctamente
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

    //Test que comprueba que no se puede modificar un objeto que no se ha guardado, que por lo tanto es inexistente
    @Test
    @DisplayName("Actualizacion del personal inexistente = null")
    fun updatePersonalNull(){
        val jugador = Jugador( 1, "Maria", "Sanchez", "1982-04-04", "1990-04-04", 10.0, "España", "Jugador", Jugador.Posicion.DELANTERO, 21, 1.69, 65.0, 40, 20)
        val result = personalRepository.update(200, jugador)

        assertNull(result)
    }

    //Test que comprueba que se ha eliminado correctamente un objeto
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

    //Test que devuelve un null cuando se inetnat borrar un objeto que no existe
    @Test
    @DisplayName("Devuelve null cuando no existe el personal")
    fun nullPersonal(){
        val result = personalRepository.delete(200)
        assertNull(result)
    }
}