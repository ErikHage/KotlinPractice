package com.tfr.monad

sealed class ValidationResult(name: String)
class SuccessfulValidation(name: String): ValidationResult(name)
class FailedValidation(name: String, reason: String): ValidationResult(name)