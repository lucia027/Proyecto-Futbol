package org.example.models

import java.time.LocalDateTime

open class Empleado (
    open val id: Int,
    open val nombre: String,
    open val apellidos: String,
    open val fechaNacimiento: LocalDateTime,
    open val fechaIncorporacion: LocalDateTime,
    open val salario: Double,
    open val pais: String,
    open val rol: String//Rol
)