package validator

import org.example.exceptions.exceptions
import org.example.models.Entrenador
import org.example.validator.EntrenadorValidator
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class EntrenadorValidatorTest {

    @Test
    fun EntrenadorValidateNombre() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("La casilla del nombre no puede estar en blanco", exception.message)
    }

    @Test
    fun EntrenadorValidateNombreLargo() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "NombreMuyLargoQueExcede15Caracteres",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 1000.0,
            pais = "España",
            especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("El nombre no puede exceder los 15 caracteres", exception.message)
    }

    @Test
    fun EntrenadorValidateApellido() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("La casilla apellidos no puede estar en blanco", exception.message)
    }

    @Test
    fun EntrenadorValidateApellidoLargo() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "ApellidoExcesivamenteLargoQueSupera30Caracteres",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 1000.0,
            pais = "España",
            especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("El apellido no puede exceder los 30 caracteres", exception.message)
    }

    @Test
    fun EntrenadorValidateFechaNacimientoInvalida() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1920-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 1000.0,
            pais = "España",
            especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("La fecha de nacimiento no puede ser anterior a 1925", exception.message)
    }

    @Test
    fun EntrenadorValidateFechaIncorporacionInvalida() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1950-01-01",
            salario = 1000.0,
            pais = "España",
            especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("La fecha de incorporación no puede ser anterior a 1960", exception.message)
    }

    @Test
    fun EntrenadorValidateSalarioNulo() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = null,
            pais = "España",
            especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("El salario no puede ser nulo", exception.message)
    }

    @Test
    fun EntrenadorValidateSalarioNegativo() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = -1.0,
            pais = "España",
            especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("El salario no puede ser negativo", exception.message)
    }

    @Test
    fun EntrenadorValidatePais() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "",
            especialidad = Entrenador.Especializacion.ENTRENADOR_ASISTENTE,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("La casilla país no puede estar en blanco", exception.message)
    }

    @Test
    fun EntrenadorValidateEspecialidadInvalida() {
        val entrenador = Entrenador(
            id = 0L,
            nombre = "Pepe",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 1000.0,
            pais = "España",
            especialidad = null,
            rol = "entrenador"
        )
        val exception = assertThrows<exceptions.EntrenadorValidatorException> {
            EntrenadorValidator().validateEntrenador(entrenador)
        }
        assertEquals("La especialidad no puede ser nula", exception.message)
    }
}
