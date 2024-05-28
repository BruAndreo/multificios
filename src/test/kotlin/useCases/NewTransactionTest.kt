package useCases

import org.example.entities.Account
import org.example.useCases.MMCNotValidException
import org.example.useCases.MMCRepository
import org.example.useCases.NewTransaction
import org.example.useCases.TransactionIntent
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NewTransactionTest {

    @Test
    fun `Should create a new transaction when passed correct information`() {
        val intentTransaction = TransactionIntent(sellerName = "Loja do zé", account = "123abc", mmc = "1789", price = 51.23)
        val transactionUseCase = NewTransaction(MMCRepositoryMock(true), Account())

        val result = transactionUseCase.create(intentTransaction)

        Assertions.assertNotNull(result)
    }

    @Test
    fun `Should return exception when MMC is not valid`() {
        val intentTransaction = TransactionIntent(sellerName = "Loja do zé", account = "123abc", mmc = "1789", price = 51.23)
        val transactionUseCase = NewTransaction(MMCRepositoryMock(false), Account())

        assertThrows<MMCNotValidException> { transactionUseCase.create(intentTransaction) }
    }

}

internal class MMCRepositoryMock(private val validMMC: Boolean): MMCRepository {
    override fun isValid(mmc: String) = validMMC
}