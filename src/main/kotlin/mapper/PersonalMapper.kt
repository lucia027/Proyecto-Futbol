package org.example.mapper

import org.example.Dto.PersonalDto
import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal
import java.time.LocalDate


fun PersonalDto.toEntrenador(): Entrenador {
    return Entrenador(
        id = this.id,
        nombre = this.nombre,
        apellidos = this.apellidos,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        especialidad = Entrenador.Especializacion.NINGUNO

    )
}

fun PersonalDto.toJugador(): Jugador{
    return Jugador(
        id = this.id,
        nombre = this.nombre,
        apellidos = this.apellidos,
        fechaNacimiento = this.fechaNacimiento,
        fechaIncorporacion = this.fechaIncorporacion,
        salario = this.salario,
        pais = this.pais,
        posicion = Jugador.Posicion.NINGUNO,
        dorsal = this.dorsal ?: 0,
        altura = this.altura ?: 0.0,
        peso = this.peso ?: 0.0,
        goles = this.goles ?: 0,
        partidosJugados = this.partidosJugados ?: 0,
    )
}