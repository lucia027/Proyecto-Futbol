package org.example.cache
import org.lighthousegames.logging.logging


//Clase en la que se desarrollan las funciones base de la cache
class CacheImpl<K, V>(private val capacidad: Int): Cache<K, V> {

    //Creacion del logger
    private val logger = logging()

    //Creamos el objeto de la cache, indicando la capacidad, que se reseteara al 75% de su capcidad maxima,
    // e indicamos como true para asegurarnos de que sigue el orden segun acceso.
    //Tambien ejecutamos siempre que se añada un elemento nuevo el removeEldestEntry para ver si necesitamos
    // o no eliminar ese elemento
    private val cache = object : LinkedHashMap<K, V>(
        capacidad, 0.75f, true
    ){
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
            logger.debug { "Se ha agotado el espacio en la capacidad, eliminando elemento mas antiguo." }
            return size > capacidad
        }
    }

    //Inicamos la cache con la capacidad establecida
    init {
        logger.debug{ "Creando la cache con capacidad: $capacidad" }
    }

    //Funcion que obtiene el valor de una clave
    override fun get(key: K): V? {
        logger.debug{ "Buscando el elemento con la clave: $key" }
        return cache[key]
    }

    //Funcion que asocia las claves con sus respectivos valores
    override fun put(key: K, value: V): V? {
        logger.debug{ "Guardando el elemento con la clave: $key" }
        cache[key] = value
        return value
    }

    //Funcion qu e elimina el valor segun la clave
    override fun remove(key: K): V? {
        logger.debug{ "Eliminando el elemento con la clave: $key" }
        return cache.remove(key)
    }

    //Funcion que limpia la cache
    override fun clear() {
        logger.debug{ "Limpiando cache.." }
        return cache.clear()
    }

    //Devuelve el tamaño de la cache
    override fun size(): Int {
        logger.debug{ "Obteniendo tamaño..." }
        return cache.size
    }

    //Devuelve todas las claves
    override fun keys(): Set<K> {
        logger.debug{ "Obteniendo claves..." }
        return cache.keys
    }

    //Devuelve una coleccion con todos los valores
    override fun values(): Collection<V> {
        logger.debug{ "Obteniendo valores..." }
        return cache.values
    }

    //Devuelve todos los clave-valor que existen
    override fun entries(): Set<Map.Entry<K, V>> {
        logger.debug{ "Obteniendo entradas..." }
        return cache.entries
    }

    //Devuelve una lista con todos los valores
    override fun listAll(): List<V> {
        return cache.values.toList()
    }
}