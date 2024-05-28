package org.example.entities

abstract class Balance(val type: BalanceTypes, private var value: Double) {

    companion object {
        fun create(type: BalanceTypes, value: Double) = when (type) {
            BalanceTypes.MEAL -> MealBalance(type, value)
            BalanceTypes.GENERAL -> GeneralBalance(type, value)
            BalanceTypes.CULTURE -> CultureBalance(type, value)
        }
    }

    abstract val mmcAccepteds: List<String>

    open fun isMmcUsable(mmc: String) = mmcAccepteds.contains(mmc)

    fun hasSufficientBalance(price: Double) = value >= price

    fun getBalanceValue() = value

    fun pay(price: Double): Boolean {
        if (hasSufficientBalance(price)) {
            value -= price
            return true
        }
        return false
    }
}