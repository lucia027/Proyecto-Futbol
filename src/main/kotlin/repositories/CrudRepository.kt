package org.example.repositories

/**
 * Interfaz genérica para operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
 * Esta interfaz define los métodos básicos para interactuar con el almacenamiento de datos.
 *
 * @param T el tipo de entidad que se maneja en el repositorio.
 * @param ID el tipo de identificador único de la entidad.
 */
interface CrudRepository<T, ID> {
    /**
     * Obtiene una lista de todas las entidades.
     *
     * @return una lista de todas las entidades de tipo [T].
     */
    fun getAll(): List<T>

    /**
     * Busca una entidad por su identificador único.
     *
     * @param id el identificador único de la entidad.
     * @return la entidad correspondiente al identificador, o null si no se encuentra.
     */
    fun getById(id: ID): T?

    /**
     * Guarda una nueva entidad en el repositorio.
     *
     * @param item la entidad a guardar.
     * @return la entidad guardada con éxito.
     */
    fun save(item: T): T

    /**
     * Actualiza una entidad existente en el repositorio.
     *
     * @param id el identificador único de la entidad a actualizar.
     * @param item la entidad con los nuevos valores.
     * @return la entidad actualizada, o null si no se encuentra la entidad original.
     */
    fun update(id: ID,item: T): T?

    /**
     * Elimina una entidad su identificador único.
     *
     * @param id el identificador único de la entidad a eliminar.
     * @return la entidad eliminada, o null si no se encuentra la entidad.
     */
    fun delete(id: ID): T?
}