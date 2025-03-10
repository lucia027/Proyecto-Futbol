package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

/**
 * Clase que representa la transferencia de datos (DTO) de una persona del equipo en formato XML.
 * Esta clase se utiliza para enviar y recibir datos de una persona, especialmente en formato XML.
 *
 * @param id Identificador único de la persona.
 * @param tipo Tipo de persona (jugador o entrenador).
 * @param nombre Nombre de la persona.
 * @param apellidos Apellidos de la persona.
 * @param fecha_nacimiento Fecha de nacimiento de la persona en formato YYYY-MM-DD.
 * @param fecha_incorporacion Fecha de incorporación de la persona al equipo en formato YYYY-MM-DD.
 * @param salario Salario de la persona.
 * @param pais País de origen de la persona.
 * @param rol Rol de la persona en el equipo (jugador o entrenador).
 * @param especialidad Especialidad del entrenador (si se da, puede ser null).
 * @param posicion Posición del jugador en el campo (si se da, puede ser null).
 * @param dorsal Número de camiseta del jugador (si se da, puede ser null).
 * @param altura Altura del jugador en metros (si se da, puede ser null).
 * @param peso Peso del jugador en kilogramos (si se da, puede ser null).
 * @param goles Número de goles anotados por el jugador (si se da, puede ser null).
 * @param partidos_jugados Número de partidos jugados por el jugador (si se da, puede ser null).
 */
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