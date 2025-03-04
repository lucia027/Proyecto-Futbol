package org.example.storage

import org.example.exceptions.exceptions
import java.io.File

class PersonalStorageControlador {
    fun elegirExtension(file: File): PersonalStorage{
        val extension = file.extension.lowercase()
        return when(extension){
            "csv" -> PersonalStorageCsv()
            "json" -> PersonalStorageJson()
            //"xml" -> PersonalStorageXml()
            //"bin" ->
            else -> throw exceptions.PersonalStorageException("El fromato del archivo no es compatible, fromato: .$extension")
        } as PersonalStorage
    }

}