package org.example.storage

import org.example.models.Personal
import java.io.File

interface PersonalStorage {
    fun readFromFile(file: File): List<Personal>
    fun writeToFile(file: File, productos: List<Personal>)
}