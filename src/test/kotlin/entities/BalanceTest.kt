package entities

import org.example.entities.Balance
import org.example.entities.BalanceTypes
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BalanceTest {

    @Test
    fun `Should return true when category has MMC`() {
        val balance = Balance.create(BalanceTypes.CULTURE, 12.3)
        assertTrue(balance.isMmcUsable("123"))
    }

    @Test
    fun `Should return false when category has not MMC`() {
        val balance = Balance.create(BalanceTypes.CULTURE, 12.3)
        assertFalse(balance.isMmcUsable("XXX"))
    }

    @Test
    fun `Should return true when has sufficient balance`() {
        val balance = Balance.create(BalanceTypes.CULTURE, 12.3)
        assertTrue(balance.hasSufficientBalance(10.0))
    }

    @Test
    fun `Should return false when has sufficient balance`() {
        val balance = Balance.create(BalanceTypes.CULTURE, 12.3)
        assertFalse(balance.hasSufficientBalance(20.0))
    }

    @Test
    fun `Should pay price when has sufficient value`() {
        val balance = Balance.create(BalanceTypes.GENERAL, 10.0)

        val result = balance.pay(8.0)

        assertTrue(result)
        assertEquals(2.0, balance.getBalanceValue())
    }

    @Test
    fun `Should not pay price when has no sufficient value`() {
        val balance = Balance.create(BalanceTypes.GENERAL, 10.0)

        val result = balance.pay(12.0)

        assertFalse(result)
        assertEquals(10.0, balance.getBalanceValue())
    }
}