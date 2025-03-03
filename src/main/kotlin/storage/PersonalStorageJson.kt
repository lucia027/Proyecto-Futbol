package org.example.storage

import kotlinx.serialization.json.Json
import org.example.models.Personal
import java.io.File
import org.example.exceptions.exceptions


class PersonalStorageJson<T> : FunctionStorage<Personal>  {
    override fun readFromFile(file: File, format: String): List<Personal> {
        if (!file.exists() || !file.isFile || !file.canRead() || file.length() == 0L) {
            throw exceptions.PersonalStorageException("El fichero no existe o no se puede leer")
        } else {
            val json = Json { prettyPrint = true; ignoreUnknownKeys = true }
            val imprimirJson = json.decodeFromString<List<Personal>>(file.readText())
            return imprimirJson
        }
    }

    override fun writeToFile(file: File, format: String, personal: List<Personal>) {
        TODO("Not yet implemented")
    }


}