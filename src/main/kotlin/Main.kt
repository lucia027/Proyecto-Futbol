package org.example.storage

import org.example.Dto.PersonalDto
import org.example.models.Entrenador
import org.example.models.Personal
import org.example.storage.storage.EntrenadorStorageJson
import java.io.File

fun main() {

    // Ruta del archivo JSON
    val file = File("data", "personal.json")

    // Instanciamos la clase para leer el archivo Json
    val personalJson = PersonalStorageJson<Personal>().readFromFile(file, "json")
    personalJson.forEach { println(it) }

    println()

    val entrenadorJson = EntrenadorStorageJson<Entrenador>().readFromFile(file, "json")
    entrenadorJson.forEach { println(it) }
    println()




}
