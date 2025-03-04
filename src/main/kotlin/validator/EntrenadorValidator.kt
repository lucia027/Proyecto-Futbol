package org.example.validator

import org.example.exceptions.exceptions
import org.example.models.Entrenador
import org.lighthousegames.logging.logging

class EntrenadorValidator {

    private val logger = logging()

    fun validateEntrenador(entrenador : Entrenador) {

        logger.debug { "Validando entrenadores" }

        if (entrenador.nombre.isBlank()) {
            throw exceptions.EntrenadorValidatorException("Nombre cannot be blank")
        }
        if (entrenador.nombre.length >= 15) {
            throw exceptions.EntrenadorValidatorException("caca")
        }
        if (entrenador.apellidos.isBlank()) {
            throw exceptions.EntrenadorValidatorException("Nombre cannot be blank")
        }
        if (entrenador.apellidos.length >= 30) {
            throw exceptions.EntrenadorValidatorException("caca")
        }
        if (entrenador.fechaNacimiento.isBlank()) {
            throw exceptions.EntrenadorValidatorException("fecha")
        }
        if (entrenador.fechaNacimiento <= "1925-01-01") {
            throw exceptions.EntrenadorValidatorException("fecha")
        }
        if (entrenador.fechaIncorporacion.isBlank()) {
            throw exceptions.EntrenadorValidatorException("fecha")
        }
        if (entrenador.fechaIncorporacion <= "1960-01-01") {
            throw exceptions.EntrenadorValidatorException("fecha")
        }
        if (entrenador.salario.isNaN()) {
            throw exceptions.EntrenadorValidatorException("caca")
        }
        if (entrenador.pais.isBlank()) {
            throw exceptions.EntrenadorValidatorException("pais cannot be blank")
        }
        if (entrenador.rol.isBlank()) {
            throw exceptions.EntrenadorValidatorException("rol cannot be blank")
        }
        /*if (personal.rol != "Jugador" || personal.rol != "Entrenador") {
            throw exceptions.EntrenadorValidatorException()
        }
         */
        if (entrenador.especialidad != Entrenador.Especializacion.ENTRENADOR_PORTEROS || entrenador.especialidad != Entrenador.Especializacion.ENTRENADOR_ASISTENTE || entrenador.especialidad != Entrenador.Especializacion.ENTRENADOR_PRINCIPAL) {
            throw exceptions.EntrenadorValidatorException("especialidad cannot be blank")
        }
    }

}