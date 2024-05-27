package org.example.entities

class GeneralBalance(balanceValue: Double): Balance(balanceValue) {
    override val mmcAccepteds: List<String> = listOf()

    override fun isMmcUsable(mmc: String) = true
}