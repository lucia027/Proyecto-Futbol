package org.example.validator
import org.example.exceptions.exceptions
import org.example.models.Entrenador
import org.example.models.Personal
import org.lighthousegames.logging.logging

class PersonalValidator {

    private val logger = logging()
    fun validatePersonal(personal: Personal) {

        logger.debug { "Validando personal" }

        if (personal.nombre.isBlank()) {
            throw exceptions.PersonalValidatorException("Nombre cannot be blank")
        }
        if (personal.nombre.length >= 15) {
            throw exceptions.PersonalValidatorException("caca")
        }
        if (personal.apellidos.isBlank()) {
            throw exceptions.PersonalValidatorException("Nombre cannot be blank")
        }
        if (personal.apellidos.length >= 30) {
            throw exceptions.PersonalValidatorException("caca")
        }
        if (personal.fechaNacimiento.isBlank()) {
            throw exceptions.PersonalValidatorException("fecha")
        }
        if (personal.fechaNacimiento <= "1925-01-01") {
            throw exceptions.PersonalValidatorException("fecha")
        }
        if (personal.fechaIncorporacion.isBlank()) {
            throw exceptions.PersonalValidatorException("fecha")
        }
        if (personal.fechaIncorporacion <= "1960-01-01") {
            throw exceptions.PersonalValidatorException("fecha")
        }
        if (personal.salario.isNaN()) {
            throw exceptions.PersonalValidatorException("caca")
        }
        if (personal.pais.isBlank()) {
            throw exceptions.PersonalValidatorException("pais cannot be blank")
        }
        if (personal.rol.isBlank()) {
            throw exceptions.PersonalValidatorException("rol cannot be blank")
        }
        /*if (personal.rol != "Jugador" || personal.rol != "Entrenador") {
            throw exceptions.PersonalValidatorException()
        }
         */
    }
}