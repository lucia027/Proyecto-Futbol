package org.example.validator

import org.example.exceptions.exceptions
import org.example.models.Jugador
import org.example.models.Personal
import org.lighthousegames.logging.logging

class JugadorValidator {

    val logger = logging()

    fun validateJugador(jugador: Jugador) {

        logger.debug { "Validando jugadores" }

        // Validación de nombre
        if (jugador.nombre.isBlank()) {
            throw exceptions.JugadorValidatorException("El nombre no puede estar en blanco")
        }
        if (jugador.nombre.length !in 1..15) {
            throw exceptions.JugadorValidatorException("El nombre no puede exceder los 15 caracteres")
        }

        // Validación de apellidos
        if (jugador.apellidos.isBlank()) {
            throw exceptions.JugadorValidatorException("El apellido no puede estar en blanco")
        }
        if (jugador.apellidos.length !in 1..30) {
            throw exceptions.JugadorValidatorException("El apellido no puede exceder los 30 caracteres")
        }

        // Validación de fecha de nacimiento
        if (jugador.fechaNacimiento.isBlank()) {
            throw exceptions.JugadorValidatorException("La fecha de nacimiento no puede estar en blanco")
        }
        if (jugador.fechaNacimiento <= "1925-01-01") {
            throw exceptions.JugadorValidatorException("La fecha de nacimiento no puede ser anterior a 1925")
        }

        // Validación de fecha de incorporación
        if (jugador.fechaIncorporacion.isBlank()) {
            throw exceptions.JugadorValidatorException("La fecha de incorporación no puede estar en blanco")
        }
        if (jugador.fechaIncorporacion <= "1960-01-01") {
            throw exceptions.JugadorValidatorException("La fecha de incorporación no puede ser anterior a 1960")
        }

        // Validación de salario
        if (jugador.salario!!.isNaN()) {
            throw exceptions.JugadorValidatorException("El salario no puede ser nulo")
        }
        if (jugador.salario!! < 0) {
            throw exceptions.JugadorValidatorException("El salario no puede ser negativo")
        }

        // Validación de país
        if (jugador.pais.isBlank()) {
            throw exceptions.JugadorValidatorException("El país no puede estar en blanco")
        }

        // Validación de rol
        if (jugador.rol.isBlank()) {
            throw exceptions.JugadorValidatorException("El rol no puede estar en blanco")
        }

        // Validación de posición
        if (jugador.posicion == null) {
            throw exceptions.JugadorValidatorException("Posición no puede ser nula")
        }

        // Validación de dorsal
        if (jugador.dorsal == null) {
            throw exceptions.JugadorValidatorException("El dorsal no puede ser nulo")
        }
        if (jugador.dorsal !in 1..25) {
            throw exceptions.JugadorValidatorException("El dorsal debe estar entre 1 y 25")
        }

        // Validación de altura
        if (jugador.altura!!.isNaN()) {
            throw exceptions.JugadorValidatorException("La altura no puede ser nula")
        }
        if (jugador.altura!! !in 0.0..2.5) {
            throw exceptions.JugadorValidatorException("La altura debe estar entre 0.0 y 2.5 metros")
        }

        // Validación de peso
        if (jugador.peso!!.isNaN()) {
            throw exceptions.JugadorValidatorException("El peso no puede ser nulo")
        }
        if (jugador.peso!! !in 1.00..90.00) {
            throw exceptions.JugadorValidatorException("El peso debe estar entre 1.00 y 90.00 kg")
        }

        // Validación de goles
        if (jugador.goles < 0) {
            throw exceptions.JugadorValidatorException("El número de goles no puede ser negativo")
        }

        // Validación de partidos jugados
        if (jugador.partidosJugados < 0) {
            throw exceptions.JugadorValidatorException("El número de partidos jugados no puede ser negativo")
        }
    }
}
