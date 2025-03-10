package service

import PersonalServiceImpl
import org.example.cache.Cache
import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal
import org.example.repositories.PersonalRepository
import org.example.service.PersonalService
import org.example.storage.PersonalStorage
import org.junit.jupiter.api.extension.ExtendWith
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class PersonalServiceImplTest {

    

    @Test
    fun saveTest() {
        val jugador = Jugador(
            id = 1,
            nombre = "Pepe",
            apellidos = "Perez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 50000.0,
            pais = "España" ,
            rol = "Jugador" ,
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 22,
            altura = 1.80,
            peso = 80.00,
            goles = 13,
            partidosJugados = 69
        )
        val service = PersonalServiceImpl()
        val jugadorCreado = service.save(jugador) as Jugador

        assertEquals(jugador.id, jugadorCreado.id )
        assertEquals(jugador.nombre, jugadorCreado.nombre)
        assertEquals(jugador.apellidos, jugadorCreado.apellidos)
        assertEquals(jugador.fechaNacimiento, jugadorCreado.fechaNacimiento)
        assertEquals(jugador.fechaIncorporacion, jugadorCreado.fechaIncorporacion)
        assertEquals(jugador.salario, jugadorCreado.salario)
        assertEquals(jugador.pais, jugadorCreado.pais)
        assertEquals(jugador.rol, jugadorCreado.rol)
        assertEquals(jugador.posicion, jugadorCreado.posicion)
        assertEquals(jugador.dorsal, jugadorCreado.dorsal)
        assertEquals(jugador.altura, jugadorCreado.altura)
        assertEquals(jugador.peso, jugadorCreado.peso)
        assertEquals(jugador.goles, jugadorCreado.goles)
        assertEquals(jugador.partidosJugados, jugadorCreado.partidosJugados)
    }

    @Test
    fun updateTest () {
        val jugador = Jugador(
            id = 1,
            nombre = "Pepe",
            apellidos = "Perez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 50000.0,
            pais = "España" ,
            rol = "Jugador" ,
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 22,
            altura = 1.80,
            peso = 80.00,
            goles = 13,
            partidosJugados = 69
        )
        val service = PersonalServiceImpl()
        val jugadorActualizado = service.update(1L, jugador) as Jugador

        assertEquals(jugador.id, jugadorActualizado.id)
        assertEquals(jugador.nombre, jugadorActualizado.nombre)
        assertEquals(jugador.apellidos, jugadorActualizado.apellidos)
        assertEquals(jugador.fechaNacimiento, jugadorActualizado.fechaNacimiento)
        assertEquals(jugador.fechaIncorporacion, jugadorActualizado.fechaIncorporacion)
        assertEquals(jugador.salario, jugadorActualizado.salario)
        assertEquals(jugador.pais, jugadorActualizado.pais)
        assertEquals(jugador.rol, jugadorActualizado.rol)
        assertEquals(jugador.posicion, jugadorActualizado.posicion)
        assertEquals(jugador.dorsal, jugadorActualizado.dorsal)
        assertEquals(jugador.altura, jugadorActualizado.altura)
        assertEquals(jugador.peso, jugadorActualizado.peso)
        assertEquals(jugador.goles, jugadorActualizado.goles)
        assertEquals(jugador.partidosJugados, jugadorActualizado.partidosJugados)
    }

    @Test
    fun deleteTest () {
        val jugador = Jugador(
            id = 1,
            nombre = "Pepe",
            apellidos = "Perez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 50000.0,
            pais = "España" ,
            rol = "Jugador" ,
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 22,
            altura = 1.80,
            peso = 80.00,
            goles = 13,
            partidosJugados = 69
        )
        val service = PersonalServiceImpl()
        val jugadorBorrado = service.delete(1L) as Jugador
    }
    @Test
    fun getAllTest () {
        val service = PersonalServiceImpl()
        val todosLosJugadores = service.getAll()
    }

    @Test
    fun getById () {
        val service = PersonalServiceImpl()
        val obtenerPorId = service.getById(1L)
    }

   /* @Test
    fun importFileCsv () {
        val service = PersonalServiceImpl()
        val file = File("data", "personal-backup.csv")
        val fileHacia = File("data", "personal.csv")
        service.importFile(file.format)
        service.exportFile(fileHacia.path)
    }
    */
}

