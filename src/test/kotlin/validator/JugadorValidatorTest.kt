package validator

import org.example.exceptions.exceptions
import org.example.models.Jugador
import org.example.validator.JugadorValidator
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class JugadorValidatorTest {

    fun JugadorValidateNombre () {
        val personal = Jugador(
            id = 0L,
            nombre = "",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 0,
            altura = 0.0,
            peso = 0.0,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.PersonalValidatorException> { JugadorValidator().validateJugador(personal) }
        assertEquals("El nombre no puede estar en blanco", exception.message)
    }
    fun JugadorValidateApellido () {
        val apellido = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 0,
            altura = 0.0,
            peso = 0.0,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.PersonalValidatorException> { JugadorValidator().validateJugador(apellido) }
        assertEquals("Los apellidos no puede estar en blanco", exception.message)
    }
    fun JugadorValidateSalario() {
        val salario = Jugador(
            id = 0L,
            nombre = "",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = null,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 0,
            altura = 0.0,
            peso = 0.0,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.PersonalValidatorException> { JugadorValidator().validateJugador(salario) }
        assertEquals("El salario no puede ser nulo", exception.message)
    }

    fun JugadorValidateSalarioNegativo() {
        val salario = Jugador(
            id = 0L,
            nombre = "",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = -1.00,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 0,
            altura = 0.0,
            peso = 0.0,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.PersonalValidatorException> { JugadorValidator().validateJugador(salario) }
        assertEquals("El salario no puede ser negativo", exception.message)
    }

    fun JugadorValidatePais () {
        val pais = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 0,
            altura = 0.0,
            peso = 0.0,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> { JugadorValidator().validateJugador(pais) }
        assertEquals("El pais no puede estar en blanco", exception.message)
    }

    fun JugadorValidateDorsal () {
        val dorsal = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = null,
            altura = 0.0,
            peso = 0.0,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> { JugadorValidator().validateJugador(dorsal) }
        assertEquals("El dorsal no puede ser nulo", exception.message)
    }

    fun JugadorValidateDorsalNegativo () {
        val dorsal = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = -1,
            altura = 0.0,
            peso = 0.0,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> { JugadorValidator().validateJugador(dorsal) }
        assertEquals("El dorsal no puede ser negativo", exception.message)
    }

    fun JugadorValidateAltura () {
        val altura = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 0,
            altura = null,
            peso = 0.0,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> { JugadorValidator().validateJugador(altura) }
        assertEquals("la altura no puede ser nulo", exception.message)
    }

    fun JugadorValidateAlturaNegativa () {
        val altura = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 0,
            altura = -1.00,
            peso = 0.0,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> { JugadorValidator().validateJugador(altura) }
        assertEquals("la altura no puede ser negativo", exception.message)
    }

    fun JugadorValidatePeso () {
        val altura = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 0,
            altura = 0.0,
            peso = null,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> { JugadorValidator().validateJugador(altura) }
        assertEquals("el peso no puede ser nulo", exception.message)
    }

    fun JugadorValidatePesoNegativo () {
        val altura = Jugador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            rol = "Jugador",
            posicion = Jugador.Posicion.values().random(),
            dorsal = 0,
            altura = 0.0,
            peso = -1.00,
            goles = 0,
            partidosJugados = 0,
        )
        val exception = assertThrows<exceptions.JugadorValidatorException> { JugadorValidator().validateJugador(altura) }
        assertEquals("el peso no puede ser negativo", exception.message)
    }



}
