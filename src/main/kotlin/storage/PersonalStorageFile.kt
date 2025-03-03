package org.example.storage

import org.example.dto.PersonalDto
import org.example.models.Personal
import java.io.File

interface PersonalStorageFile {
    fun readFromFile(file : File) : List<PersonalDto>
    fun writeToFile (personal: List<Personal>, file: File)
}