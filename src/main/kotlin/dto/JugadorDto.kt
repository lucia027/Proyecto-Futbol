
package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.dto.PersonalDto
import org.example.models.Jugador.Posicion
import org.example.models.Personal
import org.example.models.Personal.Companion.NEW_ID

@Serializable
class JugadorDto (
    override val id: Int,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: String,
    override val fechaIncorporacion: String,
    override val salario: Double,
    override val pais: String,
    override val rol: String,
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
): PersonalDto(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol)
