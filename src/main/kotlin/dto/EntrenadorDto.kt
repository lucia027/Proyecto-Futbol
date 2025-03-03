
package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.dto.PersonalDto
import org.example.models.Entrenador.Especializacion
import org.example.models.Personal
import org.example.models.Personal.Companion.NEW_ID

@Serializable
class EntrenadorDto (
    override val id: Int,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: String,
    override val fechaIncorporacion: String,
    override val salario: Double,
    override val pais: String,
    override val rol: String,
    @SerialName("especialidad")
    val especialidad: String,
): PersonalDto(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol)


