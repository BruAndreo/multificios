package org.example.entities

class CultureBalance(balanceValue: Double): Balance(balanceValue) {
    override val mmcAccepteds: List<String> = listOf("123", "456")
}