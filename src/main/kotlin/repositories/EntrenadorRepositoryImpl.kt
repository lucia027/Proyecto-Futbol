package repositories

import org.example.repositories.EntrenadorRepository
import org.example.models.Entrenador
import org.lighthousegames.logging.logging

class EntrenadorRepositoryImpl : EntrenadorRepository {
    private val logger = logging()
    private val entrenadores = mutableMapOf<Long, Entrenador>()


    override fun getAll(): List<Entrenador> {
        logger.debug { "Obteniendo todos los entrenadores" }
        return entrenadores.values.toList()
    }

    override fun getById(id: Long): Entrenador? {
        logger.debug { "Obteniendo entrenador con el id: $id" }
        return entrenadores[id]
    }

    override fun save(item: Entrenador): Entrenador {
        logger.debug { "Guardando entrenador: $item" }
        // Creamos un nuevo id para el nuevo personal añadido.
        val id: Long = entrenadores.keys.maxOrNull()?.plus(1L) ?: 1L
        entrenadores[id] = item.copy(id = id) as Entrenador
        return entrenadores[id]!!
    }

    override fun update(id: Long, item: Entrenador): Entrenador? {
        logger.debug {  "Actualizando el entrenador con el id: $id" }
        return if (entrenadores.containsKey(id)) {
            entrenadores[id] = item.copy(id = id) as Entrenador
            entrenadores[id]
        } else {
            null
        }
    }

    override fun delete(id: Long): Entrenador? {
        logger.debug { "Borrando  entrenador con el id: $id" }
        return entrenadores.remove(id)
    }
}