package org.example.storage.storage

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import nl.adaptivity.xmlutil.serialization.XML
import org.example.Dto.PersonalDto
import org.example.exceptions.exceptions
import org.example.mapper.toEntrenador
import org.example.mapper.toJugador
import org.example.models.Personal
import org.example.storage.FunctionStorage
import java.io.File

class PersonalStorageXml<T>: FunctionStorage<Personal> {

    override fun readFromFile(file: File, format: String): List<Personal> {
        if (!file.exists() || !file.isFile || !file.canRead()) {
            throw exceptions.PersonalStorageException("El fichero no existe o no se puede leer")
        } else {
            val xml = XML {}
            val imprimirXml = file.readText()
            val personalDtoList = xml.decodeFromString<List<PersonalDto>>(imprimirXml)
            return personalDtoList as List<Personal>

        }
    }

    override fun writeToFile(file: File, format: String, personal: List<Personal>) {
        TODO("Not yet implemented")
    }
}