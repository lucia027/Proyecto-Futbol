package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonalDto(
    @SerialName("id")
    val id: Int,
    @SerialName("nombre")
    val nombre: String,
    @SerialName("apellidos")
    val apellidos: String,
    @SerialName("fecha_nacimiento")
    val fechaNacimiento: String,
    @SerialName("fecha_incorporacion")
    val fechaIncorporacion: String,
    @SerialName("salario")
    val salario: Double,
    @SerialName("pais")
    val pais: String,
    @SerialName("rol")
    val rol: String,
    @SerialName("especialidad")
    val especialidad: String = "",
    @SerialName("posicion")
    val posicion: String = "",
    @SerialName("dorsal")
    val dorsal: Int?,
    @SerialName("altura")
    val altura: Double?,
    @SerialName("peso")
    val peso: Double?,
    @SerialName("goles")
    val goles: Int?,
    @SerialName("partidos_jugados")
    val partidosJugados: Int?,
) {
    override fun toString(): String {
        return "Personal(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, salario=$salario, pais=$pais)"
    }
}


