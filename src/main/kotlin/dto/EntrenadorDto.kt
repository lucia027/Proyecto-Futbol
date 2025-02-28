package org.example.Dto

import kotlinx.serialization.SerialName
import org.example.models.Entrenador.Especializacion

class EntrenadorDto (
    @SerialName("idEntrenador")
    override val id: Int,
    @SerialName("nombreEntrenador")
    override val nombre: String,
    @SerialName("apellidosEntrenador")
    override val apellidos: String,
    @SerialName("fechaNacimientoEntrenador")
    override val fechaNacimiento: String,
    @SerialName("fechaIncorporación")
    override val fechaIncorporacion: String,
    @SerialName("salarioEntrenador")
    override val salario: Double,
    @SerialName("paisEntrenador")
    override val pais: String,
    @SerialName("especializacionEntrenador")
    val especializacion: Especializacion

) : PersonalDto (id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais), java.io.Serializable