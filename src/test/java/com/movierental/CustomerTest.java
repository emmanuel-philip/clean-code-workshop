package com.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void shouldGenerateStatementBasic(){
        Customer testCustomer = new Customer("Emmanuel");
        testCustomer.addRental(new Rental(new Movie("Star Wars", 1), 2));
        testCustomer.addRental(new Rental(new Movie("Star Trek", 0), 1));

        assertEquals("Rental Record for Emmanuel\n" +
        "\tStar Wars\t6.0\n" +
        "\tStar Trek\t2.0\n" +
        "Amount owed is 8.0\n" +
        "You earned 3 frequent renter points", testCustomer.statement());
    }

    @Test
    public void shouldGenerateStatementRegularMovieDaysRentedNotGreaterThanTwo(){
        Customer testCustomer = new Customer("Emmanuel");
        testCustomer.addRental(new Rental(new Movie("Star Wars", 0), 2));

        assertEquals("Rental Record for Emmanuel\n" +
                "\tStar Wars\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", testCustomer.statement());
    }

    @Test
    public void shouldGenerateStatementRegularMovieDaysRentedGreaterThanTwo(){
        Customer testCustomer = new Customer("Emmanuel");
        testCustomer.addRental(new Rental(new Movie("Star Wars", 0), 3));

        assertEquals("Rental Record for Emmanuel\n" +
                "\tStar Wars\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", testCustomer.statement()
        );
    }

    @Test
    public void shouldGenerateStatementNewReleaseMovieDaysRentedNotGreaterThanOne(){
        Customer testCustomer = new Customer("Emmanuel");
        testCustomer.addRental(new Rental(new Movie("Star Wars", 1), 1));

        assertEquals("Rental Record for Emmanuel\n" +
                "\tStar Wars\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", testCustomer.statement());
    }

    @Test
    public void shouldGenerateStatementNewReleaseMovieDaysRentedGreaterThanOne(){
        Customer testCustomer = new Customer("Emmanuel");
        testCustomer.addRental(new Rental(new Movie("Star Wars", 1), 2));

        assertEquals("Rental Record for Emmanuel\n" +
                "\tStar Wars\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", testCustomer.statement());
    }

    @Test
    public void shouldGenerateStatementChildrensMovieDaysRentedNotGreaterThanThree(){
        Customer testCustomer = new Customer("Emmanuel");
        testCustomer.addRental(new Rental(new Movie("Toy Story", 2), 1));

        assertEquals("Rental Record for Emmanuel\n" +
                "\tToy Story\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", testCustomer.statement());
    }

    @Test
    public void shouldGenerateStatementChildrensMovieDaysRentedGreaterThanThree(){
        Customer testCustomer = new Customer("Emmanuel");
        testCustomer.addRental(new Rental(new Movie("Toy Story", 2), 4));

        assertEquals("Rental Record for Emmanuel\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", testCustomer.statement());
    }

    @Test
    public void shouldGenerateStatementUnknownPriceCodeMovie(){
        Customer testCustomer = new Customer("Emmanuel");
        testCustomer.addRental(new Rental(new Movie("Fake Movie", 3), 4));

        assertEquals("Rental Record for Emmanuel\n" +
                "\tFake Movie\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points", testCustomer.statement());
    }

    @Test
    public void shouldGenerateStatementNoRentals(){
        Customer testCustomer = new Customer("Emmanuel");

        assertEquals("Rental Record for Emmanuel\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", testCustomer.statement());
    }

}