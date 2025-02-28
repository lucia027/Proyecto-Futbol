package org.example.Dto

import org.example.models.Entrenador.Especializacion

class EntrenadorDto (

    val id: Int,
    val nombre: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String,
    val especializacion: Especializacion

)