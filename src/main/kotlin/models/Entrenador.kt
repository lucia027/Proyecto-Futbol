package org.example.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class Entrenador(
    override val id: Int = NEW_ID,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: String,
    override val fechaIncorporacion: String,
    override val salario: Double,
    override val pais: String,
    val especialidad: Especializacion = Especializacion.NINGUNO

) : Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais){ //tipo){

    override fun toString(): String{
        return("Personal(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, especializacion=$especialidad)")
    }

    // Tipos para el entrenador
    @Serializable
    enum class Especializacion {
        @SerialName("ENTRENADOR_ASISTENTE")
        ENTRENADOR_ASISTENTE,
        @SerialName("")
        NINGUNO
    }
}