package org.example.mapper

import org.example.Dto.EntrenadorDto
import org.example.PersonalDto
import org.example.models.Entrenador


fun Entrenador.toDto (): PersonalDto {
    return PersonalDto(
        id = id,
        nombre = nombre,
        apellidos = apellidos,
        fecha_nacimiento = fechaNacimiento.toString(),
        fecha_incorporacion = fechaIncorporacion.toString(),
        salario = salario,
        pais = pais,
        especialidad = especialidad.toString(),
        rol = "Entrenador",
        posicion = "",
        dorsal = null,
        altura = null,
        peso = null,
        goles = null,
        partidos_jugados = null
    )
}

fun EntrenadorDto.toModel(): Entrenador {
    return Entrenador(
        id = this.id,
        nombre = this.nombre,
        apellidos = this.apellidos,
        fechaNacimiento = this.fechaNacimiento,
        fechaIncorporacion = this.fechaIncorporacion,
        salario = this.salario,
        pais = this.pais,
        especialidad = this.especialidad.toString(),
        rol = this.rol
    )
}

