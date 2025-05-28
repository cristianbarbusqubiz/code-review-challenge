package com.java.challenge.discount;

public class Order {
    private double total;

    private Customer customer;

    public Order(double total, Customer customer) {
        this.total = total;
        this.customer = customer;
    }

    public double total() {
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }
}
