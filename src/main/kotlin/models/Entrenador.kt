package org.example.models


class Entrenador(
    override val id: Int = NEW_ID,
    override var nombre: String,
    override var apellidos: String,
    override var fechaNacimiento: String,
    override var fechaIncorporacion: String,
    override var salario: Double,
    override var pais: String,
    var especializacion: Especializacion

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

    fun copyEntrenador(id: Int): Entrenador{
        return Entrenador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, especializacion)
    }
}