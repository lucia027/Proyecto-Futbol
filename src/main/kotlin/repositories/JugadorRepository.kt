package org.example.repositories

import org.example.models.Jugador
import org.example.repository.CrudRepository

interface JugadorRepository : CrudRepository<Jugador, Int>