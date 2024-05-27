package org.example.useCases

class MMCNotValidException(override val message: String = "MMC is not valid"): RuntimeException(message) {
}