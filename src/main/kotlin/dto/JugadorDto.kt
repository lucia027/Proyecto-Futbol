package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
class JugadorDto (
    val id: Int,
    val nombre: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String,
    val rol: String,
    @SerialName("posicion")
    val posicion: String,
    @SerialName("dorsal")
    val dorsal: Int,
    @SerialName("altura")
    val altura: Double,
    @SerialName("peso")
    val peso: Double,
    @SerialName("goles")
    val goles: Int,
    @SerialName("partidos_jugados")
    val partidosJugados: Int
)
