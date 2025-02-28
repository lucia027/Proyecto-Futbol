package org.example.cache

interface Cache<k, v> {
    fun get(key: k): v?
    fun put(key: k, value: v): v?
    fun remove(key: k): v?
    fun clear()
    fun size(): Int
    fun keys(): Set<k>
    fun values(): Collection<v>
    fun entries(): Set<Map.Entry<k, v>>
}