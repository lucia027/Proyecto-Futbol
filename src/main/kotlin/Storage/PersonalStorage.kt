package org.example.Storage

import org.example.Dto.PersonalDto
import org.example.models.Personal
import java.io.File


// Interfaz para leer ficheros y sobreescribirlos
interface PersonalStorage {
    fun readFromFile(file: File, format: String): List<PersonalDto>
    fun writeToFile(personal : List<PersonalDto>, file : File, format: fileFormat)
}


// Tipos de formato
enum class fileFormat {
    JSON, CSV, XML, CONSOLA, BIN
}