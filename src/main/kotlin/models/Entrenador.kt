package org.example.models
import java.time.LocalDate

class Entrenador (
    override val id: Int,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: LocalDate,
    override val fechaIncorporacion: LocalDate,
    override val salario: Double,
    override val pais: String,
    val especializacion: Especializacion

) : Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais){

    // Tipos para el entrenador
    enum class Especializacion {
        ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL, ENTRENADOR_ASISTENTE
    }
}