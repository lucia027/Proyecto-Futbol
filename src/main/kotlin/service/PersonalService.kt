package org.example.service

import org.example.models.Personal


interface PersonalService {
    fun readFromFile(filepath: String): List<Personal>
    fun writeToFile(filepath: String, personal: List<Personal>)

    fun importFromFile(filePath: String)
    fun exportToFile(filePath: String)

    fun getAll(): List<Personal>
    fun getById(id: Int): Personal
    fun save(personal: Personal): Personal
    fun update(id: Long, personal: Personal): Personal
    fun delete(id: Long): Personal
}
