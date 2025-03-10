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

//Define el tamaño de la cache
private const val CACHE_SIZE = 6

//Implementacion de la interfaz PersonalService desarrollando sus funciones.
class PersonalServiceImpl (

    //Define el tamaño de la cache, el storage, y el repository a utilizar.
    private val cache : Cache<String, Personal> = CacheImpl(CACHE_SIZE),
    private val storage: PersonalStorage = PersonalStorageImpl(),
    private val repository : PersonalRepository<Personal> = PersonalRepositoryImpl()
) : PersonalService {

    //Logger
    private val logger = logging()

    //Lee el arhivo en el formato indicado
    override fun readFile(filepath: String, format: FileFormat): List<Personal> {
        logger.info { "Leyendo personal del fichero" }
        return storage.readFile(File(filepath), format)
    }

    //Escribe una lista de objetos de personal en el sitio indicado y con el formato indicado
    override fun writeFile(filepath: String,format: FileFormat ,personal: List<Personal>) {
        logger.info { "Sobreescribiendo personal del fichero" }
        return storage.writeFile(File(filepath), format, personal)
    }

    //Carga los datos de un archivo en una memoria temporal
    override fun importFile(filePath: String, format: FileFormat) {
        logger.info { "Importando personal del fichero" }
        val personal = readFile(filePath, format)
        personal.forEach {
            repository.save(it)
        }
    }

    //Exporta los que se encuentra de personal a un archivo
    override fun exportFile(filePath: String , fileFormat: FileFormat) {
        writeFile(filePath, fileFormat, repository.getAll())
    }

    //Muesta todos los registros
    override fun getAll(): List<Personal> {
        return repository.getAll()
    }

    //Busca un registo basandose en el id proporcionado
    override fun getById(id: Long): Personal {
        logger.info { "Obteniendo personal: $id" }
        return cache.get(id.toString())!!

    }

    //Guarda una nueva entidad de personal
    override fun save(personal: Personal): Personal {
        logger.info { "Guardando personal: $personal" }
        return repository.save(personal)
    }

    //Actualiza el registro en el respoitorio
    override fun update(id: Long, personal: Personal): Personal {
        logger.info { "actualizando personal: $personal" }
        return repository.update(id, personal) ?.also { cache.remove(id.toString()) }!!
    }

    //Elimina una entidad en base al id obtenido
    override fun delete(id: Long): Personal {
        logger.info { "borrando personal: $id" }
        return repository.delete(id)!!
    }

}

