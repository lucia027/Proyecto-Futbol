package config

import org.example.config.Config
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.nio.file.Files
import java.nio.file.Path
import org.junit.jupiter.api.Assertions.assertEquals
//Indica que solo se usara una isntancia de clase d pruebas
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

//Clase que implementa los test de la configuracion
class ConfigTest {

    //Indica que se usara despues de haber hecto todos los test de esta clase antes
    @AfterAll
    //Se asegura de eliminar cualquier los directorios temporales depsues de hacer los test
    fun cleanup() {
        val dataDir = Path.of(Config.confgProperties.dataDir)
        val backupDir = Path.of(Config.confgProperties.backupDir)

        Files.deleteIfExists(dataDir)
        Files.deleteIfExists(backupDir)
    }

    //Test que se asegura de las clase ConfigProperties carga bien las rutas de los archivos data y backup
    @Test
    @DisplayName("Leer correctamente el archivo config con sus valores por defecto")
    fun loadDefaultProperties() {
        val configProperties = Config.ConfigProperties()

        val expectedDataDir = "data"
        val expectedBackupDir = "backup"

        assertEquals(expectedDataDir, configProperties.dataDir)
        assertEquals(expectedBackupDir, configProperties.backupDir)

        val actualDataDirPath = Path.of(System.getProperty("user.dir"), configProperties.dataDir)
        val actualBackupDirPath = Path.of(System.getProperty("user.dir"), configProperties.backupDir)
    }
}