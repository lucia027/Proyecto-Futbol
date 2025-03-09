package org.example.storage


/*
import org.example.Dto.EntrenadorDto
import org.example.Dto.JugadorDto

import org.example.PersonalDto
import org.example.exceptions.exceptions
import org.example.mapper.toDto
import org.example.mapper.toModel
import org.example.models.Entrenador
import org.example.models.Jugador
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

    override fun readFile(file: File): List<Personal> {
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


    override fun writeFile(personal: List<Personal>, file: File) {
        logger.debug { "Escribiendo fichero CSV" }
        if (!file.parentFile.exists() || !file.parentFile.isDirectory || !file.name.endsWith(".bin")) {
            logger.error { "El directorio padre del fichero no se encuentra o no existe" }
            throw exceptions.PersonalStorageCsv("El directorio padre no existe")
        }

        val personalDto : List<PersonalDto> = personal.map {
            when (it) {
                is Jugador -> {it.toDto()}
                is Entrenador -> {it.toDto()}
                else -> null
            } as PersonalDto
        }

        RandomAccessFile(file, "rw").use { raf ->
            raf.setLength(0)
            for (personal in personalDto){
                raf.writeLong(personal.id)
                raf.writeUTF(personal.nombre)
                raf.writeUTF(personal.apellidos)
                raf.writeUTF(personal.fecha_nacimiento)
                raf.writeUTF(personal.fecha_incorporacion)
                raf.writeDouble(personal.salario)
                raf.writeUTF(personal.pais)
                raf.writeUTF(personal.rol)
                raf.writeUTF(personal.especialidad)
                raf.writeUTF(personal.posicion)
                raf.writeInt(personal.dorsal!!)
                raf.writeDouble(personal.altura!!)
                raf.writeDouble(personal.peso!!)
                raf.writeInt(personal.goles!!)
                raf.writeInt(personal.partidos_jugados!!)
            }
        }
    }
}
 */