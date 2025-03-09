package validator

import org.example.exceptions.exceptions
import org.example.models.Jugador
import org.example.validator.JugadorValidator
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class JugadorValidatorTest {

    @Test
    fun JugadorValidateNombre() {
        val nombre = Jugador(
            id = 0L,
            nombre = "",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 1000.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(nombre)
        }
        assertEquals("El nombre no puede estar en blanco", exception.message)
    }

    @Test
    fun JugadorValidateNombreLargo() {
        val nombreLargo = Jugador(
            id = 0L,
            nombre = "NombreMuyLargoQueExcede15Caracteres",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 1000.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(nombreLargo)
        }
        assertEquals("El nombre no puede exceder los 15 caracteres", exception.message)
    }

    @Test
    fun JugadorValidateApellido() {
        val apellido = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 1000.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(apellido)
        }
        assertEquals("El apellido no puede estar en blanco", exception.message)
    }

    @Test
    fun JugadorValidateFechaNacimientoInvalida() {
        val fecha_n = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1920-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 1000.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(fecha_n)
        }
        assertEquals("La fecha de nacimiento no puede ser anterior a 1925", exception.message)
    }

    @Test
    fun JugadorValidateFechaIncorporacionInvalida() {
        val fecha = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "1950-01-01",
            salario = 1000.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(fecha)
        }
        assertEquals("La fecha de incorporación no puede ser anterior a 1960", exception.message)
    }

    @Test
    fun JugadorValidateSalarioNulo() {
        val salario = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 0.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(salario)
        }
        assertEquals("El salario no puede ser nulo", exception.message)
    }

    @Test
    fun JugadorValidateSalarioNegativo() {
        val jugador = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = -1.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(jugador)
        }
        assertEquals("El salario no puede ser negativo", exception.message)
    }

    @Test
    fun JugadorValidatePais() {
        val jugador = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 1000.0,
            pais = "",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(jugador)
        }
        assertEquals("El país no puede estar en blanco", exception.message)
    }

    @Test
    fun JugadorValidatePosicionInvalida() {
        val jugador = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 1000.0,
            pais = "España",
            rol = "jugador",
            posicion = null,
            dorsal = 10,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(jugador)
        }
        assertEquals("Posición no puede ser nula", exception.message)
    }

    @Test
    fun JugadorValidateDorsalNulo() {
        val jugador = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 1000.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = null,
            altura = 1.75,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(jugador)
        }
        assertEquals("El dorsal no puede ser nulo", exception.message)
    }

    @Test
    fun JugadorValidateAlturaInvalida() {
        val jugador = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 1000.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 3.0,
            peso = 75.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(jugador)
        }
        assertEquals("La altura debe estar entre 0.0 y 2.5 metros", exception.message)
    }

    @Test
    fun JugadorValidatePesoInvalido() {
        val jugador = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1990-01-01",
            fechaIncorporacion = "2010-01-01",
            salario = 1000.0,
            pais = "España",
            rol = "jugador",
            posicion = Jugador.Posicion.CENTROCAMPISTA,
            dorsal = 10,
            altura = 1.75,
            peso = 100.0,
            goles = 5,
            partidosJugados = 20
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> {
            JugadorValidator().validateJugador(jugador)
        }
        assertEquals("El peso debe estar entre 1.00 y 90.00 kg", exception.message)
    }
}
