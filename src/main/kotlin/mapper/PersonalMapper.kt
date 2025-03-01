package org.example.mapper

import org.example.Dto.PersonalDto
import org.example.models.Personal
import java.time.LocalDate


fun Personal.toDto(): PersonalDto {
    return PersonalDto(
        id = this.id,
        nombre = this.nombre,
        apellidos = this.apellidos,
        fechaNacimiento = this.fechaNacimiento.toString(),
        fechaIncorporacion = this.fechaIncorporacion.toString(),
        salario = this.salario,
        pais = this.pais,
    )
}

fun PersonalDto.toModel(): Personal {
    return Personal(
        id = this.id,
        nombre = this.nombre,
        apellidos = this.apellidos,
        fechaNacimiento = this.fechaNacimiento,
        fechaIncorporacion = this.fechaIncorporacion,
        salario = this.salario,
        pais = this.pais,
    )
}