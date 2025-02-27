package org.example.models
import org.example.models.Personal.Rol
import java.time.LocalDate

class Entrenador (
    val especialidad: String,
    override val id: Int,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: LocalDate,
    override val fechaIncorporacion: LocalDate,
    override val salario: Double,
    override val pais: String,
    override val rol: Rol
) : Empleado(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol)