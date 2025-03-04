package org.example.storage

import org.example.models.Personal
import java.io.File


// Interfaz para poder leer cualquier tipo de formato
// Se implementara en los Storage de cada formato

interface PersonalStorageFile {
    fun readFromFile(file : File) : List<Any>
    fun writeToFile (personal: List<Personal>, file: File)
}