package com.tfr.monad

interface Transformation<in IN, out OUT> {

    val name: String

    fun execute(input: IN): OUT
}