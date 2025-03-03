package org.example.storage
import org.example.models.Personal
import java.io.File

interface FunctionStorage <T> {
    fun readFromFile(file : File, format: String) : List<T>
    fun writeToFile (file : File, format : String,  personal : List<T>)
}