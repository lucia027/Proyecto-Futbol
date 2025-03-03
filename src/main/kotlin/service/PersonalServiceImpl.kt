package org.example.service

import org.example.repository.PersonalRepository
import org.example.storage.PersonalStorageFile
import org.jetbrains.kotlin.incremental.storage.PersistentStorage

class PersonalServiceImpl(

    private val storageImpl: PersonalStorage,
    private val repository: PersonalRepository

): PersonalService {
}