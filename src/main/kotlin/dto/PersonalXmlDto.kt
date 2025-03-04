package org.example.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
data class PersonalXmlDto(
    @SerialName("id")
    var id: Long,
    @SerialName("tipo")
    val tipo: String,
    @XmlElement
    @SerialName("nombre")
    var nombre: String,
    @XmlElement
    @SerialName("apellidos")
    var apellidos: String,
    @XmlElement
    @SerialName("fechaNacimiento")
    var fecha_nacimiento: String,
    @XmlElement
    @SerialName("fechaIncorporacion")
    var fecha_incorporacion: String,
    @XmlElement
    @SerialName("salario")
    var salario: Double,
    @XmlElement
    @SerialName("pais")
    var pais: String,
    @XmlElement
    @SerialName("rol")
    val rol: String,
    @XmlElement
    @SerialName("especialidad")
    val especialidad: String?,
    @XmlElement
    @SerialName("posicion")
    var posicion: String?,
    @XmlElement
    @SerialName("dorsal")
    var dorsal: Int?,
    @XmlElement
    @SerialName("altura")
    var altura: Double?,
    @XmlElement
    @SerialName("peso")
    var peso: Double?,
    @XmlElement
    @SerialName("goles")
    var goles: Int?,
    @XmlElement
    @SerialName("partidosJugados")
    var partidos_jugados: Int?
) : java.io.Serializable