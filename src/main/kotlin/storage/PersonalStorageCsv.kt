package org.example.storage

import org.example.Dto.PersonalDto
import org.example.exceptions.exceptions
import org.example.mapper.toModel
import org.example.models.Personal
import org.lighthousegames.logging.logging
import java.io.File

class PersonalStorageCsv : PersonalStorageFile {

    //Implementación del logger
    private val logger = logging()
    init {
        logger.debug { "Iniciando almacenamiento en CSV" }
    }

    //Lee el fichero y lo transforma a una lista del tipo PersonalDto
    override fun readFile(file: File): List<Personal> {
        logger.debug { "Leyendo fichero CSV" }

        if (!file.exists() || !file.isFile || !file.canRead() || !file.canRead() || file.length() == 0L || !file.name.endsWith(".csv")) {
            logger.error { "El fichero no existe o no se puede leer: $file" }
            throw exceptions.PersonalStorageException("El fichero no existe o no se puede leer")
        }

        val lista = file.readLines()
            .drop(1)
            .map { it.split(",") }
            .map { it.map { it.trim() } }
            .map{
                PersonalDto(
                    id = it[0].toLong(),
                    nombre = it[1],
                    apellidos = it[2],
                    fecha_nacimiento = it[3],
                    fecha_incorporacion = it[4],
                    salario = it[5].toDouble(),
                    pais = it[6],
                    rol = it[7],
                    especialidad = it[8],
                    posicion = it[9],
                    dorsal = it[10].toIntOrNull(),
                    altura = it[11].toDoubleOrNull(),
                    peso = it[12].toDoubleOrNull(),
                    goles = it[13].toIntOrNull(),
                    partidos_jugados = it[14].toIntOrNull(),
                ).toModel()
            }
        return lista
    }

    override fun writeFile(personal: List<Personal>, file: File) {
        logger.debug { "Escribiendo fichero CSV" }
        if (!file.parentFile.exists() || !file.parentFile.isDirectory || !file.name.endsWith(".csv")) {
            logger.error { "El directorio padre del fichero no se encuentra o no existe" }
            throw exceptions.PersonalStorageCsv("El directorio padre no existe")
        }
    }
}


