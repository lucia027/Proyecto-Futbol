package org.example.storage

import org.example.models.Personal
import java.io.File

// Interfaz a implementar en PersonalStorageImpl para poder gestionar los tipos de formato
// Se implementara en el StorageImpl para coordinar instrucciones
interface PersonalStorage {
    fun readFromFile(file: File, format: FileFormat ): List<Personal>
    fun writeToFile(file: File, format: FileFormat, personal: List<Personal>)
}