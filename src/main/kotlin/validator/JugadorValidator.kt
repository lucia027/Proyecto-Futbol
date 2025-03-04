package org.example.validator

import org.example.exceptions.exceptions
import org.example.models.Jugador
import org.example.models.Personal
import org.lighthousegames.logging.logging

class JugadorValidator {

    val logger = logging()

    fun validatePersonal(jugador: Jugador) {

        logger.debug { "Validando jugadores" }

        if (jugador.nombre.isBlank()) {
            throw exceptions.JugadorValidatorException("Nombre cannot be blank")
        }
        if (jugador.nombre.length !in 1..15) {
            throw exceptions.JugadorValidatorException("caca")
        }
        if (jugador.apellidos.isBlank()) {
            throw exceptions.JugadorValidatorException("Nombre cannot be blank")
        }
        if (jugador.apellidos.length !in 1..30) {
            throw exceptions.JugadorValidatorException("caca")
        }
        if (jugador.fechaNacimiento.isBlank()) {
            throw exceptions.JugadorValidatorException("fecha")
        }
        if (jugador.fechaNacimiento <= "1925-01-01") {
            throw exceptions.JugadorValidatorException("fecha")
        }
        if (jugador.fechaIncorporacion.isBlank()) {
            throw exceptions.JugadorValidatorException("fecha")
        }
        if (jugador.fechaIncorporacion <= "1960-01-01") {
            throw exceptions.JugadorValidatorException("fecha")
        }
        if (jugador.salario.isNaN()) {
            throw exceptions.JugadorValidatorException("caca")
        }
        if (jugador.pais.isBlank()) {
            throw exceptions.JugadorValidatorException("pais cannot be blank")
        }
        if (jugador.rol.isBlank()) {
            throw exceptions.JugadorValidatorException("rol cannot be blank")
        }
        if (jugador.posicion != Jugador.Posicion.PORTERO || jugador.posicion != Jugador.Posicion.DEFENSA || jugador.posicion != Jugador.Posicion.DELANTERO || jugador.posicion != Jugador.Posicion.CENTROCAMPISTA) {
            throw exceptions.JugadorValidatorException("d")
        }
        if (jugador.dorsal !in  1..25 ) {
            throw exceptions.JugadorValidatorException("d")
        }
        if (jugador.altura !in 0.0..2.5) {
            throw exceptions.JugadorValidatorException("altura")
        }
        if (jugador.altura.isNaN()) {
            throw exceptions.JugadorValidatorException("altura")
        }
        if (jugador.peso !in 1.00..90.00) {
            throw exceptions.JugadorValidatorException("peso")
        }
        if (jugador.peso.isNaN()) {
            throw exceptions.JugadorValidatorException("peso")
        }
        if (jugador.goles < 0 ) {
            throw exceptions.JugadorValidatorException("malisimo")
        }
        if (jugador.partidosJugados < 0 ) {
            throw exceptions.JugadorValidatorException("partidos")
        }

    }
}