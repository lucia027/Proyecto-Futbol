package org.example.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Clase personal con sus parámetros

/**
 * @param id --> identidicador del personal
 * @param nombre --> nombre del personal
 * @param apellidos --> apellidos del personal
 * @param fechaNacimiento --> fecha de nacimiento del personal
 * @param fechaIncorporacion --> fecha de incorporacion del personal
 * @param salario --> lo que cobra el personal
 * @param pais --> pais donde ha nacido o debuta el personal
 * @param rol --> tipo de personal, Entrenador o Jugador
 */

@Serializable
abstract class Personal(
    val id: Long,
    var nombre: String,
    var apellidos: String,
    var fechaNacimiento: String,
    var fechaIncorporacion: String,
    var salario: Double?,
    var pais: String,
    val rol: String
    ) {

    companion object{
        val NEW_ID = 1L
    }

    /* Creo que esto sobra
    override fun toString(): String{
        return("Personal(id=$id, nombre=$nombre, apellidos=$apellidos, fechaNacimiento=$fechaNacimiento, fechaIncorporacion=$fechaIncorporacion, salario=$salario, pais=$pais)")
    }
     */

    abstract fun copy(
        id: Long = this.id,
        nombre: String = this.nombre,
        apellidos: String = this.apellidos,
        fechaNacimiento: String = this.fechaNacimiento,
        fechaIncorporacion: String = this.fechaNacimiento,
        salario: Double = this.salario!!,
        pais: String = this.pais,
        rol: String = this.rol
    ): Personal


    @Serializable
    enum class Tipo {
        @SerialName("tipo")
        Jugador, Entrenador,
        @SerialName("")
        NINGUNO
    }
}