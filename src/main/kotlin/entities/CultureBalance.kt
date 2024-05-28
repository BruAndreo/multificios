package org.example.entities

class CultureBalance(type: BalanceTypes, balanceValue: Double): Balance(type, balanceValue) {
    override val mmcAccepteds: List<String> = listOf("123", "456")
}