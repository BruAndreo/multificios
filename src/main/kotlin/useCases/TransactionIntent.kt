package org.example.useCases

data class TransactionIntent(
    val sellerName: String,
    val price: Double,
    val mmc: String,
    val account: String
)
