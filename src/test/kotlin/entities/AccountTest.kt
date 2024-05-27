package entities

import org.example.entities.Account
import org.example.entities.InsufficientBalanceException
import org.example.useCases.TransactionIntent
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AccountTest {

    @Test
    fun `Should throw exception when not has sufficient balance`() {
        val intentTransaction = TransactionIntent(sellerName = "Loja do zé", account = "123abc", mmc = "1789", price = 5000.0)
        val account = Account()

        assertThrows<InsufficientBalanceException> { account.debtTransaction(intentTransaction) }
    }
}