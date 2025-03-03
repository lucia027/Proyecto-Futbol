
package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.models.Entrenador

@Serializable
class EntrenadorDto(
    val id: Long,
    val nombre: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String,
    val rol: String,
    @SerialName("especialidad")
    val especialidad: Entrenador.Especializacion,
)




