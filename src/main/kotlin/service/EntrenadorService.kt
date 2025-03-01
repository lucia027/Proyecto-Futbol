package org.example.service

import org.example.models.Entrenador
import org.example.repository.CrudRepository

interface EntrenadorService : CrudRepository<Entrenador, Int> {
    fun readFromFile(filePath: String): List<Entrenador>
    fun writeToFile(filePath: String, entrenadores: List<Entrenador>)

    fun importFromFile(filePath: String)
    fun exportToFile(filePath: String)
}