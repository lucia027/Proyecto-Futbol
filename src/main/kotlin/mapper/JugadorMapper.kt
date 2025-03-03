package org.example.mapper

import org.example.Dto.JugadorDto
import org.example.models.Jugador

fun Jugador.toDto(): JugadorDto {
    return JugadorDto(
        id = this.id,
        nombre = this.nombre,
        apellidos = this.apellidos,
        fechaNacimiento = this.fechaNacimiento,
        fechaIncorporacion = this.fechaIncorporacion,
        salario = this.salario,
        pais = this.pais,
        posicion = this.posicion,
        dorsal = this.dorsal,
        altura = this.altura,
        peso = this.peso,
        goles = this.goles,
        partidosJugados = this.partidosJugados
    )
}

fun JugadorDto.toModel(): Jugador {
    return Jugador(
        id = this.id,
        nombre = this.nombre,
        apellidos = this.apellidos,
        fechaNacimiento = this.fechaNacimiento,
        fechaIncorporacion = this.fechaIncorporacion,
        salario = this.salario,
        pais = this.pais,
        posicion = this.posicion,
        dorsal = this.dorsal,
        altura = this.altura,
        peso = this.peso,
        goles = this.goles,
        partidosJugados = this.partidosJugados
    )
}
