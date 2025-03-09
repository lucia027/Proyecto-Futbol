package storage

//Import mockk
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify

import org.example.models.Entrenador
import org.example.storage.FileFormat
import org.example.storage.PersonalStorage
import org.example.storage.PersonalStorageCsv
import org.example.storage.PersonalStorageJson
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.io.TempDir
import java.io.File

@ExtendWith(MockKExtension::class)
class PersonalStorageImplTest {

    @MockK
    private lateinit var personalStorageCsv: PersonalStorageCsv

    @MockK
    private lateinit var personalStorageJson: PersonalStorageJson

    @InjectMockKs
    private lateinit var personalStorage: PersonalStorage


    @Test
    @DisplayName("Garantizar que readFile identifica el formato de csv correcto")
    fun readFileCsv(@TempDir tempDir: File){
        val file = File(tempDir, "personal.csv")
        val personal = listOf(Entrenador(1, "Maria", "Hongo", "1960-07-17", "2000-01-01", 60000.0, "Brasil", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE))

        every { personalStorageCsv.readFile(file) } returns personal

        val result = personalStorage.readFile(file, FileFormat.CSV)

        assertEquals(personal, result)
        verify(exactly = 1) { personalStorageCsv.readFile(file) }
    }

    @Test
    @DisplayName("Garantizar que writeFile identifica el formato de csv correcto")
    fun writeFileCsv(@TempDir tempDir: File){
        val file = File(tempDir, "personal.csv")
        val personal = listOf(Entrenador(1, "Maria", "Hongo", "1960-07-17", "2000-01-01", 60000.0, "Brasil", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE))

        every { personalStorageCsv.writeFile(personal, file) } returns Unit

        personalStorage.writeFile(file, FileFormat.CSV, personal)

        verify(exactly = 1) { personalStorageCsv.writeFile(personal, file) }
    }

    @Test
    @DisplayName("Garantizar que readFile identifica el formato de json correcto")
    fun readFileJson(@TempDir tempDir: File){
        val file = File(tempDir, "personal.json")
        val personal = listOf(Entrenador(1, "Maria", "Hongo", "1960-07-17", "2000-01-01", 60000.0, "Brasil", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE))

        every { personalStorageJson.readFile(file) } returns personal

        val result = personalStorage.readFile(file, FileFormat.JSON)

        assertEquals(personal, result)
        verify(exactly = 1) { personalStorageJson.readFile(file) }
    }

    @Test
    @DisplayName("Garantizar que writefile identifica el formato de json correcto")
    fun writeFileJson(@TempDir tempDir: File){
        val file = File(tempDir, "personal.json")
        val personal = listOf(Entrenador(1, "Maria", "Hongo", "1960-07-17", "2000-01-01", 60000.0, "Brasil", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE))

        every { personalStorageJson.writeFile(personal, file) } returns Unit

        personalStorage.writeFile(file, FileFormat.JSON, personal)

        verify(exactly = 1) { personalStorageJson.writeFile(personal, file) }
    }
}