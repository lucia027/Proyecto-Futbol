package org.example.Storage

import org.example.models.Personal
import java.io.File


// Interfaz para leer ficheros y sobreescribirlos
interface PersonalStorage {
    fun readFromFile(file : File, format: fileFormat): List<Personal>
    fun writeToFile(personal : List<Personal>, file : File, format: fileFormat)
}


// Tipos de formato
enum class fileFormat {
    JSON, CSV, XML, CONSOLA, BIN
}