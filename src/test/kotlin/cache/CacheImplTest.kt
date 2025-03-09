package cache

import org.example.cache.CacheImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CacheImplTest {

    private lateinit var lruCache: CacheImpl<String, String>

    @BeforeEach
    fun setUp() {
        lruCache = CacheImpl(5)
    }

    @Test
    @DisplayName("Comportamiento Cache")
    fun cacheLru(){
        lruCache.put("key1", "value1")
        lruCache.put("key2", "value2")
        lruCache.put("key3", "value3")
        lruCache.put("key4", "value4")
        lruCache.put("key5", "value5")

        assertNotNull(lruCache.get("key3"))

        lruCache.put("key6", "value6")

        assertNull(lruCache.get("key3"))
        assertNull(lruCache.get("key1"))
        assertNull(lruCache.get("key2"))
        assertNull(lruCache.get("key4"))
        assertNull(lruCache.get("key5"))
        assertNull(lruCache.get("key6"))
    }

    @Test
    @DisplayName("Limpieza Cache")
    fun limpiezaCache() {
        lruCache.put("key1", "value1")
        lruCache.put("key2", "value2")
        lruCache.put("key3", "value3")

        lruCache.clear()

        assertEquals(0, lruCache.size())
        assertNull(lruCache.get("key1"))
        assertNull(lruCache.get("key2"))
        assertNull(lruCache.get("key3"))
    }

    @Test
    @DisplayName("Tamaño cache")
    fun sizeCache() {
        lruCache.put("key1", "value1")
        lruCache.put("key2", "value2")
        lruCache.put("key3", "value3")

        assertEquals(3, lruCache.size())

        lruCache.put("key4", "value4")
        lruCache.put("key5", "value5")
        lruCache.put("key6", "value6")

        assertEquals(5, lruCache.size())
    }

    @Test
    @DisplayName("Funcionamiento keys")
    fun keys(){
        lruCache.put("key1", "value1")
        lruCache.put("key2", "value2")

        assertAll("keys",
        { assertTrue(lruCache.keys().contains("key1")) },
        { assertTrue(lruCache.keys().contains("key2")) }
        )
    }

    @Test
    @DisplayName("Funcionamiento values")
    fun values(){
        lruCache.put("key1", "value1")
        lruCache.put("key2", "value2")

        assertAll("values",
            { assertTrue(lruCache.values().contains("value1")) },
            { assertTrue(lruCache.values().contains("value2")) }
        )
    }

    @Test
    @DisplayName("Funcionamiento entradas")
    fun entries(){
        lruCache.put("key1", "value1")
        lruCache.put("key2", "value2")

        assertAll("entries",
            { assertEquals("value1", lruCache.get("key1")) },
            { assertEquals("value2", lruCache.get("key2")) }
        )
    }
}