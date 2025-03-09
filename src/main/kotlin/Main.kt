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


/*
    // Leer Bin
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

    // 11. Jugadores agrupados por el año de su incorporacion al club -- hecha
    println("11. personal agrupado por el año de su incorporacion al club")
    personal.filterIsInstance<Jugador>().groupBy { it.fechaIncorporacion }.forEach { println(it) }
    println()

    // 12. Entrenadores agrupados por especialidad -- hecha
    println("12. Entrenadores agrupados por especialidad")
    personal.filterIsInstance<Entrenador>().groupBy { it.especialidad }.forEach { println(it) }
    println()

    // 13. Jugador más joven -- hecha
    println("13. Jugador mas joven")
    personal.filterIsInstance<Jugador>().minBy { it.fechaNacimiento }.also { println(it) }
    println()

    // 14. Promedio de peso de los jugadores por posición. -- por terminar
    println("14. Promedio de peso de los jugadores por posicion")
    personal.filterIsInstance<Jugador>().groupBy { it.posicion }
    println()


    // 15. Listado de todos los jugadores que tienen un dorsal par. -- hecha
    println("15. Jugadores con dorsal par")
    personal.filterIsInstance<Jugador>().filter { it.dorsal % 2 == 0 }.forEach { println(it) }
    println()

    // 16. Jugadores que han jugado menos de 5 partidos. -- hecha
    println("16. Jugadores que han jugado menos de 5 partidos")
    personal.filterIsInstance<Jugador>().filter { it.partidosJugados < 5 }.also { println(it) }
    println()

    // 17. Media de goles por partido de cada jugador. -- por hacer
    println("17.Media de goles por partido de cada jugador")
    personal.filterIsInstance<Jugador>().map { it.goles }.average().also { println(it) }

    println()
    //25. Promedio de goles por posición, y dentro de cada posición, el jugador con el mayor número de goles
    println(" Promedio de goles por posición, y dentro de cada posición, el jugador con el mayor número de goles")

    println()


    //26. Entrenadores agrupados por especialidad, y dentro de cada especialidad, el entrenador con el salario mas alto
    println("Entrenadores agrupados por especialidad, y dentro de cada especialidad, el entrenador con el salario mas alto")

    println()



    //18. Listado de jugadores que tienen una altura superior a la media del equipo.
    val jugadoresAltura = personal.filterIsInstance<Jugador>().map { it.altura }.average()
    println("18. La altura promedio de los jugadores es: $jugadoresAltura")
    println()

    //19. Entrenadores que se incorporaron al club en los últimos 5 años.
    val entrenadores5 = personal.filterIsInstance<Entrenador>().filter { it.fechaIncorporacion >= 2015.toString() }
    println("19. Los entrenadores que se han incorporado al club en los ultimos 5 años: $entrenadores5")
    println()

    //20. Jugadores que han anotado más goles que el promedio de su posición.
    val jugadorGolesPromedio = personal.filterIsInstance<Jugador>().map { it.goles }.average()
    val jugadorGolesMas = personal.filterIsInstance<Jugador>().filter { it.goles > jugadorGolesPromedio }.groupBy { it.posicion }
    println("Los jugadores que han anotado mas goles que el promedio de su posicion: $jugadorGolesMas")

    //21. Por posición, máximo de goles, mínimo de goles y media.
    val jugadorPosicion = personal.filterIsInstance<Jugador>().groupBy { it.posicion }
    val maxGoles = personal.filterIsInstance<Jugador>().maxBy { it.goles }
    val minGoles = personal.filterIsInstance<Jugador>().minBy { it.goles }
    println("Agrupacion de jugadores segun posicion: $jugadorPosicion, maximo de goles anotado por un jugador: $maxGoles, minimo de goles anotados por un jugador: $minGoles, media de goles anotados entre todos los jugadores: $jugadorGolesPromedio")

    //22. Estimación del coste total de la plantilla.
    val costeTotal = personal.sumBy { it.salario?.toInt() }
    println("Estimacion total del coste de la plantilla: $costeTotal")

    //23. Total del salario pagado, agrupados por año de incorporación.
    val salarioAgrupado = personal.groupBy { it.fechaIncorporacion }.mapValues { it.value.map { it.salario }.sumOf { it } }
    println("Total del salario agrupado por año de incorporacion: $salarioAgrupado")

    //24. Jugadores agrupados por país y, dentro de cada grupo, el jugador con más partidos jugados.
    val paisPartidos = personal.filterIsInstance<Jugador>().groupBy { it.pais }.mapValues { it.value.map{ it.partidosJugados }.maxBy { it }}
    println("Cantidad maxima de partidos jugados por un jugador agrupados por pais: $paisPartidos")

    //27. Jugadores agrupados por década de nacimiento, y dentro de cada grupo, el promedio de partidos jugados.


    //28. Salario promedio de los jugadores agrupados por su país de origen, y dentro de cada grupo, el jugador con el salario más bajo y alto
}