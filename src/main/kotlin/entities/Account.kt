package org.example.entities

import org.example.useCases.TransactionIntent

class Account {

    private val balances: List<Balance> = listOf(
        Balance.create(BalanceTypes.MEAL, 25.0),
        Balance.create(BalanceTypes.CULTURE, 50.0),
        Balance.create(BalanceTypes.GENERAL, 1000.0),
    )

    fun debtTransaction(intent: TransactionIntent) {
        // Identificar se o tipo de MMC encaixa com algum Saldo
        // Debtar saldo
        // Criar transação
        // Retorna transação
    }
}