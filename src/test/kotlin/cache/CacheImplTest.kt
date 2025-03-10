package cache

import org.example.cache.CacheImpl
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

//CLase que implementa los test de la cache
class CacheImplTest {

    //Inia la variable antes de ser usada, esta variable es la instancia de CacheImpl sonde las claves y los valores son string
    private lateinit var lruCache: CacheImpl<String, String>

    //Ejecuta antes de cada prueba la funcion setup, donde creamos un objeto que sea la cache y establecemos su capacidad
    @BeforeEach
    fun setUp() {
        lruCache = CacheImpl(5)
    }

    //Test que evalua el comportamiento de la cache llenandola al maximo y comporbando que al insertar un nuevo elemento sigue el orden correcto de borrado e inserccion
    @Test
    @DisplayName("Comportamiento Cache")
    fun cacheLru(){
        lruCache.put("key1", "value1")
        lruCache.put("key2", "value2")
        lruCache.put("key3", "value3")
        lruCache.put("key4", "value4")
        lruCache.put("key5", "value5")

        lruCache.put("key6", "value6")

        assertNull(lruCache.get("key1"))
        assertNotNull(lruCache.get("key2"))
        assertNotNull(lruCache.get("key3"))
        assertNotNull(lruCache.get("key4"))
        assertNotNull(lruCache.get("key5"))
        assertNotNull(lruCache.get("key6"))
    }

    //Test que crea elementos en la cache para leugo borrarlos y comporbar si existen
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

    //teste que comprueba el tamaño de la cache, primero insertando solo tres resgitroos, y luego sobrepasando su tamaño añadiedno mas registros
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

    //Test que comprueba si los resgitros insertados tienen las claves correspondientes
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

    //Test que comprueba si los resgistros insertados tienen los valores correspondientes
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

    //test que comprueba con los resgitros insertados si los valores estan bien asociados a su clave
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