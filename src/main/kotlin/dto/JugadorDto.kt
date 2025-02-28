package org.example.Dto

import org.example.models.Jugador

class JugadorDto (

    val id: Int,
    val nombre: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String,
    val posicion: Jugador.Posicion,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidosJugados: Int
)