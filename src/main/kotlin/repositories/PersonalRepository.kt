package org.example.repository

import org.example.models.Personal

interface PersonalRepository<T : Personal> : CrudRepository<Personal, Int>