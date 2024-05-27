package org.example.entities

class MealBalance(balanceValue: Double): Balance(balanceValue) {
    override val mmcAccepteds: List<String> = listOf("1789", "1788", "1589", "1587")
}