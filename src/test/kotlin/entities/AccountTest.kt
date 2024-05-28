package entities

import org.example.entities.Account
import org.example.entities.InsufficientBalanceException
import org.example.entities.Transaction
import org.example.useCases.TransactionIntent
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AccountTest {

    @Test
    fun `Should throw exception when not has sufficient balance`() {
        val intentTransaction = TransactionIntent(sellerName = "Loja do zé", account = "123abc", mmc = "1789", price = 5000.0)
        val account = Account()

        assertThrows<InsufficientBalanceException> { account.debtTransaction(intentTransaction) }
    }

    @Test
    fun `Should return a Transaction when it's created with success`() {
        val intentTransaction = TransactionIntent(sellerName = "Loja do zé", account = "123abc", mmc = "1789", price = 5.0)
        val account = Account()

        val result = account.debtTransaction(intentTransaction)

        assertTrue(result is Transaction)
        assertTrue(result.id != null)
        assertTrue(result.mmc == intentTransaction.mmc)
        assertTrue(result.price == intentTransaction.price)
    }
}