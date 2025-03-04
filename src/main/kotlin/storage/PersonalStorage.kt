package org.example.storage

import org.example.models.Personal
import java.io.File

interface PersonalStorage {
    fun readFromFile(file: File): List<Any>
    fun writeToFile(file: File, personal: List<Personal>)
}