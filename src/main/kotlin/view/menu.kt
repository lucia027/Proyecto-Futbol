package org.example.view

import org.example.models.Entrenador
import org.example.models.Jugador
import org.example.models.Personal
import org.example.repositories.PersonalRepositoryImpl
import org.example.storage.PersonalStorageCsv
import org.example.storage.PersonalStorageFile
import org.example.storage.PersonalStorageJson
import java.io.File

fun menu() {
    val personalRepository = PersonalRepositoryImpl()

    while (true) {
        println("Menú de Gestión de Personal del Club:")
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

fun crearMiembro(personalRepository: PersonalRepositoryImpl) {
    println("Selecciona el rol del miembro que vas a crear (jugador/entrenador):")
    val rol = readln().lowercase()

    if (rol == "jugador") {
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

        val jugador = Jugador(
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
        personalRepository.save(jugador)
        println("Jugador creado correctamente.")
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

        val entrenador = Entrenador(
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
        personalRepository.save(entrenador)
        println("Entrenador creado con éxito.")
    } else {
        println("Rol inválido.")
    }
}

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
            miembro.posicion = readln().ifEmpty { miembro.posicion.name }.let { Jugador.Posicion.valueOf(it.uppercase()) }
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
            miembro.especialidad = readln().ifEmpty { miembro.especialidad.name }.let { Entrenador.Especializacion.valueOf(it.uppercase()) }
            personalRepository.update(id, miembro)
            println("Entrenador actualizado con éxito.")
        }
    } else {
        println("Miembro no encontrado.")
    }
}

fun eliminarMiembro(personalRepository: PersonalRepositoryImpl) {
    print("Ingresa el ID del miembro a eliminar: ")
    val id = readln().toLong()
    val miembro = personalRepository.delete(id)
    if (miembro != null) {
        println("Miembro eliminado con éxito.")
    } else {
        println("Miembro no encontrado.")
    }
}

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

fun realizarConsultas(personalRepository: PersonalRepositoryImpl) {
    // Pablo me tiene que pasar las consultas.
    println("Selecciona la consulta a realizar:")
    println("1. Listar todos los jugadores")
    println("2. Listar todos los entrenadores")
    println("3. Buscar miembro por nombre")
    println("4. Buscar miembros por país")
    println("5. Mostrar miembros con salario mayor a X")
    println("6. Volver al menú principal")
    print("Seleccione una opción: ")

    when (readln().toIntOrNull() ?: 0) {
        //1 -> listarJugadores(personalRepository)
        //2 -> listarEntrenadores(personalRepository)
        //3 -> buscarMiembroPorNombre(personalRepository)
        //4 -> buscarMiembrosPorPais(personalRepository)
        //5 -> buscarMiembrosPorSalario(personalRepository)
        6 -> return
        else -> println("Opción inválida.")
    }
}