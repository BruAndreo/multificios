package org.example.entities

import org.example.useCases.TransactionIntent

class Account {

    private val balances: List<Balance> = listOf(
        Balance.create(BalanceTypes.MEAL, 25.0),
        Balance.create(BalanceTypes.CULTURE, 50.0),
        Balance.create(BalanceTypes.GENERAL, 1000.0),
    )

    fun debtTransaction(intent: TransactionIntent) {
        val selectedBalance = balances
            .firstOrNull { it.isMmcUsable(intent.mmc) && it.hasSufficientBalance(intent.price) }
            ?: throw InsufficientBalanceException()

        selectedBalance.pay(intent.price)
        // Criar transação
        // Retorna transação
    }
}