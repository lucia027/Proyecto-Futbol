package org.example.service

import org.example.models.Personal
import org.example.repository.CrudRepository

interface PersonalService<T : Personal> : CrudRepository<T, Int> {
    fun importFromFile(filePath: String)
    fun exportToFile(filePath: String)
}