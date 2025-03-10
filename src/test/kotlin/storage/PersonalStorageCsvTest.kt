package storage

import org.example.exceptions.exceptions
import org.example.models.Entrenador
import org.example.storage.PersonalStorageCsv
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.io.TempDir
import java.io.File
import kotlin.test.assertFailsWith

class PersonalStorageCsvTest {
    private val storage: PersonalStorageCsv = PersonalStorageCsv()

    @Test
    @DisplayName("Leer correctamente ficheros CSV")
    fun readFile(@TempDir tempDir: File) {
        val file = File(tempDir, "personal.csv")
        file.writeText(
            "id,nombre,apellidos,fecha_nacimiento,fecha_incorporacion,salario,pais,rol,especialidad\n" +
            "1,Maria,Hongo,1960-07-17,2000-01-01,60000.0,Brasil,Entrenador,ENTRENADOR_PRINCIPAL\n"
        )

        val personal = storage.readFile(file)

        assertAll(
            "personal",
            { assertEquals(1, personal.size) },
            {
                assertEquals(
                    Entrenador(1, "Maria", "Hongo", "1960-07-17", "2000-01-01", 60000.0, "Brasil", "Entrenador", Entrenador.Especializacion.ENTRENADOR_PRINCIPAL),
                    personal[0],
                )
            }
        )
    }

    @Test
    @DisplayName("Lanza una excepcion si el fichero no existe")
    fun readFileNotExist(@TempDir tempDir: File){
        val file = File(tempDir, "personal.csv")

        val exception = assertFailsWith<exceptions.PersonalStorageCsv> { storage.readFile(file) }

        assertEquals("El fichero no existe o no se puede leer", exception.message)
    }

    @Test
    @DisplayName("Escritura correcta en el fichero csv")
    fun writeFile(@TempDir tempDir: File){
        val file = File(tempDir, "personal.csv")
        val personal = listOf(Entrenador(1, "Maria", "Hongo", "1960-07-17", "2000-01-01", 60000.0, "Brasil", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE))

        storage.writeFile(personal, file)

        val expectedContent = ("id,nombre,apellidos,fecha_nacimiento,fecha_incorporacion,salario,pais,rol,especialidad\n" +
                                        "1,Maria,Hongo,1960-07-17,2000-01-01,60000.0,Brasil,Entrenador,ENTRENADOR_PRINCIPAL\n")

        assertEquals(expectedContent, file.readText())
    }

    @Test
    @DisplayName("Excepcion si el directorio padre no existe")
    fun parentFileNotExist(@TempDir tempDir: File){
        val file = File(tempDir, "personal.csv")
        val personal = listOf(Entrenador(1, "Maria", "Hongo", "1960-07-17", "2000-01-01", 60000.0, "Brasil", "Entrenador", Entrenador.Especializacion.ENTRENADOR_ASISTENTE))

        val exception = assertFailsWith<exceptions.PersonalStorageCsv> { storage.writeFile(personal, file) }

        assertEquals("El directorio padre del archivo no existe", exception.message)
    }
}