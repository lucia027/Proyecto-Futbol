package org.example.repositories

import org.example.models.Personal

interface PersonalRepository<T> : CrudRepository<Personal, Long>