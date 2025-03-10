package org.example.validator

import org.example.exceptions.exceptions
import org.example.models.Entrenador
import org.lighthousegames.logging.logging

class EntrenadorValidator {

    private val logger = logging()

    fun validateEntrenador(entrenador: Entrenador) {

        logger.debug { "Validando entrenadores" }

        // Validación del nombre
        if (entrenador.nombre.isBlank()) {
            throw exceptions.EntrenadorValidatorException("La casilla del nombre no puede estar en blanco")
        }
        if (entrenador.nombre.length >= 15) {
            throw exceptions.EntrenadorValidatorException("El nombre no puede exceder los 15 caracteres")
        }

        // Validación de apellidos
        if (entrenador.apellidos.isBlank()) {
            throw exceptions.EntrenadorValidatorException("La casilla apellidos no puede estar en blanco")
        }
        if (entrenador.apellidos.length >= 30) {
            throw exceptions.EntrenadorValidatorException("El apellido no puede exceder los 30 caracteres")
        }

        // Validación de fecha de nacimiento
        if (entrenador.fechaNacimiento <= "1925-01-01") {
            throw exceptions.EntrenadorValidatorException("La fecha de nacimiento no puede ser anterior a 1925")
        }

        // Validación de fecha de incorporación
        if (entrenador.fechaIncorporacion <= "1960-01-01") {
            throw exceptions.EntrenadorValidatorException("La fecha de incorporación no puede ser anterior a 1960")
        }

        // Validación del salario
        if (entrenador.salario == null) {
            throw exceptions.EntrenadorValidatorException("El salario no puede ser nulo")
        }
        if (entrenador.salario!! < 0.0) {
            throw exceptions.EntrenadorValidatorException("El salario no puede ser negativo")
        }

        // Validación del país
        if (entrenador.pais.isBlank()) {
            throw exceptions.EntrenadorValidatorException("La casilla país no puede estar en blanco")
        }

        // Validación de la especialidad
        if (entrenador.especialidad == null) {
            throw exceptions.EntrenadorValidatorException("La especialidad no puede ser nula")
        }
    }
}
