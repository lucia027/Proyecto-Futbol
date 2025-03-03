package org.example.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class Jugador(

    id: Long,
    nombre: String,
    apellidos: String,
    fechaNacimiento: String,
    fechaIncorporacion: String,
    salario: Double,
    pais: String,
    rol: String,
    val posicion: Posicion,
    val dorsal: Int,
    val altura: Double,
    val peso: Double,
    val goles: Int,
    val partidosJugados: Int

): Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol) {

    override fun toString(): String {
        return ("Jugador(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, posiciom=$posicion, dorsal=$dorsal, altura=$altura, peso=$peso, goles=$goles, partidosJugados=$partidosJugados )")
    }

    @Serializable
    enum class Posicion {
        @SerialName("posicion")
        DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO,
        @SerialName("")
        NINGUNO
    }
}