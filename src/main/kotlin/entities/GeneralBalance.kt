package org.example.entities

class GeneralBalance(type: BalanceTypes, balanceValue: Double): Balance(type, balanceValue) {
    override val mmcAccepteds: List<String> = listOf()

    override fun isMmcUsable(mmc: String) = true
}