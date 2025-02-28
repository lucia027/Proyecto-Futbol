package org.example.models

import java.time.LocalDate

// Clase personal con sus parámetros
open class Personal (
    open val id: Int = NEW_ID,
    open val nombre: String,
    open val apellidos: String,
    open val fechaNacimiento: LocalDate,
    open val fechaIncorporacion: LocalDate,
    open val salario: Double,
    open val pais: String

    ) {
    companion object{
        val NEW_ID = 1
    }

    fun copy(id: Int): Personal{
        return Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais)
    }
}