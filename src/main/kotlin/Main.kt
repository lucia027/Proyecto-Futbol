package org.example

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.Storage.PersonalStorageJson
import java.io.File

fun main() {

    // Ruta del archivo JSON
    val file = File("data", "personal.json")

    // Instanciamos la clase para leer el archivo

    val personalJson = PersonalStorageJson().readFromFile(file, "json")
    personalJson.forEach { println(Json.encodeToString(it)) }
}

/*
    val file = File("data", "personal.xml")
    val personalXml =
 */

// Prueba CRUD

// Obtención de jugador NO existente
try {

}