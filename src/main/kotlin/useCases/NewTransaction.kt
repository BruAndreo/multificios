package org.example.useCases

import org.example.entities.Account
import java.util.UUID

class NewTransaction(
    private val mmcRepository: MMCRepository,
    private val account: Account
) {

    fun create(intent: TransactionIntent): UUID {
        if (!mmcRepository.isValid(intent.mmc)) {
            throw MMCNotValidException()
        }

        val transaction = account.debtTransaction(intent)
        return transaction.id
    }
}