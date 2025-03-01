package org.example.storage

import org.example.Dto.PersonalDto
import org.example.models.Personal
import java.io.File

fun main() {

    // Ruta del archivo JSON
    val file = File("data", "personal.json")

    // Instanciamos la clase para leer el archivo Json
    val personalJson = PersonalStorageJson<Personal>().readFromFile(file, "json")
    personalJson.forEach { println(it) }

    println()

    // Ruta del archivo XML

    // Instanciamos la clase para leer el archivo Xml


/*
    val file = File("data", "personal.xml")
    val personalXml =
 */

// Prueba CRUD

// Obtención de jugador NO existente
try {

}

}
