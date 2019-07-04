package com.movierental;

public class Customer {
    private String name;

    private Rentals rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new Rentals();
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement() {
        return new TextStatement().display(name, rentals);
    }

    public String htmlStatement() {
        return new HtmlStatement().display(name, rentals);
    }

}

