package org.example.service

import org.example.cache.CacheLRU
import org.example.models.Entrenador
import org.example.repositories.JugadorRepository

private const val CACHE_SIZE = 5

/*abstract class JugadorServiceImpl(
    private val storage: JugadorStorage,
    private val repository: JugadorRepository
): JugadorService {}*/