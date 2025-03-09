package org.example.repositories

import org.example.models.Personal

/**
 * Interfaz genérica para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) específicamente para objetos de tipo [Personal].
 * Extiende la interfaz [CrudRepository] que define las operaciones CRUD básicas.
 *
 * @param T el tipo de entidad que se maneja en el repositorio. En este caso, es [Personal].
 */
interface PersonalRepository<T> : CrudRepository<Personal, Long>