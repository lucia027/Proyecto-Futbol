package org.example.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class Jugador (
    override val id: Int = NEW_ID,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: String,
    override val fechaIncorporacion: String,
    override val salario: Double,
    override val pais: String,
    val posicion: Posicion,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidosJugados: Int

): Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais){

    override fun toString(): String {
        return("Jugador(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, posiciom=$posicion, dorsal=$dorsal, altura=$altura, peso=$peso, goles=$goles, partidosJugados=$partidosJugados )")
    }

    @Serializable
    enum class Posicion {
        @SerialName("posicion")
        DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO,
        @SerialName("")
        NINGUNO
    }
}