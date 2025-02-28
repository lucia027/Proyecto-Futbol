package org.example.models

class Entrenador (
    override val id: Int = NEW_ID,
    override val nombre: String,
    override val apellidos: String,
    override val fechaNacimiento: String,
    override val fechaIncorporacion: String,
    override val salario: Double,
    override val pais: String,
    val especializacion: Especializacion

) : Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais){

    // Tipos para el entrenador
    enum class Especializacion {
        ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL, ENTRENADOR_ASISTENTE
    }
}