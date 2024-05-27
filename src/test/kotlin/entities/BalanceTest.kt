package entities

import org.example.entities.Balance
import org.example.entities.BalanceTypes
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
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
}