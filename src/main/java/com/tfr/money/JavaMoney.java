package com.tfr.money;

import java.math.BigDecimal;
import java.util.Objects;

public class JavaMoney {

    private int amount;
    private String currency;

    public JavaMoney(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaMoney javaMoney = (JavaMoney) o;
        return amount == javaMoney.amount &&
                Objects.equals(currency, javaMoney.currency);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return "JavaMoney{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public static void main(String ...args) {
        Money money = new Money(new BigDecimal(100), "$");
        money.getAmount();
    }
}
