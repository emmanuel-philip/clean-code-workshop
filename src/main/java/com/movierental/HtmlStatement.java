package com.movierental;

class HtmlStatement {
    public String display(String customerName, Rentals rentals) {
        String result = "<h1>Rental Record for <b>" + customerName + "</b></h1><br>";
        for (Rental each : rentals) {
            //show figures for this rental
            result += " " + each.getMovie().getTitle() + " " +
                    each.amount() + "<br>";
        }
        //add footer lines result
        result += "Amount owed is <b>" + rentals.totalAmount() + "</b><br>";
        result += "You earned <b>" + rentals.totalFrequentRenterPoints()
                + "</b> frequent renter points";
        return result;
    }
}
