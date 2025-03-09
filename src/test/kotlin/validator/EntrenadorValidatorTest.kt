package validator

import org.example.exceptions.exceptions
import org.example.models.Entrenador
import org.example.validator.EntrenadorValidator
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class EntrenadorValidatorTest {

    fun EntrenadorValidateNombre () {
        val nombre = Entrenador(
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
        val exception = assertThrows<exceptions.PersonalValidatorException> { EntrenadorValidator().validateEntrenador(nombre) }
        assertEquals("El nombre no puede estar en blanco", exception.message)
    }
    fun EntrenadorValidateApellido () {
        val apellido = Entrenador(
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
        val exception = assertThrows<exceptions.PersonalValidatorException> { EntrenadorValidator().validateEntrenador(apellido) }
        assertEquals("Los apellidos no puede estar en blanco", exception.message)
    }
    fun EntrenadorValidateSalario() {
        val salario = Entrenador(
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
        val exception = assertThrows<exceptions.PersonalValidatorException> { EntrenadorValidator().validateEntrenador(salario) }
        assertEquals("El salario no puede ser nulo", exception.message)
    }

    fun EntrenadorValidateSalarioNegativo() {
        val salario = Entrenador(
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
        val exception = assertThrows<exceptions.PersonalValidatorException> { EntrenadorValidator().validateEntrenador(salario) }
        assertEquals("El salario no puede ser nulo", exception.message)
    }

    fun EntrenadorValidatePais () {
        val pais = Entrenador(
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
        val exception = assertThrows<exceptions.JugadorValidatorException> { EntrenadorValidator().validateEntrenador(pais) }
        assertEquals("El pais no puede estar en blanco", exception.message)
    }

    fun EntrenadorValidateEspecialidad () {
        val especialidad = Entrenador(
            id = 0L,
            nombre = "",
            apellidos = "Pérez",
            fechaNacimiento = "1970-01-01",
            fechaIncorporacion = "1970-01-01",
            salario = 0.0,
            pais = "España",
            especialidad = null,
            rol = "entrenador"
        )
    }

}