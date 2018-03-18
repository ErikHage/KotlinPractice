package com.tfr.money

sealed class UserResult
data class Success(val users: List<User>): UserResult()
data class Failure(val message: String): UserResult()

fun retrieveUsers(): UserResult {
    return Success(listOf(User(1, "a", "a@b.com")))
}

fun main(args: Array<String>) {
    val result = retrieveUsers()

    val values = generateSequence(1) { //lazy evaluation
        it * 10
    }

    listOf(1,2,3,4,5,6,7,8,9,0).asSequence() // now it's lazy

    values.take(10).forEach { println(it) }

    when(result) { // smart casting!
        is Success -> result.users.forEach { println(it.toString()) }
        is Failure -> println(result.message)
    }
}