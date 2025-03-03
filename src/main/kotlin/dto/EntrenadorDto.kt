
package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.models.Entrenador.Especializacion
import org.example.models.Personal.Companion.NEW_ID

@Serializable
class EntrenadorDto (
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
    @SerialName("especialidad")
    val especialidad: String,
){

}


