package org.example.models


import java.time.LocalDate

class Jugador (

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class Jugador(
    override val id: Int = NEW_ID,
    override var nombre: String,
    override var apellidos: String,
    override var fechaNacimiento: String,
    override var fechaIncorporacion: String,
    override var salario: Double,
    override var pais: String,
    var posicion: Posicion,
    var dorsal: Int,
    var altura: Double,
    var peso: Double,
    var goles: Int,
    var partidosJugados: Int

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

    fun copyJugador(id: Int): Jugador{
        return Jugador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, posicion, dorsal, altura, peso, goles, partidosJugados)
    }
}