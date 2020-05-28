package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsRepository repository;
    private TicketsManager manager;
    private Ticket first  = new Ticket(1,"SVO", "LED", 3200, 90 );
    private Ticket second = new Ticket(2,"SVO", "LED", 3700, 80 );
    private Ticket third  = new Ticket(3,"SVO", "GOJ", 3500, 100 );
    private Ticket forth  = new Ticket(4,"SVO", "LED", 3000, 120 );


    @BeforeEach
    public void populateData() {
        repository = new TicketsRepository();
        manager = new TicketsManager(repository);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);

    }


    @Test
    public void shouldFilterAndSortByPrice() {
        Ticket[] expected = new Ticket[]{forth, first, second};

        TicketByPriceAscComparator comparator = new TicketByPriceAscComparator();

        Ticket[] actual = manager.findAllTickets("SVO","LED", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFilterAndSortByDuration() {
        Ticket[] expected = new Ticket[]{second, first, forth};

        TicketByDurationAscComparator comparator = new TicketByDurationAscComparator();

        Ticket[] actual = manager.findAllTickets("SVO","LED", comparator);
        assertArrayEquals(expected, actual);
    }

}