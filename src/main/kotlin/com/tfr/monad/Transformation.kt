package com.tfr.monad

interface Transformation<in IN, out OUT> {
    fun execute(input: IN): OUT
}