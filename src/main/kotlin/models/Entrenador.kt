package org.example.models

class Entrenador(
    override val id: Int = NEW_ID,
    override var nombre: String,
    override var apellidos: String,
    override var fechaNacimiento: String,
    override var fechaIncorporacion: String,
    override var salario: Double,
    override var pais: String,
    var especializacion: Especializacion

) : Personal(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais){

    // Tipos para el entrenador
    enum class Especializacion {
        ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL, ENTRENADOR_ASISTENTE
    }

    fun copyEntrenador(id: Int): Entrenador{
        return Entrenador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, especializacion)
    }
}