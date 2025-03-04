package org.example.exceptions


// Aquí se encontrarán las excepciones personalizadas

    sealed class exceptions(message: String) : Exception(message) {
        class PersonalStorageCsv(message: String) : exceptions(message)
        class PersonalStorageException(message: String) : exceptions(message)
        class PersonalValidatorException(message: String) : exceptions(message)
        class JugadorValidatorException(message: String) : exceptions(message)
        class EntrenadorValidatorException(message: String) : exceptions(message)
        class PersonalIdNotFound(id: String) : Exception("El id delpersonal no se ha encontrado $id")
    }