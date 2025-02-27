package org.example.Dto

import org.example.models.Personal

class EntrenadorDto (

    val especialidad: String,
    val id: Int,
    val nombre: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String,
    val rol: Personal.Rol

)