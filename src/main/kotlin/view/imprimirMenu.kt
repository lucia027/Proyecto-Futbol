package org.example.view

import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal
import org.example.repositories.PersonalRepositoryImpl
import org.example.storage.PersonalStorageCsv
import org.example.storage.PersonalStorageFile
import org.example.storage.PersonalStorageJson
import java.io.File

/**
 * Este archivo contiene funciones para gestionar el menú de operaciones de personal del club.
 * Incluye funciones para cargar datos, crear, actualizar, eliminar miembros, copiar datos y realizar consultas.
 */

fun imprimirMenu() {
    val personalRepository = PersonalRepositoryImpl()

    while (true) {
        println("*** Menú de Gestión de Personal del Club: ***")
        println("1. Cargar datos desde fichero según la especificación indicada")
        println("2. Crear miembro del equipo")
        println("3. Actualizar miembro de equipo")
        println("4. Eliminar miembro del equipo")
        println("5. Copiar datos a fichero según la especificación realizada")
        println("6. Realizar consultas indicadas")
        println("7. Salir")
        print("Selecciona una opción: ")

        when (readln().toInt()) {
            1 -> cargarDatos(personalRepository)
            2 -> crearMiembro(personalRepository)
            3 -> actualizarMiembro(personalRepository)
            4 -> eliminarMiembro(personalRepository)
            5 -> copiarDatos(personalRepository)
            6 -> realizarConsultas(personalRepository)
            7 -> return
            else -> println("Opción no válida o inexistente.")
        }
    }
}

/**
 * Carga datos desde un archivo y los guarda en el repositorio.
 *
 * @param personalRepository el repositorio donde se guardarán los datos.
 */
fun cargarDatos(personalRepository: PersonalRepositoryImpl) {
    println("Selecciona un formato de archivo para cargar de los siguientes: \n1. CSV \n2. JSON \n3. XML \n4. BIN")
    val formato = readln().toIntOrNull() ?: 0

    val filePath = when (formato) {
        1 -> "data/personal.csv"
        2 -> "data/personal.json"
        3 -> "data/personal.xml"
        4 -> "data/personal.bin"
        else -> {
            println("Formato inválido.")
            return
        }
    }

    val file = File(filePath)
    val storage: PersonalStorageFile = when (formato) {
        1 -> PersonalStorageCsv()
        2 -> PersonalStorageJson()
        //3 -> PersonalStorageXml()
        //4 -> PersonalStorageBin()
        else -> throw IllegalArgumentException("Formato insoportable.")
    }

    try {
        val personalList = storage.readFile(file).filterIsInstance<Personal>()
        personalList.forEach { personalRepository.save(it) }
        println("Datos cargados con éxito desde $filePath")
    } catch (e: Exception) {
        println("Error al cargar los datos: ${e.message}")
    }
}

/**
 * Actualiza los archivos de datos con el contenido del repositorio.
 *
 * @param personalRepository el repositorio que contiene los datos actualizados.
 */
fun actualizarArchivos(personalRepository: PersonalRepositoryImpl) {
    val formatos = listOf(
        "data/personal.csv" to PersonalStorageCsv(),
        "data/personal.json" to PersonalStorageJson(),
        //"data/personal.xml" to PersonalStorageXml(),
        //"data/personal.bin" to PersonalStorageBin()
    )

    formatos.forEach {(filePath, storage) ->
        val file = File(filePath)
        try {
            storage.writeFile(personalRepository.getAll(), file)
            println("Datos actaulizados con éxito en $filePath")
        } catch (e: Exception) {
            println("Error al actualizar datos en $filePath: ${e.message}")
        }
    }
}

/**
 * Crea un nuevo miembro del equipo y lo guarda en el repositorio.
 *
 * @param personalRepository el repositorio donde se guardará el nuevo miembro.
 */
fun crearMiembro(personalRepository: PersonalRepositoryImpl) {
    println("Selecciona el rol del miembro que vas a crear (jugador/entrenador):")
    val rol = readln().lowercase()

    val miembro: Personal = if (rol == "jugador") {
        println("Ingresa los datos del jugador:")
        print("Nombre: ")
        val nombre = readln()
        print("Apellidos: ")
        val apellidos  = readln()
        print("Fecha de Nacimiento (YYYY-MM-DD): ")
        val fechaNacimiento = readln()
        print("Fecha de Incorporación (YYYY-MM-DD): ")
        val fechaIncorporacion = readln()
        print("Salario: ")
        val  salario = readln().toDouble()
        print("País: ")
        val pais = readln()
        print("Posición (DELANTERO, CENTROCAMPISTA, DEFENSA, PORTERO): ")
        val posicion = Jugador.Posicion.valueOf(readln().uppercase())
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

        Jugador(
            id = 0L,
            nombre = nombre,
            apellidos = apellidos,
            fechaNacimiento = fechaNacimiento,
            fechaIncorporacion = fechaIncorporacion,
            salario = salario,
            pais = pais,
            rol = rol,
            posicion = posicion,
            dorsal = dorsal,
            altura = altura,
            peso = peso,
            goles = goles,
            partidosJugados = partidosJugados
        )
    } else if (rol == "entrenador") {
        println("Ingresa los datos del entrenador:")
        print("Nombre: ")
        val nombre = readln()
        print("Apellidos: ")
        val apellidos  = readln()
        print("Fecha de Nacimiento (YYYY-MM-DD): ")
        val fechaNacimiento = readln()
        print("Fecha de Incorporación (YYYY-MM-DD): ")
        val  fechaIncorporacion = readln()
        print("Salario: ")
        val salario = readln().toDouble()
        print("País: ")
        val pais = readln()
        print("Especialidad (ENTRENADOR_PRINCIPAL, ENTRENADOR_ASISTENTE, ENTRENADOR_PORTEROS): ")
        val especializacion = Entrenador.Especializacion.valueOf(readln().uppercase())

        Entrenador(
            id = 0L,
            nombre = nombre,
            apellidos = apellidos,
            fechaNacimiento = fechaNacimiento,
            fechaIncorporacion = fechaIncorporacion,
            salario = salario,
            pais = pais,
            rol = rol,
            especialidad = especializacion
        )
    } else {
        println("Rol inválido.")
        return
    }

    personalRepository.save(miembro)
    println("${rol.uppercase()} creado con éxito.")
    actualizarArchivos(personalRepository)
}

/**
 * Actualiza los datos de un miembro existente en el repositorio.
 *
 * @param personalRepository el repositorio que contiene el miembro a actualizar.
 */
fun actualizarMiembro(personalRepository: PersonalRepositoryImpl) {
    print("Ingresa el ID del miembro a actualizar: ")
    val id = readln().toLong()
    val miembro = personalRepository.getById(id)
    if  (miembro != null) {
        if (miembro is Jugador) {
            println("Actualizando datos del jugador:")
            print("Nuevo Nombre (${miembro.nombre}): ")
            miembro.nombre = readln().ifEmpty { miembro.nombre }
            print("Nuevos Apellidos (${miembro.apellidos}): ")
            miembro.apellidos = readln().ifEmpty { miembro.apellidos }
            print("Nueva Fecha de Nacimiento (YYYY-MM-DD) (${miembro.fechaNacimiento}): ")
            miembro.fechaNacimiento = readln().ifEmpty { miembro.fechaNacimiento }
            print("Nueva Fecha de Incorporación (YYYY-MM-DD) (${miembro.fechaIncorporacion}): ")
            miembro.fechaIncorporacion = readln().ifEmpty { miembro.fechaIncorporacion }
            print("Nuevo Salario (${miembro.salario}): ")
            miembro.salario = readln().toDoubleOrNull() ?: miembro.salario
            print("Nuevo País (${miembro.pais}): ")
            miembro.pais = readln().ifEmpty { miembro.pais }
            print("Nueva Posición (DELANTERO, CENTROCAMPISTA, DEFENSA, PORTERO) (${miembro.posicion}): ")
            miembro.posicion = readln().ifEmpty { miembro.posicion!!.name }.let { Jugador.Posicion.valueOf(it.uppercase()) }
            print("Nuevo Dorsal (${miembro.dorsal}): ")
            miembro.dorsal = readln().toIntOrNull() ?: miembro.dorsal
            print("Nueva Altura (${miembro.altura}): ")
            miembro.altura = readln().toDoubleOrNull() ?: miembro.altura
            print("Nuevo Peso (${miembro.peso}): ")
            miembro.peso = readln().toDoubleOrNull() ?: miembro.peso
            print("Nuevos Goles (${miembro.goles}): ")
            miembro.goles = readln().toIntOrNull() ?: miembro.goles
            print("Nuevos Partidos Jugados (${miembro.partidosJugados}): ")
            miembro.partidosJugados = readln().toIntOrNull() ?: miembro.partidosJugados
            personalRepository.update(id, miembro)
            println("Jugador actualizado correctamente.")
        } else if (miembro is Entrenador) {
            println("Actualizando datos del entrenador:")
            print("Nuevo Nombre (${miembro.nombre}): ")
            miembro.nombre = readln().ifEmpty { miembro.nombre }
            print("Nuevos Apellidos (${miembro.apellidos}): ")
            miembro.apellidos = readln().ifEmpty { miembro.apellidos }
            print("Nueva Fecha de Nacimiento (YYYY-MM-DD) (${miembro.fechaNacimiento}): ")
            miembro.fechaNacimiento = readln().ifEmpty { miembro.fechaNacimiento }
            print("Nueva Fecha de Incorporación (YYYY-MM-DD) (${miembro.fechaIncorporacion}): ")
            miembro.fechaIncorporacion = readln().ifEmpty { miembro.fechaIncorporacion }
            print("Nuevo Salario (${miembro.salario}): ")
            miembro.salario = readln().toDoubleOrNull() ?: miembro.salario
            print("Nuevo País (${miembro.pais}): ")
            miembro.pais = readln().ifEmpty { miembro.pais }
            print("Nueva Especialidad (ENTRENADOR_PRINCIPAL, ENTRENADOR_ASISTENTE, ENTRENADOR_PORTEROS) (${miembro.especialidad}): ")
            miembro.especialidad = readln().ifEmpty { miembro.especialidad!!.name }.let { Entrenador.Especializacion.valueOf(it.uppercase()) }
            personalRepository.update(id, miembro)
            println("Entrenador actualizado con éxito.")
        }
        actualizarArchivos(personalRepository)
    } else {
        println("Miembro no encontrado.")
    }
}

/**
 * Elimina un miembro del repositorio y actualiza los archivos.
 *
 * @param personalRepository el repositorio que contiene el miembro a eliminar.
 */
fun eliminarMiembro(personalRepository: PersonalRepositoryImpl) {
    print("Ingresa el ID del miembro a eliminar: ")
    val id = readln().toLong()
    val miembro = personalRepository.delete(id)
    if (miembro != null) {
        println("Miembro eliminado con éxito.")
        actualizarArchivos(personalRepository)
    } else {
        println("Miembro no encontrado.")
    }
}

/**
 * Copia los datos del repositorio a un archivo en el formato especificado.
 *
 * @param personalRepository el repositorio que contiene los datos a copiar.
 */
fun copiarDatos(personalRepository: PersonalRepositoryImpl) {
    println("Selecciona el formato del archivo para copiar: \n1. CSV \n2. JSON \n3. XML \n4. BIN")
    val formato = readln().toIntOrNull() ?: 0

    val filePath = when (formato) {
        1 -> "data/personal_copy.csv"
        2 -> "data/personal_copy.json"
        3 -> "data/personal_copy.xml"
        4 -> "data/personal_copy.bin"
        else -> {
            println("Formato inválido.")
            return
        }
    }

    val file = File(filePath)
    val storage: PersonalStorageFile = when (formato) {
        1 -> PersonalStorageCsv()
        2 -> PersonalStorageJson()
        // Descomentar una vez creadas en 'storage'.
        //3 -> PersonalStorageXml()
        //4 -> PersonalStorageBin()
        else -> throw IllegalArgumentException("Formato insoportable.")
    }

    try {
        val listaPersonal = personalRepository.getAll()
        storage.writeFile(listaPersonal, file)
        println("Datos copiados con éxito a $filePath.")
    } catch (e: Exception) {
        println("Error al copiar los datos: ${e.message}")
    }
}

/**
 * Realiza una consulta específica sobre los datos del repositorio.
 *
 * @param personalRepository el repositorio que contiene los datos a consultar.
 */
fun realizarConsultas(personalRepository: PersonalRepositoryImpl) {
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

    when (readln().toIntOrNull() ?: 0) {
        1 -> consultaListadosPersonal(personalRepository)
        2 -> consultaDelanteroMasAlto(personalRepository)
        3 -> consultaMediaGolesDelanteros(personalRepository)
        4 -> consultaDefensaMasPartidos(personalRepository)
        5 -> consultaJugadoresPorPais(personalRepository)
        6 -> consultaEntrenadorMayorSalario(personalRepository)
        7 -> consultaPromedioAlturaPorPosicion(personalRepository)
        8 -> consultaJugadoresMasDe10Goles(personalRepository)
        9 -> consultaJugadoresSalarioMayorPromedio(personalRepository)
        10 -> consultaTotalPartidosJugados(personalRepository)
        11 -> consultaJugadoresPorAnioIncorporacion(personalRepository)
        12 -> consultaEntrenadoresPorEspecialidad(personalRepository)
        13 -> consultaJugadorMasJoven(personalRepository)
        14 -> consultaPromedioPesoPorPosicion(personalRepository)
        15 -> consultaJugadoresDorsalPar(personalRepository)
        16 -> consultaJugadoresMenosDe5Partidos(personalRepository)
        17 -> consultaMediaGolesPorPartido(personalRepository)
        18 -> consultaJugadoresAlturaSuperiorMedia(personalRepository)
        19 -> consultaEntrenadoresUltimos5Anios(personalRepository)
        20 -> consultaJugadoresMasGolesQuePromedioPosicion(personalRepository)
        // 21 -> consultaMaxMinMediaGolesPorPosicion(personalRepository)
        22 -> consultaEstimacionCosteTotalPlantilla(personalRepository)
        23 -> consultaSalarioTotalPorAnioIncorporacion(personalRepository)
        24 -> consultaJugadoresPorPaisYMasPartidos(personalRepository)
        // 25 -> consultaPromedioGolesPorPosicionYMasGoles(personalRepository)
        // 26 -> consultaEntrenadoresPorEspecialidadYMayorSalario(personalRepository)
        // 27 -> consultaJugadoresPorDecadaNacimientoYPromedioPartidos(personalRepository)
        // 28 -> consultaSalarioPromedioPorPaisYSalarioExtremos(personalRepository)
        else -> println("Opción inválida o inexistente.")
    }
}

fun consultaListadosPersonal(personalRepository: PersonalRepositoryImpl) {
    val jugadores = personalRepository.getAll().filterIsInstance<Jugador>()
    val entrenadores = personalRepository.getAll().filterIsInstance<Entrenador>()
    println("Jugadores:")
    jugadores.forEach { println(it) }
    println("Entrenadores:")
    entrenadores.forEach { println(it) }
}

fun consultaDelanteroMasAlto(personalRepository: PersonalRepositoryImpl) {
    val delanteroMasAlto = personalRepository.getAll().filterIsInstance<Jugador>().filter { it.posicion == Jugador.Posicion.DELANTERO }.maxByOrNull { it.altura!! }
    println("El delantero más alto es: $delanteroMasAlto")
}

fun consultaMediaGolesDelanteros(personalRepository: PersonalRepositoryImpl) {
    val delanteros = personalRepository.getAll().filterIsInstance<Jugador>().filter { it.posicion == Jugador.Posicion.DELANTERO }
    val mediaGoles = delanteros.map { it.goles }.average()
    println("La media de goles de los delanteros es: $mediaGoles")
}

fun consultaDefensaMasPartidos(personalRepository: PersonalRepositoryImpl) {
    val defensaMasPartidos = personalRepository.getAll().filterIsInstance<Jugador>().filter { it.posicion == Jugador.Posicion.DEFENSA }.maxByOrNull { it.partidosJugados }
    println("El defensa con más partidos jugados es: $defensaMasPartidos")
}

fun consultaJugadoresPorPais(personalRepository: PersonalRepositoryImpl) {
    val jugadoresPorPais = personalRepository.getAll().filterIsInstance<Jugador>().groupBy { it.pais }
    jugadoresPorPais.forEach { (pais, jugadores) ->
        println("País: $pais")
        jugadores.forEach { println(it) }
    }
}

fun consultaEntrenadorMayorSalario(personalRepository: PersonalRepositoryImpl) {
    val entrenadorMayorSalario = personalRepository.getAll().filterIsInstance<Entrenador>().maxByOrNull { it.salario!! }
    println("El entrenador con el mayor salario es: $entrenadorMayorSalario")
}

fun consultaPromedioAlturaPorPosicion(personalRepository: PersonalRepositoryImpl) {
    val jugadores = personalRepository.getAll().filterIsInstance<Jugador>()
    val promedioAlturaPorPosicion = jugadores.groupBy { it.posicion }.mapValues { it.value.map { jugador -> jugador.altura!! }.average() }
    promedioAlturaPorPosicion.forEach { (posicion, promedioAltura) ->
        println("Posición: $posicion, Promedio de altura: $promedioAltura")
    }
}

fun consultaJugadoresMasDe10Goles(personalRepository: PersonalRepositoryImpl) {
    val jugadoresMasDe10Goles = personalRepository.getAll().filterIsInstance<Jugador>().filter { it.goles > 10 }
    println("Jugadores con más de 10 goles:")
    jugadoresMasDe10Goles.forEach { println(it) }
}

fun consultaJugadoresSalarioMayorPromedio(personalRepository: PersonalRepositoryImpl) {
    val jugadores = personalRepository.getAll().filterIsInstance<Jugador>()
    val salarioPromedio = jugadores.map { it.salario!! }.average()
    val jugadoresSalarioMayorPromedio = jugadores.filter { it.salario!! > salarioPromedio }
    println("Jugadores con un salario mayor al promedio:")
    jugadoresSalarioMayorPromedio.forEach { println(it) }
}

fun consultaTotalPartidosJugados(personalRepository: PersonalRepositoryImpl) {
    val totalPartidosJugados = personalRepository.getAll().filterIsInstance<Jugador>().sumOf { it.partidosJugados }
    println("Número total de partidos jugados por todos los jugadores: $totalPartidosJugados")
}

fun consultaJugadoresPorAnioIncorporacion(personalRepository: PersonalRepositoryImpl) {
    personalRepository.getAll().filterIsInstance<Jugador>().groupBy { it.fechaIncorporacion }.forEach { println(it) }
}

fun consultaEntrenadoresPorEspecialidad(personalRepository: PersonalRepositoryImpl) {
    personalRepository.getAll().filterIsInstance<Entrenador>().groupBy { it.especialidad }.forEach { println(it) }
}

fun consultaJugadorMasJoven(personalRepository: PersonalRepositoryImpl) {
    personalRepository.getAll().filterIsInstance<Jugador>().groupBy { it.fechaNacimiento }.also { println(it) }
}

fun consultaPromedioPesoPorPosicion(personalRepository: PersonalRepositoryImpl) {
    personalRepository.getAll().filterIsInstance<Jugador>().map { it.peso }
}

fun consultaJugadoresDorsalPar(personalRepository: PersonalRepositoryImpl) {
    personalRepository.getAll().filterIsInstance<Jugador>().filter { it.dorsal!! %2 == 0 }.forEach { println(it) }
}

fun consultaJugadoresMenosDe5Partidos(personalRepository: PersonalRepositoryImpl) {
    personalRepository.getAll().filterIsInstance<Jugador>().filter { it.partidosJugados < 5 }.also { println(it) }
}

fun consultaMediaGolesPorPartido(personalRepository: PersonalRepositoryImpl) {
    personalRepository.getAll().filterIsInstance<Jugador>().groupBy { it.goles }
}

fun consultaJugadoresAlturaSuperiorMedia(personalRepository: PersonalRepositoryImpl) {
    val jugadoresAltura = personalRepository.getAll().filterIsInstance<Jugador>().map { it.altura!! }.average()
    println("La altura promedio de los jugadores es: $jugadoresAltura")
}

fun consultaEntrenadoresUltimos5Anios(personalRepository: PersonalRepositoryImpl) {
    val entrenadores5 = personalRepository.getAll().filterIsInstance<Entrenador>().filter { it.fechaIncorporacion >= 2015.toString() }
    println("Los entrenadores que se han incorporado al club en los últimos 5 años: $entrenadores5")
}

fun consultaJugadoresMasGolesQuePromedioPosicion(personalRepository: PersonalRepositoryImpl) {
    val jugadorGolesPromedio = personalRepository.getAll().filterIsInstance<Jugador>().map { it.goles }.average()
    val jugadorGolesMas = personalRepository.getAll().filterIsInstance<Jugador>().filter { it.goles > jugadorGolesPromedio }.groupBy { it.posicion }
    println("Los jugadores que han anotado mas goles que el promedio de su position: $jugadorGolesMas")
}

/*fun consultaMaxMinMediaGolesPorPosicion(personalRepository: PersonalRepositoryImpl) {
    val jugadorPosicion = personalRepository.getAll().filterIsInstance<Jugador>().groupBy { it.posicion }
    val maxGoles = personalRepository.getAll().filterIsInstance<Jugador>().maxBy { it.goles }
    val minGoles = personalRepository.getAll().filterIsInstance<Jugador>().minBy { it.goles }
    println("Agrupación de jugadores según posición: $jugadorPosicion, máximo de goles anotado por un jugador: $maxGoles, mínimo de goles anotados por un jugador: $minGoles, media de goles anotados entre todos los jugadores: $jugadorGolesPromedio")
}*/

fun consultaEstimacionCosteTotalPlantilla(personalRepository: PersonalRepositoryImpl) {
    val costeTotal = personalRepository.getAll().sumOf { it.salario!!.toInt() }
    println("Estimación total del coste de la plantilla: $costeTotal")
}
// En esta consulta hay un error, quien lo haya hecho y sepa porqué, que lo arregle plis
fun consultaSalarioTotalPorAnioIncorporacion(personalRepository: PersonalRepositoryImpl) {
    val salarioAgrupado = personalRepository.getAll().groupBy { it.fechaIncorporacion }.mapValues { it.value.map { it.salario!! }.sumOf { it } }
    println("Total del salario agrupado por año de incorporation: $salarioAgrupado")
}

fun consultaJugadoresPorPaisYMasPartidos(personalRepository: PersonalRepositoryImpl) {
    val paisPartidos = personalRepository.getAll().filterIsInstance<Jugador>().groupBy { it.pais }.mapValues { it.value.map{ it.partidosJugados }.maxBy { it }}
    println("Cantidad máxima de partidos jugados por un jugador agrupados por país: $paisPartidos")
}

//fun consultaPromedioGolesPorPosicionYMasGoles(personalRepository: PersonalRepositoryImpl) {}

//fun consultaEntrenadoresPorEspecialidadYMayorSalario(personalRepository: PersonalRepositoryImpl) {}

//fun consultaJugadoresPorDecadaNacimientoYPromedioPartidos(personalRepository: PersonalRepositoryImpl) {}

//fun consultaSalarioPromedioPorPaisYSalarioExtremos(personalRepository: PersonalRepositoryImpl) {}
