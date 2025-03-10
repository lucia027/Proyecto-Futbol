import org.example.Dto.EntrenadorDto
import org.example.Dto.PersonalDto
import org.example.models.Entrenador

/**
 * Esta función convierte un objeto Entrenador en un PersonalDto y viceversa
 * Cuando se pasa de Entrenador a PersonalDto
 * se rellenan los campos específicos del entrenador y se dejan vacíos o nulos los campos que no aplican (como posición o dorsal)
 */

fun Entrenador.toDto(): PersonalDto {
    return PersonalDto(
        id = id,
        nombre = nombre,
        apellidos = apellidos,
        fecha_nacimiento = fechaNacimiento.toString(),
        fecha_incorporacion = fechaIncorporacion.toString(),
        salario = salario!!,
        pais = pais,
        especialidad = especialidad.toString(),
        rol = "Entrenador",
        posicion = "", // No aplica para entrenadores
        dorsal = null, // No aplica para entrenadores
        altura = null, // No aplica para entrenadores
        peso = null, // No aplica para entrenadores
        goles = null, // No aplica para entrenadores
        partidos_jugados = null // No aplica para entrenadores
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
        especialidad = this.especialidad,
        rol = this.rol
    )
}
