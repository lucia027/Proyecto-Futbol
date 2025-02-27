package org.example.models

import java.time.LocalDate

// Clase personal con sus parámetros
class Personal (
    val id: Int = NEW_ID,
    val nombre: String,
    val apellidos: String,
    val fechaNacimiento: LocalDate,
    val fechaIncorporacion: LocalDate,
    val salario: Double,
    val pais: String,
    val rol: Rol,
    val posicion: String,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidosJugados: Int,

    ){
    companion object{
        val NEW_ID = 1
    }

    // Representación mas ordenada de los datos
    override fun toString(): String {
        return "Personal(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, rol=$rol, posición=$posicion, dorsal=$dorsal, altura=$altura, peso=$peso, goles=$goles, partidosJugados=$partidosJugados) )"
    }

    // Tipos para el personal
    enum class Rol {
        DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO, ENTRENADOR, AUXILIAR
    }
}