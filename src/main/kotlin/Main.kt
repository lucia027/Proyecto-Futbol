package org.example

import PersonalServiceImpl
import org.example.models.Personal
import org.example.storage.PersonalStorageJson
import java.io.File
import org.example.exceptions.exceptions
import org.example.models.Jugador
import org.example.service.PersonalService
import org.example.storage.PersonalStorageCsv
import org.example.cache.CacheImpl
import org.example.config.Config
import org.example.models.Entrenador
import org.example.storage.FileFormat
//import org.example.storage.PersonalStorageControlador
import org.lighthousegames.logging.logging
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.pathString


/*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import nl.adaptivity.xmlutil.dom2.Document
import nl.adaptivity.xmlutil.serialization.XML
import org.example.cache.CacheLRU
import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal
/*import org.example.storage.PersonalStorageJson*/
import nl.adaptivity.xmlutil.serialization.XML
import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal
import org.example.storage.storage.PersonalStorageXml
//import org.example.storage.storage.PersonalStorageXml
// import org.example.storage.storage.EntrenadorStorageJson
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
*/

fun main() {

    val logger = logging()



    /*
   // LEER EL JSON
   val storageJson = PersonalStorageJson()
   val fileJson = File("data", "personal.json")

   val personalList = storageJson.readFile(fileJson)
   personalList.forEach { println(it) }
     */


   //SOBREESCRIBIR EL JSON
    /*
    val nuevoJugadorJson = Jugador(
        id = 41,
        nombre = "Lucia",
        apellidos = "Fuertes Cruz",
        fechaNacimiento = "1987-06-24",
        fechaIncorporacion = "2021-08-01",
        salario = 500000.0,
        pais = "Argentina",
        rol = "Jugador",
        posicion = Jugador.Posicion.DELANTERO,
        dorsal = 10,
        altura = 1.7,
        peso = 72.0,
        goles = 7000,
        partidosJugados = 9000
    )
    val listaNuevoJugadorJson = personalList + nuevoJugadorJson
    logger.debug { "Sobreescribiendo archivo Json..." }

    storageJson.writeToFile(listaNuevoJugadorJson, fileJson)
     */

//    //Leer cualquier tipo de archivos
//    val storage = PersonalStorageControlador()
//    val rutaArchivo = "data/-archivo-"
//    val file = File(rutaArchivo)
//    try {
//        val controlador = PersonalStorageControlador(file)
//
//    } catch(e:Exception){
//        println("Error al procesar el fichero")
//    }

    //storage.writeToFile(listaNuevoJugador, file)


    // LEER EL XML
    /*
    val fileXML = File("data", "personal.xml")
    val equipoXML = storage.readFromFile(fileXML)
    equipoXML.forEach { println(it) }
    */

    /*
    // Leer CSV
    val storageCSV = PersonalStorageCsv()
    val fileCsv = File("data", "personal.csv")

    val personalListCsv = storageCSV.readFile(fileCsv)
    personalList.forEach { println(it) }
     */


   //SOBREESCRIBIR EL CSV
    /*
    val nuevoJugador = Jugador(
        id = 999L,
        nombre = "Lucia",
        apellidos = "Fuertes Cruz",
        fechaNacimiento = "1987-06-24",
        fechaIncorporacion = "2021-08-01",
        salario = 500000.0,
        pais = "Argentina",
        rol = "Jugador",
        posicion = Jugador.Posicion.DELANTERO,
        dorsal = 10,
        altura = 1.7,
        peso = 72.0,
        goles = 700,
        partidosJugados = 900
    )
    val listaNuevoJugador = personalList + nuevoJugador
    logger.debug { "Sobreescribiendo archivo Csv..." }
    storageCSV.writeToFile(listaNuevoJugador, fileCsv)
     */


  /*  // Leer Bin
    val storageBin = PersonalStorageBin()
    val fileBin = File("data", "personal.bin")

    val personalListBin = storageBin.readFile(fileBin)
    personalList.forEach { println(it) }


    //SOBREESCRIBIR EL BIN
    val nuevoJugador = Jugador(
        id = 999L,
        nombre = "Lucia",
        apellidos = "Fuertes Cruz",
        fechaNacimiento = "1987-06-24",
        fechaIncorporacion = "2021-08-01",
        salario = 500000.0,
        pais = "Argentina",
        rol = "Jugador",
        posicion = Jugador.Posicion.DELANTERO,
        dorsal = 10,
        altura = 1.7,
        peso = 72.0,
        goles = 700,
        partidosJugados = 900
    )
    val listaNuevoJugador = personalList + nuevoJugador
    logger.debug { "Sobreescribiendo archivo Bin..." }
    storageBin.writeFile(listaNuevoJugador, fileBin)

   */

    val service = PersonalServiceImpl()
    val personalImport = Path.of(Config.configProperties.dataDir, "personal.csv")
    service.importFile(
        personalImport.pathString, FileFormat.CSV)

    // Obtenemos todo el personal
    println()
    val personal = service.getAll()
    personal.forEach { println(it) }
    println()

    // 11. Jugadores agrupados por el año de su incorporacion al club
    println("personal agrupado por el año de su incorporacion al club")
    personal.filterIsInstance<Jugador>().groupBy { it.fechaIncorporacion }.forEach { println(it) }
    println()

    // 12. Entrenadores agrupados por especialidad
    println("Entrenadores agrupados por especialidad")
    personal.filterIsInstance<Entrenador>().groupBy { it.especialidad }.forEach { println(it) }

    // 13. Jugador mas joven
    println("Jugador mas joven")
    personal.filterIsInstance<Jugador>().groupBy { it.fechaNacimiento }.also { println(it) }

    // 14. Promedio de peso de los jugadores por posición.
    println("Promedio de peso de los jugadores por posicion")
    personal.filterIsInstance<Jugador>().map { it.peso }


    // 15. Listado de todos los jugadores que tienen un dorsal par.
    println("Jugadores con dorsal par")
    personal.filterIsInstance<Jugador>().filter { it.dorsal %2 == 0 }.forEach { println(it) }

    // 16. Jugadores que han jugado menos de 5 partidos.
    println("Jugadores que han jugado menos de 5 partidos")
    personal.filterIsInstance<Jugador>().filter { it.partidosJugados < 5 }.also { println(it) }

    // 17. Media de goles por partido de cada jugador.
    println("Media de goles por partido de cada jugador")
    personal.filterIsInstance<Jugador>().groupBy { it.goles }



}