package com.tfr.monad

interface Validation<in T> {
    fun validate(input: T): Boolean
}