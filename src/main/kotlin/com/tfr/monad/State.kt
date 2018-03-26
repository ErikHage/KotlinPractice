package com.tfr.monad;

class State<out IN>(val value: IN) {

    inline fun <OUT> map(transform: (IN) -> OUT): State<OUT> {
        return State(transform(value))
    }

    inline fun <OUT> flatMap(transform: (IN) -> State<OUT>): State<OUT> {
        return State(transform(value).value)
    }

    infix fun <OUT> map(transformation: Transformation<IN, OUT>): State<OUT> {
        return State(transformation.execute(value))
    }

    infix fun <OUT> flatMap(transformation: Transformation<IN, State<OUT>>): State<OUT> {
        return State(transformation.execute(value).value)
    }

    inline fun validate(validation: (IN) -> Boolean): State<IN> {
        if (validation(value)) {
            return this
        }
        throw RuntimeException("Input did not pass validation")
    }

    infix fun validate(validation: Validation<IN>): State<IN> {
        validation.validate(value)
        return this
    }

}
