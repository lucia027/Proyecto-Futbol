package org.example.storage

import kotlinx.serialization.json.Json
import org.example.exceptions.exceptions
import org.example.mapper.toEntrenador
import org.example.mapper.toJugador
import org.example.models.Entrenador
// import org.example.mapper.toModel
import org.example.models.Personal
import java.io.File

class PersonalStorageJson<T> : FunctionStorage<Personal>  {
    override fun readFromFile(file: File, format: String): List<Personal> {
        if (!file.exists() || !file.isFile || !file.canRead() || file.length() == 0L) {
            throw exceptions.PersonalStorageException("El fichero no existe o no se puede leer")
        } else {

        }
    }

    override fun writeToFile(file: File, format: String, personal: List<Personal>) {
        TODO("Not yet implemented")
    }


}