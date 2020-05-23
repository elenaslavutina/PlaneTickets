package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;


import static org.junit.jupiter.api.Assertions.*;

class TicketsRepositoryTest {

    private TicketsRepository repository = new TicketsRepository();
    private Ticket first  = new Ticket(1,"SVO", "LED", 3200, 100 );
    private Ticket second = new Ticket(2,"SVO", "LED", 3700, 120 );

    @Test
    void shouldAddAndReturn() {
        repository.add(first);
        repository.add(second);
        Ticket[] expected = {first, second};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

}