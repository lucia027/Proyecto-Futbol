package org.example.repository

import org.example.models.Personal
import org.lighthousegames.logging.logging

class PersonalRepositoryImpl : PersonalRepository<Personal> {
    private val logger = logging()
    private val personal = mutableMapOf<Int, Personal>()


    override fun getAll(): List<Personal> {
        logger.debug { "Obteniendo todo el personal" }
        return personal.values.toList()
    }

    override fun getById(id: Int): Personal? {
        logger.debug { "Obteniendo personal con la id: $id" }
        return personal[id]
    }

    override fun save(item: Personal): Personal {
        logger.debug { "Guardando personal: $item" }
        // Creamos un nuevo id para el nuevo personal añadido.
        val id = personal.keys.maxOrNull()?.plus(1) ?: 1
        personal[id] = item.copy(id = id.toLong())
        return personal[id]!!
    }

    override fun update(id: Int, item: Personal): Personal? {
        logger.debug { "Actualizando el personal con el id: $id" }
        return if (personal.containsKey(id)) {
            personal[id] = item.copy(id = id.toLong())
            personal[id]
        } else {
            null
        }
    }

    override fun delete(id: Int): Personal? {
        logger.debug { "Borrando personal  con el id: $id" }
        return personal.remove(id)
    }
}