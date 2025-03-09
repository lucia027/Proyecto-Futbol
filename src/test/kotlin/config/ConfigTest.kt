package config

import org.example.config.Config
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.nio.file.Files
import java.nio.file.Path
import org.junit.jupiter.api.Assertions.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConfigTest {

    @AfterAll
    fun cleanup() {
        val dataDir = Path.of(Config.configProperties.dataDir)
        val backupDir = Path.of(Config.configProperties.backupDir)

        Files.deleteIfExists(dataDir)
        Files.deleteIfExists(backupDir)
    }

    @Test
    @DisplayName("Leer correctamente el archivo config con sus valores por defecto")
    fun loadDefaultProperties(){
        val configProperties = Config.ConfigProperties()

        val expectedDataDir = "data"
        val expectedBackupDir = "backup"

        assertEquals(expectedDataDir, configProperties.dataDir)
        assertEquals(expectedBackupDir, configProperties.backupDir)

        val actualDataDirPath = Path.of(System.getProperty("user.dir"), configProperties.dataDir)
        val actualBackupDirPath = Path.of(System.getProperty("user.dir"), configProperties.backupDir)
    }
}