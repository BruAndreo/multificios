package org.example.entities

class InsufficientBalanceException(override val message: String = "Insufficient balance"): RuntimeException(message) {
}