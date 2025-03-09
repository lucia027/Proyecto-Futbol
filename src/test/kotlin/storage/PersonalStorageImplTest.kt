/*package storage

import org.example.models.Entrenador
import org.example.storage.PersonalStorage
import org.example.storage.PersonalStorageCsv
import org.example.storage.PersonalStorageImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.io.TempDir
import java.io.File

//FAltan MOCK

@ExtendWith()
class PersonalStorageImplTest {


    @Test
    @DisplayName("Garantizar que readFile identifica el fromato de csv correcto")
    fun readFileCsv(@TempDir tempDir: File){
        val file = File(tempDir, "personal.csv")
        val personal = listOf(Entrenador(1, "Maria", "Hongo", "1960-07-17", "2000-01-01", 60000.0, "Brasil", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE))

        every { PersonalStorageCsv.readFile(file, FileFormat.CSV) }

        val result = PersonalStorage.readFile(file, FileFormat.CSV)

        assertEquals(personal, result)
        verify(exactly = 1) { PersonalStorageCsv.readFile(file) }
    }
}
 */