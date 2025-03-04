package org.example.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class Entrenador(
    id: Long,
    nombre: String,
    apellidos: String,
    fechaNacimiento: String,
    fechaIncorporacion: String,
    salario: Double,
    pais: String,
    rol: String,
    var especialidad: Especializacion

) : Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol){ //tipo){

    override fun toString(): String{
        return("Entrenador(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, especializacion=$especialidad)")
    }

    override fun copy(
        id: Long,
        nombre: String,
        apellidos: String,
        fechaNacimiento: String,
        fechaIncorporacion: String,
        salario: Double,
        pais: String,
        rol: String,
    ): Personal {
        especialidad = this.especialidad
        return Entrenador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol, especialidad)
    }

    // Tipos para el entrenador
    @Serializable
    enum class Especializacion {
        @SerialName("especialidad")
        ENTRENADOR_ASISTENTE, ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL
    }
}