package org.example.config

import org.lighthousegames.logging.logging
import java.util.*
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.pathString

//Objeto de configuracion del tipo singleton ya que solo existe uno.
object Config {

    //Logger
    private val logger = logging()

    //Creamos la configProperties que solo se inicializara cuando se acceda por primera vez
    val confgProperties: ConfigProperties by lazy {
        loadConfig()
    }

    //Funcion que carga las propiedades desde un archivo y si no se encuentra lanza una excepcion
    //Carga las propiedades de data y backup que al no esatr definidas son por defecto
    //Si no existen los directorios proporcionados se crean
    private fun loadConfig(): ConfigProperties {
        logger.debug { "Iniciando configuracion" }
        val properties = Properties()

        val propertiesStream = this::class.java.getResourceAsStream("/config.properties")
            ?: throw RuntimeException("No se ha encontrado o no se ha podido acceder al fichero de configuracion")

        properties.load(propertiesStream)

        val directorioActual = System.getProperty("user.dir")
        val dataDirProperty = properties.getProperty("data.directory") ?: "data"
        val backupDirProperty = properties.getProperty("backup.directory") ?: "backup"
        val dataDir = Path.of(directorioActual, dataDirProperty).pathString
        val backupDir = Path.of(directorioActual, backupDirProperty).pathString

        makeProgramDirectories(dataDir, backupDir)
        return ConfigProperties(dataDir, backupDir)
    }

    //Crea los directorios necesarios
    private fun makeProgramDirectories(vararg directories: String) {
        directories.forEach {
            val dir = java.io.File(it)
            logger.debug { "Creando directorio: $it" }
            Files.createDirectories(dir.toPath())
        }
    }

    //Contiene valores imporatntes para las rutas de la configuracion
    data class ConfigProperties(val dataDir: String = "data", val backupDir: String = "backup")
}