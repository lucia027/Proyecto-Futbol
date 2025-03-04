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
    var posicion: Posicion,
    var dorsal: Int,
    var altura: Double,
    var peso: Double,
    var goles: Int,
    var partidosJugados: Int
): Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol) {

    override fun toString(): String {
        return ("Jugador(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, posiciom=$posicion, dorsal=$dorsal, altura=$altura, peso=$peso, goles=$goles, partidosJugados=$partidosJugados )")
    }

    override fun copy(
        id: Long,
        nombre: String,
        apellidos: String,
        fechaNacimiento: String,
        fechaIncorporacion: String,
        salario: Double,
        pais: String,
        rol: String,
    ): Personal {
        return Jugador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol, posicion, dorsal, altura, peso, goles, partidosJugados)
    }

    @Serializable
    enum class Posicion {
        @SerialName("posicion")
        DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO,
        @SerialName("")
        NINGUNO
    }
}