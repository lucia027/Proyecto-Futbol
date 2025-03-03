package org.example.service

import org.example.cache.CacheLRU
import org.example.models.Personal
import org.example.repository.PersonalRepository
import org.example.storage.PersonalStorage
import org.lighthousegames.logging.logging
import java.io.File

private const val CACHE_SIZE = 6

class PersonalServiceImpl(

    private val storageImpl: PersonalStorage,
    private val repository: PersonalRepository

): PersonalService {
    private val logger = logging()
    private val cache =
        CacheLRU<Int, Personal>(
            CACHE_SIZE
        )

    init {
        logger.debug { "Iniciando servicio de personal" }
    }

    override fun readFromFile(filepath: String): List<Personal> {
        logger.info { "Leyendo personal del fichero" }
        return storage.readFromFile(File(filePath))
    }

    override fun writeToFile(filepath: String, personal: List<Personal>) {
        logger.info { "Escribiendo personal del fichero" }
        storage.writeToFile(File(filePath), Personal)
    }

    override fun importFromFile(filePath: String) {
        logger.info { "Importando personal del fichero" }
        val personal = readFromFile(filePath)
        personal.forEach {
            repository.save(it)
        }
    }

    override fun exportToFile(filePath: String) {
        logger.info { "Exportando personal del fichero" }
        writeToFile(filePath, repository.getAll())
    }

    override fun getAll(): List<Personal> {
        logger.info { "Obteniendo personal del fichero" }
        return repository.getAll()
    }

    override fun getById(id: Int): Personal {
        logger.info { "Obteniendo personal del fichero con el id: $id" }
        return cache.get(id) ?: run {
            val personal = repository.getById(id)
                ?: throw exceptions.PersonalIdNotFound(id)
            cache.put(id, personal)
            personal
        }
    }

    override fun save(personal: Personal): Personal {
        logger.info { "Guardando personal del fichero" }
        personal.validate()
        return repository.save(personal)
    }

    override fun update(id: Long, personal: Personal): Personal {
        TODO("Not yet implemented")
    }

    override fun delete(id: Long): Personal {
        TODO("Not yet implemented")
    }
}