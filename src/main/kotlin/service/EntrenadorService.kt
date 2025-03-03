package org.example.service

import org.example.models.Entrenador
import org.example.repository.CrudRepository

interface EntrenadorService : CrudRepository<Entrenador, Int> {
    fun importFromFile(filePath: String)
    fun exportToFile(filePath: String)
}