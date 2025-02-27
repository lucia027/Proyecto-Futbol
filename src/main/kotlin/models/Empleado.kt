package org.example.models
import org.example.models.Personal.Rol
import java.time.LocalDate

open class Empleado (
    open val id: Int,
    open val nombre: String,
    open val apellidos: String,
    open val fechaNacimiento: LocalDate,
    open val fechaIncorporacion: LocalDate,
    open val salario: Double,
    open val pais: String,
    open val rol: Rol
)