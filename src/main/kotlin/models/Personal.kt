package org.example.models

import java.time.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Clase personal con sus parámetros

abstract class Personal(
        val id: Int = NEW_ID,
        val nombre: String,
        val apellidos: String,
        val fechaNacimiento: String,
        val fechaIncorporacion: String,
        val salario: Double,
        val pais: String,
        val rol: String
    ) {

    companion object{
        val NEW_ID = 1
    }

    override fun toString(): String{
        return("Personal(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais)")
    }

    @Serializable
    enum class Tipo {
        @SerialName("tipo")
        Jugador, Entrenador,
        @SerialName("")
        NINGUNO
    }
}