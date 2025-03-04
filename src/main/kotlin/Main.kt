package org.example

import kotlinx.serialization.json.Json
import org.example.models.Personal
import org.example.storage.PersonalStorageJson
import java.io.File
import org.example.cache.CacheLRU
import org.example.exceptions.exceptions
import org.example.models.Jugador
import org.example.repository.PersonalRepository
import org.example.service.PersonalService
import org.example.storage.PersonalStorageControlador
import org.lighthousegames.logging.logging
import java.nio.file.Paths


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


val personalCache = CacheLRU<Int, Personal>(5)
fun generarId(): Int {
    return personalCache.listAll().size + 1
}
fun main() {

    val logger = logging()
    /*while (true) {
        println("Menú de Gestión de Personal del Club:")
        println("1. Cargar datos desde fichero según la especificación indicada")
        println("2. Crear miembro del equipo")
        println("3. Actualizar miembro de equipo")
        println("4. Eliminar miembro del equipo")
        println("5. Copiar datos a fichero según la especificación realizada")
        println("6. Realizar consultas indicadas")
        println("7. Salir")
        print("Seleccione una opción: ")

        when (readln().toInt()) {
            1 -> cargarDatos()
            2 -> crearMiembro()
            3 -> actualizarMiembro()
            4 -> eliminarMiembro()
            5 -> copiarDatos()
            6 -> realizarConsultas()
            7 -> return
            else -> println("Opción no válida o inexistente.")
        }
    }

    // Ruta del archivo JSON
     val file = File("data", "personal.json")

    // Instanciamos la clase para leer el archivo

    /*val personalJson = PersonalStorageJson().readFromFile(file, "json")
    personalJson.forEach { println(Json.encodeToString(it)) }*/
}

fun cargarDatos() {
    println("Ingrese el tipo de fichero a cargar (csv, json o xml): ")
    val fileType = readln()
    val fileName = "data/personal.$fileType"

    when (fileType) {
        "csv" -> cargarDatosDesdeCsv(fileName)
        "json" -> cargarDatosDesdeJson(fileName)
        "xml" -> cargarDatosDesdeXml(fileName)
        else -> println("Tipo de fichero no soportado.")
    }
}
// Mírate esto Pablo, y toquetea lo que veas, aunque funciona a la perfección.
fun cargarDatosDesdeCsv(fileName: String) {
    val file = File(fileName)
    if (file.exists()) {
        file.forEachLine { line ->
            val data = line.split(",")
            try {
                val id = data[0].toInt()
                val personal: Personal = if (data[7] == "Entrenador") {
                    Entrenador(
                        id,
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5].toDouble(),
                        data[6],
                        Entrenador.Especializacion.valueOf(data[8])
                    )
                } else {
                    Jugador(
                        id,
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5].toDouble(),
                        data[6],
                        Jugador.Posicion.valueOf(data[9]),
                        data[10].toInt(),
                        data[11].toDouble(),
                        data[12].toDouble(),
                        data[13].toInt(),
                        data[14].toInt()
                    )
                }
                personalCache.put(id, personal)
            } catch (e: Exception) {
                println("Error procesando la línea: '$line'. Detalles: ${e.message}")
            }
        }
        println("Datos cargados desde $fileName.")
    } else {
        println("Fichero $fileName no encontrado.")
    }
}

// Este aún no es tan heavy y se podría dejar así o parecido.
/*fun cargarDatosDesdeCsv(fileName: String) {
    val file = File("data", "personal.json")
    if (file.exists()) {
        file.forEachLine { line ->
            val data = line.split(",")
            val id = data[0].toInt()
            val nombre = data[1]
            val apellidos = data[2]
            val fechaNacimiento = data[3]
            val fechaIncorporacion = data[4]
            val salario = data[5].toDouble()
            val pais = data[6]
            val rol = data[7]
            if (rol == "Entrenador") {
                val especializacion = Entrenador.Especializacion.valueOf(data[8])
                val entrenador = Entrenador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, especializacion)
                personalCache.put(id, entrenador)
            } else if (rol == "Jugador") {
                val posicion = Jugador.Posicion.valueOf(data[9])
                val dorsal = data[10].toInt()
                val altura = data[11].toDouble()
                val peso = data[12].toDouble()
                val goles = data[13].toInt()
                val partidosJugados = data[14].toInt()
                val jugador = Jugador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, posicion, dorsal, altura, peso, goles, partidosJugados)
                personalCache.put(id, jugador)
            }
        }
        println("Datos cargados desde $fileName.")
    } else {
        println("Fichero $fileName no encontrado.")
    }
}*/
// Imposible, no utilizar, solo para guiarse.
fun cargarDatosDesdeJson(fileName: String) {
    val file = File(fileName)
    if (file.exists()) {
        val jsonString = file.readText()
        val personalList = Json.decodeFromString<List<Personal>>(jsonString)
        for  (personal in personalList) {
            personalCache.put(personal.id, personal)
        }
        println("Datos cargados desde $fileName.")
    } else {
        println("Fichero $fileName no encontrado.")
    }
}

fun cargarDatosDesdeXml(fileName: String) {
    val file = File(fileName)
    if (file.exists()) {
        val xmlString = file.readText()
        val personalList = XML.decodeFromString<List<Personal>>(xmlString)
        for (personal in personalList) {
            personalCache.put(personal.id, personal)
        }
        println("Datos cargados desde $fileName")
    } else {
        println("Fichero $fileName no encontrado")
    }
}

fun crearMiembro() {
    println("Ingrese los datos del nuevo miembro:")
    print("Nombre: ")
    val nombre = readln()
    print("Apellidos: ")
    val apellidos = readln()
    print("Fecha de Nacimiento (YYYY-MM-DD): ")
    val fechaNacimiento = readln()
    print("Fecha de Incorporación (YYY-MM-DD): ")
    val fechaIncorporacion = readln()
    print("Salario: ")
    val salario = readln().toDouble()
    print("País: ")
    val pais = readln()

    print("Es Entrenador o Jugador?? (E/J): ")
    when (readln()) {
        "E" -> {
            print("Especializacion (ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL, ENTRENADOR_ASISTENTE): ")
            val especializacion = Entrenador.Especializacion.valueOf(readln())
            val id = generarId()
            val entrenador = Entrenador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, especializacion)
            personalCache.put(id, entrenador)
        }
        "J" -> {
            print("Posición (DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO): ")
            val posicion = Jugador.Posicion.valueOf(readln())
            print("Dorsal: ")
            val dorsal = readln().toInt()
            print("Altura: ")
            val altura = readln().toDouble()
            print("Peso: ")
            val peso = readln().toDouble()
            print("Goles: ")
            val goles = readln().toInt()
            print("Partidos Jugados: ")
            val partidosJugados = readln().toInt()
            val id = generarId()
            val jugador = Jugador(id, nombre, apellidos, fechaNacimiento, fechaIncorporacion, salario, pais, posicion, dorsal, altura, peso, goles, partidosJugados)
            personalCache.put(id, jugador)
        }
        else -> println("Opción no válida o inexistente.")
    }
}

fun actualizarMiembro() {
    print("Ingrese el ID del miembro a actualizar: ")
    val id = readln().toInt()
    val miembro = personalCache.get(id)
    if (miembro != null) {
        print("Nuevo nombre (${miembro.nombre}): ")
        miembro.nombre = readln()
        print("Nuevos apellidos (${miembro.apellidos}): ")
        miembro.apellidos = readln()
        print("Nueva fecha de nacimiento (${miembro.fechaNacimiento}): ")
        miembro.fechaNacimiento = readln()
        print("Nueva fecha de incorporación (${miembro.fechaIncorporacion}): ")
        miembro.fechaIncorporacion = readln()
        print("Nuevo salario (${miembro.salario}): ")
        miembro.salario = readln().toDouble()
        print("Nuevo país (${miembro.pais}): ")
        miembro.pais = readln()
        if (miembro is Entrenador) {
            print("Nueva especialización (ENTRENADOR_PORTEROS, ENTRENADOR_PRINCIPAL, ENTRENADOR_ASISTENTE): ")
            miembro.especializacion = Entrenador.Especializacion.valueOf(readln())
        } else if (miembro is Jugador) {
            print("Nueva posición (DEFENSA, CENTROCAMPISTA, DELANTERO, PORTERO): ")
            miembro.posicion = Jugador.Posicion.valueOf(readln())
            print("Nuevo dorsal: ")
            miembro.dorsal = readln().toInt()
            print("Nueva altura: ")
            miembro.altura = readln().toDouble()
            print("Nuevo peso: ")
            miembro.peso = readln().toDouble()
            print("Nuevos goles: ")
            miembro.goles = readln().toInt()
            print("Nuevos partidos jugados: ")
            miembro.partidosJugados = readln().toInt()
        }
        personalCache.put(id, miembro)
    } else {
        println("Miembro no encontrado")
    }
}

fun eliminarMiembro() {
    print("Ingrese el ID del miembro a eliminar: ")
    val id = readln().toInt()
    personalCache.remove(id)
}

fun copiarDatos() {
    print("Ingrese el tipo de fichero a guardar (csv, json, xml): ")
    val fileType = readln()
    val fileName = "personal.$fileType"

    when (fileType) {
        "csv" -> guardarDatosEnCsv(fileName)
        "json" -> guardarDatosEnJson(fileName)
        //"xml" -> guardarDatosEnXml(fileName)
        else -> println("Tipo de fichero no soportado.")
    }
}
// Averiguar como funciona o como hacerlo de otra manera.
fun guardarDatosEnCsv(fileName: String) {
    val file = File(fileName)
    file.printWriter().use { out ->
        personalCache.listAll().forEach { personal ->
            when (personal) {
                is Entrenador -> out.println("${personal.id},${personal.nombre},${personal.apellidos},${personal.fechaNacimiento},${personal.fechaIncorporacion},${personal.salario},${personal.pais},Entrenador,${personal.especializacion},,,,")
                is Jugador -> out.println("${personal.id},${personal.nombre},${personal.apellidos},${personal.fechaNacimiento},${personal.fechaIncorporacion},${personal.salario},${personal.pais},Jugador,,${personal.posicion},${personal.dorsal},${personal.altura},${personal.peso},${personal.goles},${personal.partidosJugados}")
            }
        }
    }
    println("Datos guardados en $fileName.")
}
// Averiguar como funciona o como hacerlo de otra manera.
fun guardarDatosEnJson(fileName: String) {
    val file = File(fileName)
    file.writeText(Json.encodeToString(personalCache.listAll()))
    println("Datos guardados en $fileName.")
}
/*
// MIRAR SERIAMENTE ESTO
fun guardarDatosEnXml(fileName: String) {
    val file = File(fileName)
    val dbFactory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
    val dBuilder: DocumentBuilder = dbFactory.newDocumentBuilder()
    val doc: Document = dBuilder.newDocument()

    val rootElement: Element = doc.createElement("equipo")
    doc.appendChild(rootElement)

    personalCache.listAll().forEach { personal ->
        val personalElement: Element = doc.createElement("personal")
        personalElement.setAttribute("id", personal.id.toString())
        rootElement.appendChild(personalElement)

        val tipoElement: Element = doc.createElement("tipo")
        tipoElement.appendChild(doc.createTextNode(if (personal is Entrenador) "Entrenador" else "Jugador"))
        personalElement.appendChild(tipoElement)

        val nombreElement: Element = doc.createElement("nombre")
        nombreElement.appendChild(doc.createTextNode(personal.nombre))
        personalElement.appendChild(nombreElement)

        val apellidosElement: Element = doc.createElement("apellidos")
        apellidosElement.appendChild(doc.createTextNode(personal.apellidos))
        personalElement.appendChild(apellidosElement)

        val fechaNacimientoElement: Element = doc.createElement("fechaNacimiento")
        fechaNacimientoElement.appendChild(doc.createTextNode(personal.fechaNacimiento))
        personalElement.appendChild(fechaNacimientoElement)

        val fechaIncorporacionElement: Element = doc.createElement("fechaIncorporacion")
        fechaIncorporacionElement.appendChild(doc.createTextNode(personal.fechaIncorporacion))
        personalElement.appendChild(fechaIncorporacionElement)

        val salarioElement: Element = doc.createElement("salario")
        salarioElement.appendChild(doc.createTextNode(personal.salario.toString()))
        personalElement.appendChild(salarioElement)

        val paisElement: Element = doc.createElement("pais")
        paisElement.appendChild(doc.createTextNode(personal.pais))
        personalElement.appendChild(paisElement)

        if (personal is Entrenador) {
            val especialidadElement: Element = doc.createElement("especialidad")
            especialidadElement.appendChild(doc.createTextNode(personal.especializacion.name))
            personalElement.appendChild(especialidadElement)
        } else if (personal is Jugador) {
            val posicionElement: Element = doc.createElement("posicion")
            posicionElement.appendChild(doc.createTextNode(personal.posicion.name))
            personalElement.appendChild(posicionElement)

            val dorsalElement: Element = doc.createElement("dorsal")
            dorsalElement.appendChild(doc.createTextNode(personal.dorsal.toString()))
            personalElement.appendChild(dorsalElement)

            val alturaElement: Element = doc.createElement("altura")
            alturaElement.appendChild(doc.createTextNode(personal.altura.toString()))
            personalElement.appendChild(alturaElement)

            val pesoElement: Element = doc.createElement("peso")
            pesoElement.appendChild(doc.createTextNode(personal.peso.toString()))
            personalElement.appendChild(pesoElement)

            val golesElement: Element = doc.createElement("goles")
            golesElement.appendChild(doc.createTextNode(personal.goles.toString()))
            personalElement.appendChild(golesElement)

            val partidosJugadosElement: Element = doc.createElement("partidosJugados")
            partidosJugadosElement.appendChild(doc.createTextNode(personal.partidosJugados.toString()))
            personalElement.appendChild(partidosJugadosElement)
        }
    }

    val transformerFactory = TransformerFactory.newInstance()
    val transformer = transformerFactory.newTransformer()
    val source = DOMSource(doc)
    val result = StreamResult(file)
    transformer.transform(source, result)

    println("Datos guardados en $fileName")
}*/

fun realizarConsultas() {
    println("Seleccione la consulta a realizar:")
    println("1. Listados de personal agrupados por entrenadores y jugadores")
    println("2. El delantero más alto")
    println("3. Media de goles de los delanteros")
    println("4. Defensa con más partidos jugados")
    println("5. Jugadores agrupados por su país de origen")
    println("6. Entrenador con el mayor salario")
    println("7. Promedio de altura de los jugadores agrupados por posición")
    println("8. Listado de todos los jugadores que han anotado más de 10 goles")
    println("9. Jugadores con un salario mayor al promedio del equipo")
    println("10. Número total de partidos jugados por todos los jugadores")
    println("11. Jugadores agrupados por el año de su incorporación al club")
    println("12. Entrenadores agrupados por su especialidad")
    println("13. Jugador más joven en el equipo")
    println("14. Promedio de peso de los jugadores por posición")
    println("15. Listado de todos los jugadores que tienen un dorsal par")
    println("16. Jugadores que han jugado menos de 5 partidos")
    println("17. Media de goles por partido de cada jugador")
    println("18. Listado de jugadores que tienen una altura superior a la media del equipo")
    println("19. Entrenadores que se incorporaron al club en los últimos 5 años")
    println("20. Jugadores que han anotado más goles que el promedio de su posición")
    println("21. Por posición, máximo de goles, mínimo de goles y media")
    println("22. Estimación del coste total de la plantilla")
    println("23. Total del salario pagado, agrupados por año de incorporación")
    println("24. Jugadores agrupados por país y, dentro de cada grupo, el jugador con más partidos jugados")
    println("25. Promedio de goles por posición, y dentro de cada posición, el jugador con el mayor número de goles")
    println("26. Entrenadores agrupados por especialidad, y dentro de cada especialidad, el entrenador con el salario más alto")
    println("27. Jugadores agrupados por década de nacimiento, y dentro de cada grupo, el promedio de partidos jugados")
    println("28. Salario promedio de los jugadores agrupados por su país de origen, y dentro de cada grupo, el jugador con el salario más bajo y alto")
    print("Seleccione una consulta a realizar: ")

    when (readln().toInt()) {
        1 -> consultaListadosPersonal()
        2 -> consultaDelanteroMasAlto()
        3 -> consultaMediaGolesDelanteros()
        4 -> consultaDefensaMasPartidos()
        5 -> consultaJugadoresPorPais()
        6 -> consultaEntrenadorMayorSalario()
        7 -> consultaPromedioAlturaPorPosicion()
        8 -> consultaJugadoresMasDe10Goles()
        9 -> consultaJugadoresSalarioMayorPromedio()
        10 -> consultaTotalPartidosJugados()
        11 -> consultaJugadoresPorAnioIncorporacion()
        12 -> consultaEntrenadoresPorEspecialidad()
        13 -> consultaJugadorMasJoven()
        14 -> consultaPromedioPesoPorPosicion()
        15 -> consultaJugadoresDorsalPar()
        16 -> consultaJugadoresMenosDe5Partidos()
        17 -> consultaMediaGolesPorPartido()
        18 -> consultaJugadoresAlturaSuperiorMedia()
        19 -> consultaEntrenadoresUltimos5Anios()
        20 -> consultaJugadoresMasGolesQuePromedioPosicion()
        21 -> consultaMaxMinMediaGolesPorPosicion()
        22 -> consultaEstimacionCosteTotalPlantilla()
        23 -> consultaSalarioTotalPorAnioIncorporacion()
        24 -> consultaJugadoresPorPaisYMasPartidos()
        25 -> consultaPromedioGolesPorPosicionYMasGoles()
        26 -> consultaEntrenadoresPorEspecialidadYMayorSalario()
        27 -> consultaJugadoresPorDecadaNacimientoYPromedioPartidos()
        28 -> consultaSalarioPromedioPorPaisYSalarioExtremos()
        else -> println("Opción no válida o inexistente.")
    }
}
    val file2 : File = File("data", "personal.xml")

    // Instanciamos la clase para leer el xml
     val personalXml = PersonalStorageXml<Personal>().readFromFile(file2, "xml")

    try {
        val file2 : File = File("data", "personal.xml")
        val personalXml = PersonalStorageXml<Personal>().readFromFile(file2, "xml")

    } catch (e : Exception) {
        println(e)

    }

/*fun consultaListadosPersonal() {
    println("Entrenadores:")
    personalCache.listAll().filterIsInstance<Entrenador>().forEach { println(it) }
    println("Jugadores:")
    personalCache.listAll().filterIsInstance<Jugador>().forEach { println(it) }
}*/

fun consultaListadosPersonal() {
    println("Entrenadores:")
    val entrenadores = personalCache.listAll().filterIsInstance<Entrenador>()
    for (entrenador in entrenadores) {
        println(entrenador)
    }

    println("Jugadores:")
    val jugadores = personalCache.listAll().filterIsInstance<Jugador>()
    for (jugador in jugadores) {
        println(jugador)
    }
}

fun consultaDelanteroMasAlto() {
    val delanteroMasAlto = personalCache.listAll().filterIsInstance<Jugador>().filter { it.posicion == Jugador.Posicion.DELANTERO }.maxByOrNull { it.altura }
    println("El delantero más alto es: $delanteroMasAlto")
}

fun consultaMediaGolesDelanteros() {
    val delanteros = personalCache.listAll().filterIsInstance<Jugador>().filter { it.posicion == Jugador.Posicion.DELANTERO }
    val mediaGoles = delanteros.map { it.goles }.average()
    println("La media de goles de los delanteros es: $mediaGoles")
}

fun consultaDefensaMasPartidos() {
    val defensaMasPartidos = personalCache.listAll().filterIsInstance<Jugador>().filter { it.posicion == Jugador.Posicion.DEFENSA }.maxByOrNull { it.partidosJugados }
    println("El defensa con más partidos jugados es: $defensaMasPartidos")
}

fun consultaJugadoresPorPais() {
    val jugadoresPorPais = personalCache.listAll().filterIsInstance<Jugador>().groupBy { it.pais }
    jugadoresPorPais.forEach { (pais, jugadores) ->
        println("Jugadores de $pais:")
        jugadores.forEach { println(it) }
    }
}

fun consultaEntrenadorMayorSalario() {
    val entrenadorMayorSalario = personalCache.listAll().filterIsInstance<Entrenador>().maxByOrNull { it.salario }
    println("El entrenador con el mayor salario es: $entrenadorMayorSalario")
}

fun consultaPromedioAlturaPorPosicion() {
    val jugadoresPorPosicion = personalCache.listAll().filterIsInstance<Jugador>().groupBy { it.posicion }
    jugadoresPorPosicion.forEach { (posicion, jugadores) ->
        val promedioAltura = jugadores.map { it.altura }.average()
        println("Promedio de altura de los $posicion es: $promedioAltura")
    }
}

fun consultaJugadoresMasDe10Goles() {
    val jugadoresMasDe10Goles = personalCache.listAll().filterIsInstance<Jugador>().filter { it.goles > 10 }
    println("Jugadores que han anotado más de 10 goles:")
    jugadoresMasDe10Goles.forEach { println(it) }
}

fun consultaJugadoresSalarioMayorPromedio() {
    val jugadores = personalCache.listAll().filterIsInstance<Jugador>()
    val salarioPromedio = jugadores.map { it.salario }.average()
    val jugadoresSalarioMayorPromedio = jugadores.filter { it.salario > salarioPromedio }
    println("Jugadores con un salario mayor al promedio del equipo:")
    jugadoresSalarioMayorPromedio.forEach { println(it) }
}

fun consultaTotalPartidosJugados() {
    val totalPartidos = personalCache.listAll().filterIsInstance<Jugador>().sumOf { it.partidosJugados }
    println("Número total de partidos jugados por todos los jugadores: $totalPartidos")
}

fun consultaJugadoresPorAnioIncorporacion() {}

fun consultaEntrenadoresPorEspecialidad() {}

fun consultaJugadorMasJoven() {}

fun consultaPromedioPesoPorPosicion() {}

fun consultaJugadoresDorsalPar() {}

fun consultaJugadoresMenosDe5Partidos() {}

fun consultaMediaGolesPorPartido() {}

fun consultaJugadoresAlturaSuperiorMedia() {}

fun consultaEntrenadoresUltimos5Anios() {}

fun consultaJugadoresMasGolesQuePromedioPosicion() {}

fun consultaMaxMinMediaGolesPorPosicion() {}

fun consultaEstimacionCosteTotalPlantilla() {}

fun consultaSalarioTotalPorAnioIncorporacion() {}

fun consultaJugadoresPorPaisYMasPartidos() {}

fun consultaPromedioGolesPorPosicionYMasGoles() {}

fun consultaEntrenadoresPorEspecialidadYMayorSalario() {}

fun consultaJugadoresPorDecadaNacimientoYPromedioPartidos() {}

fun consultaSalarioPromedioPorPaisYSalarioExtremos() {}


   // Le indicamos la ruta del archivo
    val storage = PersonalStorageJson<Personal>()
    val file = File("data", "personal.json")

    // Le decimos que lea el archivo
    val personalList = storage.readFromFile(file, "json")
    personalList.forEach { println(it) }

     */


//    // LEER EL JSON
//    val storageJson = PersonalStorageJson()
//    val fileJson = File("data", "personal.json")
//
//    val personalList = storage.readFromFile(fileJson)
//    personalList.forEach { println(it) }


//    //SOBREESCRIBIR EL JSON
//    val nuevoJugador = Jugador(
//        id = 999L,
//        nombre = "Lucia",
//        apellidos = "Fuertes Cruz",
//        fechaNacimiento = "1987-06-24",
//        fechaIncorporacion = "2021-08-01",
//        salario = 500000.0,
//        pais = "Argentina",
//        rol = "Jugador",
//        posicion = Jugador.Posicion.DELANTERO,
//        dorsal = 10,
//        altura = 1.7,
//        peso = 72.0,
//        goles = 700,
//        partidosJugados = 900
//    )
//    val listaNuevoJugador = personalList + nuevoJugador
//    logger.debug { "Sobreescribiendo archivo Json..." }
//    storage.writeToFile(listaNuevoJugador, file)

//    //Leer caulquier tipo de archivos
//    val storage = PersonalStorageControlador()
//    val rutaArchivo = "data/-archivo-"
//    val file = File(rutaArchivo)
//    try {
//        val controlador = PersonalStorageControlador(file)
//
//    }catch(e:Exception){
//        println("Error al procesar el fcihero")
//    }

}