package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void NoTicketsSortTest() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("UFA", "USK", 21_000, 12, 14);
        Ticket ticket2 = new Ticket("UFA", "USK", 18_000, 21, 24);
        Ticket ticket3 = new Ticket("MSK", "SPB", 17_000, 15, 17);
        Ticket ticket4 = new Ticket("UFA", "USK", 15_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "USK", 25_000, 7, 8);
        Ticket ticket6 = new Ticket("UFA", "USK", 16_000, 5, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("UFA", "SPB");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void OneTicketSortTest() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("UFA", "USK", 21_000, 12, 14);
        Ticket ticket2 = new Ticket("UFA", "USK", 18_000, 21, 24);
        Ticket ticket3 = new Ticket("MSK", "SPB", 17_000, 15, 17);
        Ticket ticket4 = new Ticket("UFA", "USK", 15_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "USK", 25_000, 7, 8);
        Ticket ticket6 = new Ticket("UFA", "USK", 16_000, 5, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void FewTicketsSortTest() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("UFA", "USK", 21_000, 12, 14);
        Ticket ticket2 = new Ticket("UFA", "USK", 18_000, 21, 24);
        Ticket ticket3 = new Ticket("MSK", "SPB", 17_000, 15, 17);
        Ticket ticket4 = new Ticket("UFA", "USK", 15_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "USK", 25_000, 7, 8);
        Ticket ticket6 = new Ticket("UFA", "USK", 16_000, 5, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("UFA", "USK");
        Ticket[] expected = {ticket4, ticket6, ticket2, ticket1};
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void NoTicketsSortWithComparatorTest() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("UFA", "USK", 21_000, 12, 14);
        Ticket ticket2 = new Ticket("UFA", "USK", 18_000, 21, 24);
        Ticket ticket3 = new Ticket("MSK", "SPB", 17_000, 15, 17);
        Ticket ticket4 = new Ticket("UFA", "USK", 15_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "USK", 25_000, 7, 8);
        Ticket ticket6 = new Ticket("UFA", "USK", 16_000, 5, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("UFA", "SPB", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void OneTicketsSortWithComparatorTest() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("UFA", "USK", 21_000, 12, 14);
        Ticket ticket2 = new Ticket("UFA", "USK", 18_000, 21, 24);
        Ticket ticket3 = new Ticket("MSK", "SPB", 17_000, 15, 17);
        Ticket ticket4 = new Ticket("UFA", "USK", 15_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "USK", 25_000, 7, 8);
        Ticket ticket6 = new Ticket("UFA", "USK", 16_000, 5, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void FewTicketsSortWithComparatorTest() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("UFA", "USK", 21_000, 13, 14);
        Ticket ticket2 = new Ticket("UFA", "USK", 18_000, 21, 24);
        Ticket ticket3 = new Ticket("MSK", "SPB", 17_000, 15, 17);
        Ticket ticket4 = new Ticket("UFA", "USK", 15_000, 10, 12);
        Ticket ticket5 = new Ticket("MSK", "USK", 25_000, 7, 8);
        Ticket ticket6 = new Ticket("UFA", "USK", 16_000, 5, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("UFA", "USK", comparator);
        Ticket[] expected = {ticket1, ticket4, ticket6, ticket2};
        Assertions.assertArrayEquals(expected, actual);


    }
}
