package org.example.useCases

import java.util.UUID

class NewTransaction(
    private val mmcRepository: MMCRepository
) {

    fun create(intent: TransactionIntent): UUID? {
        if (!mmcRepository.isValid(intent.mmc)) {
            throw MMCNotValidException()
        }

        return UUID.randomUUID()
    }
}