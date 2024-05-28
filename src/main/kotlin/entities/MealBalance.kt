package org.example.entities

class MealBalance(type: BalanceTypes, balanceValue: Double): Balance(type, balanceValue) {
    override val mmcAccepteds: List<String> = listOf("1789", "1788", "1589", "1587")
}