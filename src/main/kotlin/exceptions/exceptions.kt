package org.example.exceptions


    // Aquí se encontrarán las excepciones personalizadas
    sealed class exceptions(message: String) : Exception(message) {
        // Excepcion personalizada para el CSV
        class PersonalStorageCsv(message: String) : exceptions(message)
        // Excepcion personalizada para Storage
        class PersonalStorageException(message: String) : exceptions(message)
        // Excepcion personalizada para el validador de Personal
        class PersonalValidatorException(message: String) : exceptions(message)
        // Excepcion personalizada para el validador de Jugador
        class JugadorValidatorException(message: String) : exceptions(message)
        // Excepcion personalizada para el validador de Entrenador
        class EntrenadorValidatorException(message: String) : exceptions(message)
        // Excepcion personalizada para el formato de fichero
        class PersonalStorageFormat(message: String) : exceptions(message)
    }