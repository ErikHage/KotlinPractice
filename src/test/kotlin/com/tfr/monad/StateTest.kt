package com.tfr.monad

class StringToInt: Transformation<String, Int> {
    override val name: String
        get() = this.javaClass.name

    override fun execute(input: String): Int {
        return input.toInt()
    }
}

class LengthValidation: Validation<String> {
    override val name: String
        get() = this.javaClass.name

    override fun assert(input: String) {
        if(input.length < 5) {
            throw Validation.AssertionException("Expected less than 5 but was " + input.length)
        }
    }
}

fun validateLength(input: String): Boolean {
    return input.length < 5
}

fun stringToState(s: String): State<String> {
    return State(s)
}

fun main(args: Array<String>) {

    val state: State<String> = State("10")
    val state2a: State<Int> = state.map { StringToInt().execute(it) }
    val state2b: State<Int> = state.map { it.toInt() }

    println(state2a.value)
    println(state2b.value)

    val someState = State("string")
            .flatMap { stringToState(it) }
            .map { it.substring(2) }
            .validate { it == "ring" }
            .validate { validateLength(it) }
            .validate(LengthValidation())

    println(someState.value)

    try {
        someState.validate { it == "string" }
    } catch (ex: RuntimeException) {
        println(ex.message)
    }

}