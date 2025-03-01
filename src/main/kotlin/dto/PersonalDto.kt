package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class PersonalDto(
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
    open val pais: String
) : java.io.Serializable {

    override fun toString(): String {
        return "PersonalDto(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, salario=$salario, pais=$pais)"
    }
}


