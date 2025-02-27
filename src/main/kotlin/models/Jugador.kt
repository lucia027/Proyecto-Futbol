package org.example.models

import java.time.LocalDateTime

class Jugador (
    override val id: Int,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: LocalDateTime,
    override val fechaIncorporacion: LocalDateTime,
    override val salario: Double,
    override val pais: String,
    override val rol: String, // Rol
    val posicion: String,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidosJugados: Int,
): Empleado(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol)