package org.example

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
sealed interface PersonalDto {
    var id: Long

    @SerialName("nombre")
    var nombre: String

    @SerialName("apellidos")
    val apellidos: String

    @SerialName("fecha_nacimiento")
    val fecha_nacimiento: String

    @SerialName("fecha_incorporacion")
    val fecha_incorporacion: String

    @SerialName("salario")
    val salario: Double

    @SerialName("pais")
    val pais: String

    @SerialName("rol")
    val rol: String

    @SerialName("especialidad")
    val especialidad: String?

    @SerialName("posicion")
    val posicion: String?

    @SerialName("dorsal")
    val dorsal: Int?

    @SerialName("altura")
    val altura: Double?

    @SerialName("peso")
    val peso: Double?

    @SerialName("goles")
    val goles: Int?

    @SerialName("partidos_jugados")
    val partidos_jugados: Int?

}