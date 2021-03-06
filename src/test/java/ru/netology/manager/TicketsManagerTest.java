package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsRepository repository;
    private TicketsManager manager;
    private Ticket first  = new Ticket(1,"SVO", "LED", 3200, 100 );
    private Ticket second = new Ticket(2,"SVO", "LED", 3700, 120 );
    private Ticket third  = new Ticket(3,"SVO", "GOJ", 3500, 100 );
    private Ticket forth  = new Ticket(4,"SVO", "LED", 3000, 90 );


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
    public void shouldSortAndFilter() {
        Ticket[] expected = new Ticket[]{forth, first, second};

        Ticket[] actual = manager.findAllTickets("SVO","LED");
        assertArrayEquals(expected, actual);
    }

}