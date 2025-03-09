package org.example.service

import org.example.models.Personal
import org.example.storage.FileFormat

//interfaz base que define funciones para trabajar con personal.
interface PersonalService {
    fun readFile(filepath: String, format: FileFormat): List<Personal>
    fun writeFile(filepath: String, format: FileFormat, personal: List<Personal>)

    fun importFile(filePath: String, format: FileFormat)
    fun exportFile(filePath: String, format: FileFormat)

    fun getAll(): List<Personal>
    fun getById(id: Long): Personal
    fun save(personal: Personal): Personal
    fun update(id: Long, personal: Personal): Personal
    fun delete(id: Long): Personal
}
