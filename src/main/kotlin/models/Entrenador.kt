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

    override fun toString(): String{
        return("Personal(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais, especializacion=$especializacion)")
    }

    // Tipos para el entrenador
    enum class Especializacion {
        ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL, ENTRENADOR_ASISTENTE
    }
}