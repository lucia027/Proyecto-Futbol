package org.example.storage

import org.example.Dto.EntrenadorDto
import org.example.Dto.JugadorDto
import org.example.dto.PersonalDto
import org.example.exceptions.exceptions
import org.example.models.Personal
import org.lighthousegames.logging.logging
import java.io.File

class PersonalStorageCsv : PersonalStorageFile{

    private val logger = logging()
    init {
        logger.debug { "Iniciando almacenamiento en CSV" }
    }

    override fun readFromFile(file: File): List<PersonalDto> {
        logger.debug { "Leyendo fichero CSV" }

        if (!file.exists() || !file.isFile || !file.canRead() || !file.canRead() || file.length() == 0L || !file.name.endsWith(".csv")) {
            logger.error { "El fichero no existe o no se puede leer: $file" }
            throw exceptions.PersonalStorageException("El fichero no existe o no se puede leer")
        }

        val lista = file.readLines()
            .drop(1)
            .map { it.split(",") }
            .map { it.map { it.trim() } }
            .map{ fields ->
                when(fields[7]){
                    "Jugador" -> JugadorDto(
                        id = fields[0].toInt(),
                        nombre = fields[1],
                        apellidos = fields[2],
                        fechaNacimiento = fields[3],
                        fechaIncorporacion = fields[4],
                        salario = fields[5].toDouble(),
                        pais = fields[6],
                        rol = fields[7],
                        posicion = fields[9],
                        dorsal = fields[10].toInt(),
                        altura = fields[11].toDouble(),
                        peso = fields[12].toDouble(),
                        goles = fields[13].toInt(),
                        partidosJugados = fields[14].toInt()
                    )
                    "Entrenador" -> EntrenadorDto(
                        id = fields[0].toInt(),
                        nombre = fields[1],
                        apellidos = fields[2],
                        fechaNacimiento = fields[3],
                        fechaIncorporacion = fields[4],
                        salario = fields[5].toDouble(),
                        pais = fields[6],
                        rol = fields[7],
                        especialidad = fields[8]
                    )
                    else -> throw exceptions.PersonalStorageCsv("No se ha encontrado el nombre del rol: ${fields[7]} ")
                }
            }
        return lista
    }


    override fun writeToFile(personal: List<Personal>, file: File) {

        logger.debug { "Escribiendo fichero CSV" }
        if (!file.parentFile.exists() || !file.parentFile.isDirectory || !file.name.endsWith(".csv")) {
            logger.error { "El directorio padre del fichero no se encuentra o no existe" }
            throw exceptions.PersonalStorageCsv("El directorio padre no existe")
        }
        file.writeText("id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, rol")
        personal.forEach {
            when(it){
                JugadorDto -> file.appendText("${it.id}, ${it.nombre}, ${it.apellidos}, ${it.fechaNacimiento}, ${it.fechaIncorporacion}, ${it.salario}, ${it.pais}, ${it.rol}\n")
                EntrenadorDto -> file.appendText("${it.id}, ${it.nombre}, ${it.apellidos}, ${it.fechaNacimiento}, ${it.fechaIncorporacion}, ${it.salario}, ${it.pais}, ${it.rol}\n")
            }
        }
    }

}
