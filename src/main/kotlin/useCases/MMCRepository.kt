package org.example.useCases

interface MMCRepository {
    fun isValid(mmc: String): Boolean
}