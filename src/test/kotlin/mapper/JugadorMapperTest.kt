package mapper

import org.example.Dto.JugadorDto
import org.example.mapper.toDto
import org.example.mapper.toModel
import org.example.models.Jugador
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

class JugadorMapperTest {

    @Test
    @DisplayName("Test Dto to Model")
    fun JugadorDtoToModel() {
        // Arrange: Creamos un objeto JugadorDto con datos específicos.
        val jugadorDto = JugadorDto(
            id = 1L,
            nombre = "Cristiano",
            apellidos = "Ronaldo",
            fechaNacimiento = "1985-02-05",
            fechaIncorporacion = "2003-08-01",
            salario = 4500000.0,
            pais = "Portugal",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 7,
            altura = 1.87,
            peso = 85.0,
            goles = 800,
            partidosJugados = 900,
            rol = "Jugador"
        )

        // Act: Convertimos el JugadorDto a un Jugador usando el método toModel.
        val jugador = jugadorDto.toModel() as Jugador

        // Assert: Verificamos que los valores del JugadorDto se hayan mapeado correctamente en el Jugador.
        assertEquals(jugadorDto.id, jugador.id)
        assertEquals(jugadorDto.nombre, jugador.nombre)
        assertEquals(jugadorDto.apellidos, jugador.apellidos)
        assertEquals(jugadorDto.fechaNacimiento, jugador.fechaNacimiento)
        assertEquals(jugadorDto.fechaIncorporacion, jugador.fechaIncorporacion)
        assertEquals(jugadorDto.salario, jugador.salario)
        assertEquals(jugadorDto.pais, jugador.pais)
        assertEquals(jugadorDto.posicion, jugador.posicion)
        assertEquals(jugadorDto.dorsal, jugador.dorsal)
        assertEquals(jugadorDto.altura, jugador.altura)
        assertEquals(jugadorDto.peso, jugador.peso)
        assertEquals(jugadorDto.goles, jugador.goles)
        assertEquals(jugadorDto.partidosJugados, jugador.partidosJugados)
        assertEquals(jugadorDto.rol, jugador.rol)
    }



    @Test
    @DisplayName("Test Model to Dto")
    fun testJugadorToDto() {
        // Arrange: Creamos un objeto Jugador con datos específicos.
        val jugador = Jugador(
            id = 1L,
            nombre = "Cristiano",
            apellidos = "Ronaldo",
            fechaNacimiento = "1985-02-05",
            fechaIncorporacion = "2003-08-01",
            salario = 4500000.0,
            pais = "Portugal",
            rol = "Jugador",
            posicion = Jugador.Posicion.DELANTERO,
            dorsal = 7,
            altura = 1.87,
            peso = 85.0,
            goles = 800,
            partidosJugados = 900
        )

        // Act: Convertimos el Jugador a un PersonalDto usando el método toDto.
        val personalDto = jugador.toDto()

        // Assert: Verificamos que los valores del Jugador se hayan mapeado correctamente en el PersonalDto.
        assertEquals(jugador.id, personalDto.id)
        assertEquals(jugador.nombre, personalDto.nombre)
        assertEquals(jugador.apellidos, personalDto.apellidos)
        assertEquals(jugador.fechaNacimiento, personalDto.fecha_nacimiento)
        assertEquals(jugador.fechaIncorporacion, personalDto.fecha_incorporacion)
        assertEquals(jugador.salario, personalDto.salario)
        assertEquals(jugador.pais, personalDto.pais)
        assertEquals(jugador.posicion.toString(), personalDto.posicion)
        assertEquals(jugador.dorsal, personalDto.dorsal)
        assertEquals(jugador.altura, personalDto.altura)
        assertEquals(jugador.peso, personalDto.peso)
        assertEquals(jugador.goles, personalDto.goles)
        assertEquals(jugador.partidosJugados, personalDto.partidos_jugados)
        assertEquals(jugador.rol, personalDto.rol)
        assertEquals("", personalDto.especialidad) // Asumimos que especialidad es un valor vacío.
    }
}
