package org.example.Dto

import kotlinx.serialization.Serializable
import org.example.models.Jugador

@Serializable
class JugadorDto(
    val id: Long,
    val nombre: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String,
    val rol: String,
    val posicion: Jugador.Posicion,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidosJugados: Int

) : java.io.Serializable

