package org.example.models

import java.time.LocalDate

class Jugador (
    override val id: Int = NEW_ID,
    override var nombre: String,
    override var apellidos: String,
    override var fechaNacimiento: String,
    override var fechaIncorporacion: String,
    override var salario: Double,
    override var pais: String,
    var posicion: Posicion,
    var dorsal: Int,
    var altura: Double,
    var peso: Double,
    var goles: Int,
    var partidosJugados: Int

): Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais){

    // Tipos para el jugador
    enum class Posicion {
        DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO
    }

    fun copyJugador(id: Int): Jugador{
        return Jugador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, posicion, dorsal, altura, peso, goles, partidosJugados)
    }
}