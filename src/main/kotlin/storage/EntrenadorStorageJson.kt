package org.example.storage.storage

import kotlinx.serialization.json.Json
// import org.example.Dto.EntrenadorDto
import org.example.exceptions.exceptions
// import org.example.mapper.toModel
import org.example.models.Entrenador

import org.example.storage.FunctionStorage
import java.io.File

/*class EntrenadorStorageJson<T> : FunctionStorage<Entrenador> {

    override fun readFromFile(file: File, format: String): List<Entrenador> {
        if (!file.exists() || !file.isFile || !file.canRead()) {
            throw exceptions.PersonalStorageException("El fichero no existe o no se puede leer")
        } else {
            val json = Json {
                prettyPrint = true
                ignoreUnknownKeys = true
            }
            val personalList : List<EntrenadorDto> = json.decodeFromString(file.readText())
            return personalList.map { it.toModel() }
        }
    }

    override fun writeToFile(file: File, format: String, personal: List<Entrenador>) {
        TODO("Not yet implemented")
    }
}

 */
