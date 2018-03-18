package com.tfr.money

import java.math.BigDecimal
import java.util.function.Predicate

data class Money(val amount: BigDecimal, val currency: String)

fun sendPayment(money: Money, message: String = "") { // Unit by type inference
    println("Sending ${money.amount}")
}

// simple one liner function
fun sum(x:Int, y:Int) = x + y

// cases
fun convertToDollars(money: Money) = when(money.currency) {
    "$" -> money
    "EUR" -> Money(money.amount * BigDecimal(1.10), "$")
    else -> throw IllegalArgumentException("not the currency you're interested in!")
}

// extension function
fun BigDecimal.percent(percentage: Int) =
        this.multiply(BigDecimal(percentage).divide(java.math.BigDecimal(1000)))

// extension infix function
infix fun Int.percentOf(money: Money) = money.amount.multiply(BigDecimal(this).divide(BigDecimal(100)))

// operator override
operator fun Money.plus(money: Money) =
        if (currency == money.currency) {
            Money(amount + money.amount, currency)
        } else
            throw IllegalArgumentException("We're gonna have a problem here!")

fun javaMoney(money: JavaMoney?) {
    println("${money?.amount} is valid") // for nullable
    println("${money!!.amount} is valid") // can throw a null pointer
}

fun findEmails(users: List<User>, predicate: (String) -> (Boolean)): List<User> {
    TODO("LATER!")
}



fun main(args: Array<String>) {

    val tickets = Money(BigDecimal(100), "$")
    val popcorn = tickets.copy(100.bd, "$")

    val costs = tickets + popcorn  //using the overridden operator

    var train: Money? = Money(100.bd, "$") // ? for nullable
    train = null

    val users = listOf(User(1, "ehage", "ehage4@gmail.com"))
    findEmails(users) {
        it.endsWith(".com")
    }

    val (id, _, _) = users.filter { it.email.endsWith(".com") }
            .sortedBy { it.id }.first()
            //.map { it.email to it.username }



    val bd1 = BigDecimal(100)

    val long = 100L
    val bd2 = 100.bd

    bd1.percent(7) //extension function usage

    7.percentOf(popcorn)
    7 percentOf popcorn

    sendPayment(tickets)
    sendPayment(message = "Good luck", money = tickets)

    if(tickets != popcorn) {
        println("They are different")
    }

    val javaMoney = JavaMoney(100, "$")

}

private val Int.bd: BigDecimal
    get() = BigDecimal(this)

