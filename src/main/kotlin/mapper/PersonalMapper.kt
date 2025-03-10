package org.example.mapper

import org.example.Dto.PersonalDto
import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal

//Funcion de extension para convertir un PersonalDto a Jugador
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
        posicion = Jugador.Posicion.valueOf(posicion!!), // Convierte la posición de texto a enum
        dorsal = this.dorsal ?: 0, // Si es nulo, asigna 0
        altura = this.altura ?: 0.0, // Si es nulo, asigna 0.0
        peso = this.peso ?: 0.0, // Si es nulo, asigna 0.0
        goles = this.goles ?: 0, // Si es nulo, asigna 0
        partidosJugados = this.partidos_jugados ?: 0 // Si es nulo, asigna 0
    )
}

//Funcion de extension para convertir un PersonalDto a Entrenador
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
        especialidad = Entrenador.Especializacion.valueOf(especialidad!!) // Convierte la especialidad a enum
    )
}

//Funcion de extension que convierte un PersonalDto a Personla, eligiendo despues entre Jugaodr y Entrenador
fun PersonalDto.toModel(): Personal {
    return if (this.rol == "Jugador") {
        Jugador(
            id = id,
            nombre = nombre,
            apellidos = apellidos,
            fechaNacimiento = fecha_nacimiento,
            fechaIncorporacion = fecha_incorporacion,
            salario = salario,
            pais = pais,
            posicion = Jugador.Posicion.valueOf(posicion!!), // Convierte la posición a enum
            dorsal = dorsal!!, // Asume que no es nulo para jugadores
            altura = altura!!, // Asume que no es nulo para jugadores
            peso = peso!!, // Asume que no es nulo para jugadores
            goles = goles!!, // Asume que no es nulo para jugadores
            partidosJugados = this.partidos_jugados!!, // Asume que no es nulo para jugadores
            rol = this.rol,
        )
    } else {
        Entrenador(
            id = id,
            nombre = nombre,
            apellidos = apellidos,
            fechaNacimiento = this.fecha_nacimiento,
            fechaIncorporacion = this.fecha_incorporacion,
            salario = salario,
            pais = pais,
            especialidad = Entrenador.Especializacion.valueOf(especialidad!!), // Convierte la especialidad a enum
            rol = this.rol
        )
    }
}
