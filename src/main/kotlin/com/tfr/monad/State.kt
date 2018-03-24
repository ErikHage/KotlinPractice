package com.tfr.monad;

class State<out IN>(val value: IN) {

    inline fun <OUT> map(transform: (IN) -> OUT): State<OUT> {
        return State(transform(value))
    }

    inline fun <OUT> flatMap(transform: (IN) -> State<OUT>): State<OUT> {
        return State(transform(value).value)
    }

    inline fun validate(validation: (IN) -> Boolean): State<IN> {
        if (validation(value)) {
            return this
        }
        throw RuntimeException("did not pass validation")
    }

}
