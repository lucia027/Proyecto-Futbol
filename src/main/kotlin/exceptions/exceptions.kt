package org.example.exceptions


// Aquí se encontrarán las excepciones personalizadas
    class PersonalIdNotFound(id: String) : Exception("El id delpersonal no se ha encontrado $id")
    sealed class exceptions(message: String) : Exception(message) {
        class PersonalStorageCsv(message: String) : exceptions(message)
        class PersonalStorageException(message: String) : exceptions(message)
        class EntrenadorStorageException(message: String) // aún no estamos seguros de si debemos de hacer un storage para Entrenador
        class JugadorStorageException(message: String) // aún no estamos seguros de si debemos de hacer un storage para Jugador
    }