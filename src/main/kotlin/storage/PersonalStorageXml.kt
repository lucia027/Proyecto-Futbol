/*package org.example.storage.storage

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import nl.adaptivity.xmlutil.serialization.XML
import org.example.PersonalDto
import org.example.dto.EtiquetaEquipo
import org.example.dto.PersonalXmlDto
import org.example.exceptions.exceptions
import org.example.mapper.toModel
import org.example.models.Entrenador
import org.example.models.Personal
import org.example.storage.PersonalStorageFile
import java.io.File

class PersonalStorageXml: PersonalStorageFile {
    override fun readFromFile(file: File): List<Personal> {
        if (!file.exists() || !file.isFile || !file.canRead()) {
            throw exceptions.PersonalStorageException("El fichero no se puede leer, no es un fichero o no se ha encontrado")
        } else {
            val xml = XML {}
            val imprimirXml = file.readText()
            val equipoListDto = xml.decodeFromString<EtiquetaEquipo>(imprimirXml)
            val personalListDto = equipoListDto.equipo
            val listapersonalModel = personalListDto.map { it.toModel }


            return listaPersonalDto
        }
    }

    override fun writeToFile(personal: List<Personal>, file: File) {
        TODO("Not yet implemented")
    }

}
 */

