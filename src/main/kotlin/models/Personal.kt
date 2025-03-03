package org.example.models

import java.time.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Clase personal con sus parámetros

open class Personal(
    open val id: Int = NEW_ID,
    open var nombre: String,
    open var apellidos: String,
    open var fechaNacimiento: String,
    open var fechaIncorporacion: String,
    open var salario: Double,
    open var pais: String

    open val nombre: String,
    open val apellidos: String,
    open val fechaNacimiento: String,
    open val fechaIncorporacion: String,
    open val salario: Double,
    open val pais: String,
    ) {

    companion object{
        val NEW_ID = 1
    }

    fun copyPersonal(id: Int): Personal{
        return Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais)
    override fun toString(): String{
        return("Personal(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais)")
    }

    fun copy(id: Int): Personal{
        return Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais) // tipo)
    }

    @Serializable
    enum class Tipo {
        @SerialName("tipo")
        Jugador, Entrenador,
        @SerialName("")
        NINGUNO
    }
}