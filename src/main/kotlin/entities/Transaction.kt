package org.example.entities

import org.example.useCases.TransactionIntent
import java.util.UUID

data class Transaction(
    val id: UUID,
    val seller: String,
    val price: Double,
    val mmc: String,
    val balanceUsedType: BalanceTypes
) {
    companion object {
        fun intentToTransaction(intent: TransactionIntent, balanceType: BalanceTypes) = Transaction(
            id = UUID.randomUUID(),
            seller = intent.sellerName,
            price = intent.price,
            mmc = intent.mmc,
            balanceUsedType = balanceType
        )
    }
}
