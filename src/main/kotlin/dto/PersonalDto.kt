package org.example

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PersonalDto (
    @SerialName("id")
    var id: Long,
    @SerialName("nombre")
    var nombre: String,
    @SerialName("apellidos")
    var apellidos: String,
    @SerialName("fecha_nacimiento")
    var fecha_nacimiento: String,
    @SerialName("fecha_incorporacion")
    var fecha_incorporacion: String,
    @SerialName("salario")
    var salario: Double,
    @SerialName("pais")
    var pais: String,
    @SerialName("rol")
    val rol: String,
    @SerialName("especialidad")
    val especialidad: String?,
    @SerialName("posicion")
    var posicion: String?,
    @SerialName("dorsal")
    var dorsal: Int?,
    @SerialName("altura")
    var altura: Double?,
    @SerialName("peso")
    var peso: Double?,
    @SerialName("goles")
    var goles: Int?,
    @SerialName("partidos_jugados")
    var partidos_jugados: Int?

) : java.io.Serializable