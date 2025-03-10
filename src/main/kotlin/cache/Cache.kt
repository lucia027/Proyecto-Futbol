package org.example.cache

//Interfaz con las funciones base de la cache LRU
interface Cache<K, V> {
    fun get(key: K): V?
    fun put(key: K, value: V): V?
    fun remove(key: K): V?
    fun clear()
    fun size(): Int
    fun keys(): Set<K>
    fun values(): Collection<V>
    fun entries(): Set<Map.Entry<K, V>>
    fun listAll(): List<V>
}