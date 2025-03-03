package org.example.mapper

import org.example.PersonalDto
import org.example.models.Entrenador
import org.example.models.Jugador

fun PersonalDto.toJugador(): Jugador {
    return Jugador(
        id = this.id,
        nombre = this.nombre,
        apellidos = this.apellidos,
        fechaNacimiento = this.fecha_nacimiento,
        fechaIncorporacion = this.fecha_incorporacion,
        salario = this.salario,
        pais = this.pais,
        rol = this.rol,
        posicion = Jugador.Posicion.valueOf(posicion!!),
        dorsal = this.dorsal ?: 0,
        altura = this.altura ?: 0.0,
        peso = this.peso ?: 0.0,
        goles = this.goles ?: 0,
        partidosJugados = this.partidos_jugados ?: 0
    )
}

fun PersonalDto.toEntrenador(): Entrenador {
        return Entrenador(
            id = this.id,
            nombre = this.nombre,
            apellidos = this.apellidos,
            fechaNacimiento = this.fecha_nacimiento,
            fechaIncorporacion = this.fecha_incorporacion,
            salario = this.salario,
            pais = this.pais,
            rol = this.rol,
            especialidad = Entrenador.Especializacion.valueOf(especialidad!!)
        )
    }
