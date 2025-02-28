package org.example.mapper

import org.example.Dto.EntrenadorDto
import org.example.models.Entrenador
import java.time.LocalDate


fun Entrenador.toDto(): EntrenadorDto {
    return EntrenadorDto(
        id = this.id,
        nombre = this.nombre,
        apellidos = this.apellidos,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
        especializacion = this.especializacion
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
        especializacion = this.especializacion
    )
}