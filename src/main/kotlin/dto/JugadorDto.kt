package org.example.Dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.models.Jugador

@Serializable
class JugadorDto(
    @SerialName("Idjugador")
    override val id: Int,
    @SerialName("nombreJugador")
    override val nombre: String,
    @SerialName("apellidosJugador")
    override val apellidos: String,
    @SerialName("fechaNacimientoJugador")
    override val fechaNacimiento: String,
    @SerialName("fechaIncorporacionJugador")
    override val fechaIncorporacion: String,
    @SerialName("salarioJugador")
    override val salario: Double,
    @SerialName("paisJugador")
    override val pais: String,
    @SerialName("posicionJugador")
    val posicion: Jugador.Posicion,
    @SerialName("dorsalJugador")
    val dorsal: Int,
    @SerialName("alturaJugador")
    val altura: Double,
    @SerialName("pesoJugador")
    val peso: Double,
    @SerialName("golesJugador")
    val goles: Int,
    @SerialName("partidosJugador")
    val partidosJugados: Int
) : PersonalDto (id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais), java.io.Serializable