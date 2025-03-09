package org.example.repositories

import org.example.models.Personal
import org.lighthousegames.logging.logging

/**
 * Implementación de la interfaz [PersonalRepository] para gestionar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre objetos de tipo [Personal].
 * Esta clase utiliza un mapa mutable en memoria para almacenar datos de personal.
 */
class PersonalRepositoryImpl : PersonalRepository<Personal> {
    private val logger = logging()
    private val personal = mutableMapOf<Long, Personal>()

    /**
     * Obtiene una lista de todos los objetos [Personal] almacenados.
     *
     * @return una lista de todos los objetos [Personal].
     */
    override fun getAll(): List<Personal> {
        logger.debug { "Obteniendo todo el personal" }
        return personal.values.toList()
    }

    /**
     * Busca un objeto [Personal] por su identificador único.
     *
     * @param id el identificador único del objeto [Personal].
     * @return el objeto [Personal] correspondiente al identificador, o null si no se encuentra.
     */
    override fun getById(id: Long): Personal? {
        logger.debug { "Obteniendo personal con la id: $id" }
        return personal[id]
    }

    /**
     * Guarda un nuevo objeto [Personal] en el repositorio.
     *
     * @param item el objeto [Personal] a guardar.
     * @return el objeto [Personal] guardado con éxito, incluyendo su nuevo identificador.
     */
    override fun save(item: Personal): Personal {
        logger.debug { "Guardando personal: $item" }
        // Creamos un nuevo id para el nuevo personal añadido.
        val id = personal.keys.maxOrNull()?.plus(1) ?: 1
        personal[id] = item.copy(id = id)
        return personal[id]!!
    }

    /**
     * Actualiza un objeto [Personal] existente en el repositorio.
     *
     * @param id el identificador único del objeto [Personal] a actualizar.
     * @param item el objeto [Personal] con los nuevos valores.
     * @return el objeto [Personal] actualizado, o null si no se encuentra el objeto original.
     */
    override fun update(id: Long, item: Personal): Personal? {
        logger.debug { "Actualizando el personal con el id: $id" }
        return if (personal.containsKey(id)) {
            personal[id] = item.copy(id = id)
            personal[id]
        } else {
            null
        }
    }

    /**
     * Elimina un objeto [Personal] por su identificador único.
     *
     * @param id el identificador único del objeto [Personal] a eliminar.
     * @return el objeto [Personal] eliminado, o null si no se encuentra el objeto.
     */
    override fun delete(id: Long): Personal? {
        logger.debug { "Borrando personal  con el id: $id" }
        return personal.remove(id)
    }
}