package org.example.service

import org.example.models.Personal
import org.example.storage.FileFormat

interface PersonalService {

    // Lee un archivo en el formato especificado y devuelve una lista de objetos Personal.
    fun readFile(filepath: String, format: FileFormat): List<Personal>

    // Escribe una lista de objetos Personal en un archivo en el formato especificado.
    fun writeFile(filepath: String, format: FileFormat, personal: List<Personal>)

    // Importa datos desde un archivo al sistema, manejando el formato especificado.
    fun importFile(filePath: String, format: FileFormat)

    // Exporta los datos del sistema a un archivo en el formato especificado.
    fun exportFile(filePath: String, format: FileFormat)

    // Devuelve una lista con todos los objetos Personal almacenados.
    fun getAll(): List<Personal>

    // Devuelve un objeto Personal específico basado en su ID.
    fun getById(id: Long): Personal

    // Guarda un nuevo objeto Personal y lo devuelve.
    fun save(personal: Personal): Personal

    // Actualiza un objeto Personal existente basado en su ID y devuelve el objeto actualizado.
    fun update(id: Long, personal: Personal): Personal

    // Elimina un objeto Personal por su ID y devuelve el objeto eliminado.
    fun delete(id: Long): Personal

}