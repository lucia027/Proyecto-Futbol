import org.example.cache.Cache
import org.example.cache.CacheImpl
import org.example.models.Personal
import org.example.repositories.PersonalRepository
import org.example.repositories.PersonalRepositoryImpl
import org.example.service.PersonalService
import org.example.storage.FileFormat
import org.example.storage.PersonalStorage
import org.example.storage.PersonalStorageImpl
import org.lighthousegames.logging.logging
import java.io.File

// Tamaño máximo del caché
private const val CACHE_SIZE = 6

class PersonalServiceImpl(
    private val cache: Cache<String, Personal> = CacheImpl(CACHE_SIZE), // Caché para objetos Personal
    private val storage: PersonalStorage = PersonalStorageImpl(), // Gestión de archivos
    private val repository: PersonalRepository<Personal> = PersonalRepositoryImpl() // Repositorio para CRUD
) : PersonalService {

    private val logger = logging() // Logger para registrar acciones

    override fun readFile(filepath: String, format: FileFormat): List<Personal> {
        logger.info { "Leyendo personal del fichero" }
        return storage.readFile(File(filepath), format) // Lee un archivo y devuelve la lista de Personal
    }

    override fun writeFile(filepath: String, format: FileFormat, personal: List<Personal>) {
        logger.info { "Sobreescribiendo personal del fichero" }
        return storage.writeFile(File(filepath), format, personal) // Escribe la lista de Personal en un archivo
    }

    override fun importFile(filePath: String, format: FileFormat) {
        logger.info { "Importando personal del fichero" }
        val personal = readFile(filePath, format) // Lee el archivo
        personal.forEach {
            repository.save(it) // Guarda cada objeto Personal en el repositorio
        }
    }

    override fun exportFile(filePath: String, fileFormat: FileFormat) {
        writeFile(filePath, fileFormat, repository.getAll()) // Exporta todos los objetos Personal a un archivo
    }

    override fun getAll(): List<Personal> {
        return repository.getAll() // Devuelve todos los objetos Personal del repositorio
    }

    override fun getById(id: Long): Personal {
        logger.info { "Obteniendo personal: $id" }
        return cache.get(id.toString())!! // Recupera un objeto Personal del caché usando su ID
    }

    override fun save(personal: Personal): Personal {
        logger.info { "Guardando personal: $personal" }
        return repository.save(personal) // Guarda un objeto Personal en el repositorio
    }

    override fun update(id: Long, personal: Personal): Personal {
        logger.info { "Actualizando personal: $personal" }
        return repository.update(id, personal)?.also {
            cache.remove(id.toString()) // Elimina el objeto Personal actualizado del caché
        }!!
    }

    override fun delete(id: Long): Personal {
        logger.info { "Borrando personal: $id" }
        return repository.delete(id)!! // Elimina un objeto Personal del repositorio
    }
}
