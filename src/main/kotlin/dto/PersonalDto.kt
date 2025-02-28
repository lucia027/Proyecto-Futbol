package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class PersonalDto(

    @SerialName("idPersonal")
    open val id: Int,
    @SerialName("nombrePersonal")
    open val nombre: String,
    @SerialName("apellidosPersonal")
    open val apellidos: String,
    @SerialName("fechaNacimientoPersonal")
    open val fechaNacimiento: String,
    @SerialName("fechaIncorporacionPersonal")
    open val fechaIncorporacion: String,
    @SerialName("salarioPersonal")
    open val salario: Double,
    @SerialName("paisPersonal")
    open val pais: String

): java.io.Serializable
