package repositories/*package org.example.repositories

import org.example.models.Entrenador
import org.lighthousegames.logging.logging

class EntrenadorRepositoryImpl : EntrenadorRepository {
    private val logger = logging()
    private val entrenadores = mutableMapOf<Int, Entrenador>()


    override fun getAll(): List<Entrenador> {
        logger.debug { "Obteniendo todos los entrenadores" }
        return entrenadores.values.toList()
    }

    override fun getById(id: Int): Entrenador? {
        logger.debug { "Obteniendo entrenador con el id: $id" }
        return entrenadores[id]
    }

    override fun save(item: Entrenador): Entrenador {
        logger.debug { "Guardando entrenador: $item" }
        // Creamos un nuevo id para el nuevo personal añadido.
        val id = entrenadores.keys.maxOrNull()?.plus(1) ?: 1
        entrenadores[id] = item.copyEntrenador(id = id)
        return entrenadores[id]!!
    }

    override fun update(id: Int, item: Entrenador): Entrenador? {
        logger.debug {  "Actualizando el entrenador con el id: $id" }
        return if (entrenadores.containsKey(id)) {
            entrenadores[id] = item.copyEntrenador(id = id)
            entrenadores[id]
        } else {
            null
        }
    }

    override fun delete(id: Int): Entrenador? {
        logger.debug { "Borrando  entrenador con el id: $id" }
        return entrenadores.remove(id)
    }
}

 */