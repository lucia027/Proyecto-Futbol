package org.example.models

import java.time.LocalDate

// Clase personal con sus parámetros
open class Personal(
    open val id: Int = NEW_ID,
    open var nombre: String,
    open var apellidos: String,
    open var fechaNacimiento: String,
    open var fechaIncorporacion: String,
    open var salario: Double,
    open var pais: String

    ) {
    companion object{
        val NEW_ID = 1
    }

    fun copyPersonal(id: Int): Personal{
        return Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais)
    }
}