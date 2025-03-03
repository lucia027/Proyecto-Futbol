
package org.example.Dto

import org.example.models.Jugador.Posicion
import org.example.models.Personal.Companion.NEW_ID

class JugadorDto (
    val id: Int,
    val nombre: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String,
    val posicion: String,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidosJugados: Int
){

}
