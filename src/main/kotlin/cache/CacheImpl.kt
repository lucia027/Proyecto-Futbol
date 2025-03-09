package org.example.cache
import org.lighthousegames.logging.logging

class CacheImpl<K, V>(private val capacidad: Int): Cache<K, V> {

    private val logger = logging()
    private val cache = object : LinkedHashMap<K, V>(
        capacidad, 0.75f
    ){
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
            logger.debug { "Se ha agotado el espacio en la capacidad, eliminando elemento mas antiguo." }
            return size < capacidad
        }
    }

    init {
        logger.debug{ "Creando la cache con capacidad: $capacidad" }
    }

    override fun get(key: Long): V? {
        logger.debug{ "Buscando el elemento con la clave: $key" }
        return cache[key]
    }

    override fun put(key: K, value: V): V? {
        logger.debug{ "Guardando el elemento con la clave: $key" }
        cache[key] = value
        return value
    }

    override fun remove(key: Long): V? {
        logger.debug{ "Eliminando el elemento con la clave: $key" }
        return cache.remove(key)
    }

    override fun clear() {
        logger.debug{ "Limpiando cache.." }
        return cache.clear()
    }

    override fun size(): Int {
        logger.debug{ "Obteniendo tamaño..." }
        return cache.size
    }

    override fun keys(): Set<K> {
        logger.debug{ "Obteniendo claves..." }
        return cache.keys
    }

    override fun values(): Collection<V> {
        logger.debug{ "Obteniendo valores..." }
        return cache.values
    }

    override fun entries(): Set<Map.Entry<K, V>> {
        logger.debug{ "Obteniendo entradas..." }
        return cache.entries
    }

    override fun listAll(): List<V> {
        return cache.values.toList()
    }
}