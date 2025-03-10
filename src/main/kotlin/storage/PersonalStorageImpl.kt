package org.example.storage

import org.example.exceptions.exceptions
import org.example.models.Personal
import org.lighthousegames.logging.logging
import java.io.File


// Clase para trabajar con distintos tipos de formato
class PersonalStorageImpl (
    private val storageCsv : PersonalStorageCsv = PersonalStorageCsv(),
    // private val storageXml : PersonalStorageXml = PersonalStorageXml(), --> // Por hacer (Pablo Z)
    private val storageJson : PersonalStorageJson = PersonalStorageJson(),
   // private val storageBin : PersonalStorageBin = PersonalStorageBin --> // Por hacer (Lucia)

) : PersonalStorage {
    private val logger = logging()

    //Lee un formato en base a la opcion que se elija
    override fun readFile(file: File, format: FileFormat): List<Personal> {
        logger.debug { "Leyendo el fichero..." }
        return when(format) {
            FileFormat.CSV -> storageCsv.readFile(file) // --> Por hacer (Lucía)
            // FileFormat.XML -> storageCsv.readFromFile(file) // --> Por hacer (Pablo Z)
            FileFormat.JSON -> storageJson.readFile(file)
            //FileFormat.BIN -> storageCsv.readFromFile(file) // --> Por hacer (Lucia)
            else -> throw exceptions.PersonalStorageFormat("El formato no es compatible")
        }
    }

    //Escribe en un formato en base a la opcion que se elija
    override fun writeFile(file: File, format: FileFormat, personal: List<Personal>) {
        logger.debug { "Sobreescribiendo el fichero..." }
        return when(format) {
            //FileFormat.CSV -> storageCsv.readFromFile(file) // --> Por hacer (Lucía)
            // FileFormat.XML -> storageCsv.readFromFile(file) // --> Por hacer (Pablo Z)
            FileFormat.JSON -> storageJson.writeFile(personal, file)
            //FileFormat.BIN -> storageCsv.readFromFile(file) // --> Por hacer (Lucia)
            else -> throw exceptions.PersonalStorageFormat("El formato no es compatible")
        }
    }
}