package org.example.storage

import org.example.models.Personal
import java.io.File

interface PersonalStorageFile {
    fun readFromFile(file : File) : List<Personal>
    fun writeToFile (personal: List<Personal>, file: File)
}