package org.example.service

import org.example.models.Personal
import org.example.repository.CrudRepository

interface PersonalService<T : Personal> : CrudRepository<T, Int> {
    fun readFromFile(filePath: String): List<T>
    fun writeToFile(filePath: String, items: List<T>)

    fun importFromFile(filePath: String)
    fun exportToFile(filePath: String)
}