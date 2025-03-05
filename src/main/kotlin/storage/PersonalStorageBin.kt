package org.example.storage

import org.example.Dto.EntrenadorDto
import org.example.Dto.JugadorDto
import org.example.PersonalDto
import org.example.exceptions.exceptions
import org.example.mapper.toModel
import org.example.models.Personal
import org.lighthousegames.logging.logging
import java.io.File
import java.io.RandomAccessFile

class PersonalStorageBin : PersonalStorageFile {
    //Implementacion del logger
    private val logger = logging()
    init {
        logger.debug { "Iniciando almacenamiento en Binario" }
    }

    override fun readFromFile(file: File): List<Any> {
        logger.debug { "Leyendo fichero Binario" }

        if (!file.exists() || !file.isFile || !file.canRead() || file.length() == 0L || !file.name.endsWith(".bin")) {
            logger.error { "El fichero no existe o no se puede leer: $file" }
            throw exceptions.PersonalStorageException("El fichero no existe o no se puede leer")
        }

        val personal = mutableListOf<PersonalDto>()
        RandomAccessFile(file, "r").use { raf ->
            while (raf.filePointer < raf.length()) {
                val id = raf.readLong()
                val nombre = raf.readUTF()
                val apellidos = raf.readUTF()
                val fecha_nacimiento = raf.readUTF()
                val fecha_incorporacion = raf.readUTF()
                val salario = raf.readDouble()
                val pais = raf.readUTF()
                val rol = raf.readUTF()
                val especialidad = raf.readUTF()
                val posicion = raf.readUTF()
                val dorsal = raf.readInt()
                val altura = raf.readDouble()
                val peso = raf.readDouble()
                val goles = raf.readInt()
                val partidos_jugados = raf.readInt()

                val personal1  = PersonalDto(
                    id, nombre, apellidos, fecha_nacimiento, fecha_incorporacion,
                    salario, pais, rol, especialidad, posicion, dorsal, altura,
                    peso, goles, partidos_jugados
                )
                personal.add(personal1)
                }
            }
        return personal.map { it.toModel() }
    }


    override fun writeToFile(personal: List<Personal>, file: File) {
        TODO("Not yet implemented")
    }
}