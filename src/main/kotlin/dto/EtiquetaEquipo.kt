package org.example.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.PersonalDto
import org.example.models.Personal

@Serializable
@SerialName("equipo")
data class EtiquetaEquipo (
    val equipo : List<PersonalXmlDto>,
) : java.io.Serializable