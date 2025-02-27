package org.example.models
import org.example.models.Personal.Rol
import java.time.LocalDate

class Jugador (
    override val id: Int,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: LocalDate,
    override val fechaIncorporacion: LocalDate,
    override val salario: Double,
    override val pais: String,
    override val rol: Rol,
    val posicion: String,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidosJugados: Int,
): Empleado(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol)

