package org.example.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
abstract class PersonalDto (
    @SerialName("id")
    open val id: Int,
    @SerialName("nombre")
    open val nombre: String,
    @SerialName("apellidos")
    open val apellidos: String,
    @SerialName("fecha_nacimiento")
    open val fechaNacimiento: String,
    @SerialName("fecha_incorporacion")
    open val fechaIncorporacion: String,
    @SerialName("salario")
    open val salario: Double,
    @SerialName("pais")
    open val pais: String,
    @SerialName("rol")
    open val rol: String
)