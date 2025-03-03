package org.example.storage

import nl.adaptivity.xmlutil.serialization.XML
import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal
import org.example.storage.storage.PersonalStorageXml
//import org.example.storage.storage.PersonalStorageXml
// import org.example.storage.storage.EntrenadorStorageJson
import java.io.File

fun main() {

    // Ruta del archivo JSON
     val file = File("data", "personal.json")

    //Instanciamos la clase para leer el archivo Json
    val personalJson = PersonalStorageJson<Personal>().readFromFile(file, "json")


    try {
        val file2 : File = File("data", "personal.xml")
        val personalXml = PersonalStorageXml<Personal>().readFromFile(file2, "xml")

    } catch (e : Exception) {
        println(e)

    }

}
