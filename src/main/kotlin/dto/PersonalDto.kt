package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlOtherAttributes
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
data class PersonalDto(
    @XmlElement
    val personal: String? = null,
    @XmlOtherAttributes
    @SerialName("id")
    val id: Int,
    @XmlElement
    @SerialName("nombre")
    val nombre: String,
    @XmlElement()
    @SerialName("apellidos")
    val apellidos: String,
    @XmlElement
    @XmlSerialName("fechaNacimiento")
    @SerialName("fecha_nacimiento")
    val fechaNacimiento: String,
    @XmlElement
    @XmlSerialName("fechaIncorporacion")
    @SerialName("fecha_incorporacion")
    val fechaIncorporacion: String,
    @XmlElement
    @SerialName("salario")
    val salario: Double,
    @XmlElement
    @SerialName("pais")
    val pais: String,
    @XmlElement
    @XmlSerialName("tipo")
    @SerialName("rol")
    val tipo: Tipo? = null,
    @XmlElement
    @SerialName("especialidad")
    val especialidad: String? = null,
    @XmlElement
    @SerialName("posicion")
    val posicion: String? = null,
    @XmlElement
    @SerialName("dorsal")
    val dorsal: Int? = null,
    @XmlElement
    @SerialName("altura")
    val altura: Double? = null,
    @XmlElement
    @SerialName("peso")
    val peso: Double? = null,
    @XmlElement
    @SerialName("goles")
    val goles: Int? = null,
    @XmlElement
    @XmlSerialName("partidosJugados")
    @SerialName("partidos_jugados")
    val partidosJugados: Int? = null,
) {

    override fun toString(): String {
        return "Personal(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fecha_Incorporación=$fechaIncorporacion, salario=$salario, pais=$pais)"
    }

    enum class Tipo {
        Jugador, Entrenador
    }
}


