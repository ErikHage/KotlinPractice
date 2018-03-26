package com.tfr.monad

interface Validation<in T> {

    val name: String

    fun validate(input: T): ValidationResult {
        try {
            assert(input)
        } catch (ex: AssertionException) {
            return FailedValidation(this.name, ex.message.orEmpty())
        }
        return SuccessfulValidation(this.name)
    }

    fun assert(input: T): Unit

    class AssertionException(message: String): RuntimeException(message)
}