
package org.example.Dto

import org.example.models.Entrenador.Especializacion
import org.example.models.Personal.Companion.NEW_ID

class EntrenadorDto (
    val id: Int,
    val nombre: String,
    val apellidos: String,
    val fechaNacimiento: String,
    val fechaIncorporacion: String,
    val salario: Double,
    val pais: String,
    val especialidad: String,
){

}


