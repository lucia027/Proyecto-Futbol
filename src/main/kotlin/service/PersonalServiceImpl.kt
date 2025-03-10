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

private const val CACHE_SIZE = 6

class PersonalServiceImpl (
    private val cache : Cache<String, Personal> = CacheImpl(CACHE_SIZE),
    private val storage: PersonalStorage = PersonalStorageImpl(),
    private val repository : PersonalRepository<Personal> = PersonalRepositoryImpl()
) : PersonalService {

    private val logger = logging()
    override fun readFile(filepath: String, format: FileFormat): List<Personal> {
        logger.info { "Leyendo personal del fichero" }
        return storage.readFile(File(filepath), format)
    }

    override fun writeFile(filepath: String,format: FileFormat ,personal: List<Personal>) {
        logger.info { "Sobreescribiendo personal del fichero" }
        return storage.writeFile(File(filepath), format, personal)
    }

    override fun importFile(filePath: String, format: FileFormat) {
        logger.info { "Importando personal del fichero" }
        val personal = readFile(filePath, format)
        personal.forEach {
            repository.save(it)
        }
    }

    override fun exportFile(filePath: String , fileFormat: FileFormat) {
        writeFile(filePath, fileFormat, repository.getAll())
    }

    override fun getAll(): List<Personal> {
        return repository.getAll()
    }

    override fun getById(id: Long): Personal {
        logger.info { "Obteniendo personal: $id" }
        return cache.get(id.toString())!!

    }

    override fun save(personal: Personal): Personal {
        logger.info { "Guardando personal: $personal" }
        return repository.save(personal)
    }

    override fun update(id: Long, personal: Personal): Personal {
        logger.info { "actualizando personal: $personal" }
        return repository.update(id, personal) ?.also { cache.remove(id.toString()) }!!
    }

    override fun delete(id: Long): Personal {
        logger.info { "borrando personal: $id" }
        return repository.delete(id)!!
    }

}

