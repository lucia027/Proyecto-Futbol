package org.example.mapper


import org.example.Dto.JugadorDto
import org.example.PersonalDto
import org.example.models.Jugador
import org.example.models.Personal

fun Jugador.toDto(): PersonalDto {
    return PersonalDto(
        id = id,
        nombre = nombre,
        apellidos = apellidos,
        fecha_nacimiento = fechaNacimiento,
        fecha_incorporacion = fechaIncorporacion,
        salario = salario,
        pais = pais,
        posicion = posicion.toString(),
        dorsal = dorsal,
        altura = altura,
        peso = peso,
        goles = goles,
        partidos_jugados = partidosJugados,
        rol = rol,
        especialidad = "",
    )
}

fun JugadorDto.toModel(): Personal {
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
        partidosJugados = this.partidosJugados,
        rol = this.rol
    )
}


