package org.example.storage

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.example.PersonalDto
import org.example.models.Personal
import java.io.File
import org.example.exceptions.exceptions
import org.example.mapper.toDto
import org.example.mapper.toEntrenador
import org.example.mapper.toJugador
import org.example.models.Entrenador
import org.example.models.Jugador
import org.lighthousegames.logging.logging


class PersonalStorageJson : PersonalStorageFile {

    // implementacion del logger
    val logger = logging()

    init {
        logger.debug { "inicializando PersonalStorageJson" }
    }
    // Lee el archivo json y lo transforma a una cadena
    override fun readFromFile(file: File): List<Personal> {
        println()
        logger.debug { "Leyendo JSON" }

        if (!file.exists() || !file.isFile || !file.canRead()) {
            throw exceptions.PersonalStorageException("El fichero no se puede leer, no es un fichero o no se ha encontrado")
        } else {
            val json = Json { ignoreUnknownKeys = true; prettyPrint = true }
            val imprimirJson = file.readText()
            val listaPersonalDto = json.decodeFromString<List<PersonalDto>>(imprimirJson)

            val listaPersonalModel = listaPersonalDto.map {
                    when (it.rol) {
                        "Entrenador" -> it.toEntrenador()
                         else -> it.toJugador()
                    }
            }
            return listaPersonalModel
        }
    }

    // Escribe en el archivo json
    override fun writeToFile(personal: List<Personal>, file: File) {
        if (!file.parentFile.exists() || !file.parentFile.isDirectory || !file.canWrite()) {
            throw exceptions.PersonalStorageException("El fichero json no se puede sobreescribir o no existe en su directorio padre")
        } else {
            val json = Json { ignoreUnknownKeys = true; prettyPrint = true }
            val listaPersonalDto = personal.map {
                when (it) {
                    is Jugador -> { it.toDto() }
                    is Entrenador -> { it.toDto() }
                    else -> null
                    }
                }

            val jsonString = json.encodeToString(listaPersonalDto)
            file.writeText(jsonString)
            }
        }
    }





