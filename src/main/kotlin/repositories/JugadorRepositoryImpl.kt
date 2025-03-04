package repositories

import org.example.repositories.JugadorRepository
import org.example.models.Jugador
import org.lighthousegames.logging.logging

class JugadorRepositoryImpl : JugadorRepository {
    private val logger = logging()
    private val jugadores = mutableMapOf<Long, Jugador>()


    override fun getAll(): List<Jugador> {
        logger.debug { "Obteniendo todos los jugadores" }
        return jugadores.values.toList()
    }

    override fun getById(id: Long): Jugador? {
        logger.debug { "Obteniendo jugador con la id: $id" }
        return jugadores[id]
    }

    override fun save(item: Jugador): Jugador {
        logger.debug { "Guardando jugador: $item" }
        // Creamos un nuevo id para el nuevo personal añadido.
        val id = jugadores.keys.maxOrNull()?.plus(1) ?: 1
        jugadores[id] = item.copy(id = id) as Jugador
        return jugadores[id]!!
    }

    override fun update(id: Long, item: Jugador): Jugador? {
        logger.debug {  "Actualizando el jugador con el id: $id" }
        return if (jugadores.containsKey(id)) {
            jugadores[id] = item.copy(id = id) as Jugador
            jugadores[id]
        } else {
            null
        }
    }

    override fun delete(id: Long): Jugador? {
        logger.debug { "Borrando jugador con el id: $id" }
        return jugadores.remove(id)
    }
}