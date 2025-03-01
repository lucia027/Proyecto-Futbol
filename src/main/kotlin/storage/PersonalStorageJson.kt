package org.example.storage

import kotlinx.serialization.json.Json
import org.example.Dto.PersonalDto
import org.example.exceptions.exceptions
import org.example.mapper.toModel
import org.example.models.Personal
import java.io.File

class PersonalStorageJson<T> : FunctionStorage<Personal>  {

    override fun readFromFile(file: File, format: String): List<Personal> {
        if (!file.exists() || !file.isFile || !file.canRead()) {
            throw exceptions.PersonalStorageException("El fichero no existe o no se puede leer")
        } else {
            val json = Json {
                prettyPrint = true
                ignoreUnknownKeys = true
            }
            val personalList : List<PersonalDto> = json.decodeFromString(file.readText())
            return personalList.map { it.toModel() }
        }
    }

    override fun writeToFile(file: File, format: String, personal: List<Personal>) {
        TODO("Not yet implemented")
    }

}