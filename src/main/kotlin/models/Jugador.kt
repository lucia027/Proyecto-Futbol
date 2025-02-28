package org.example.models
import java.time.LocalDate

class Jugador (
    override val id: Int = NEW_ID,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: LocalDate,
    override val fechaIncorporacion: LocalDate,
    override val salario: Double,
    override val pais: String,
    val posicion: Posicion,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidosJugados: Int

): Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais){

    // Tipos para el jugador
    enum class Posicion {
        DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO
    }
}