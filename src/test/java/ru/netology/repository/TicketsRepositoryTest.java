package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.InvalidDataException;
import ru.netology.exception.NotFoundException;


import static org.junit.jupiter.api.Assertions.*;

class TicketsRepositoryTest {

    private TicketsRepository repository = new TicketsRepository();
    private Ticket oneTicket = new Ticket(1, "SVO", "LED", 3200, 100);

    private Ticket first = new Ticket(1, "SVO", "LED", 3200, 100);
    private Ticket second = new Ticket(2, "SVO", "LED", 3700, 120);
    private Ticket third = new Ticket(3, "SVO", "GOJ", 3500, 100);
    private Ticket forth = new Ticket(4, "SVO", "LED", 3000, 120);


    @Test
    void shouldSaveOneTicket() {
        repository.clear();
        repository.add(first);
        Ticket[] expected = {first};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


    @BeforeEach
    public void addAllTicketsToRepository() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(forth);

    }

    @Test
    public void shouldAddAllTicketsToRepository() {

        Ticket[] actual = repository.findAll();
        int actualCount = actual.length;
        int expectedCount = 4;
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void shouldNotAddToRepositoryIfPriceNegative() {

        Ticket adding = new Ticket(3, "SVO", "GOJ", -1000, 100);
        assertThrows(InvalidDataException.class, () -> repository.add(adding));

    }

    @Test
    public void shouldNotAddToRepositoryIfPriceZero() {
        Ticket adding = new Ticket(3, "SVO", "GOJ", 0, 100);
        assertThrows(InvalidDataException.class, () -> repository.add(adding));

    }

    @Test
    public void shouldNotAddToRepositoryIfDurationNegative() {
        Ticket adding = new Ticket(3, "SVO", "GOJ", 3500, -100);
        assertThrows(InvalidDataException.class, () -> repository.add(adding));

    }

    @Test
    public void shouldNotAddToRepositoryIfDurationZero() {
        Ticket adding = new Ticket(3, "SVO", "GOJ", 3500, 0);
        assertThrows(InvalidDataException.class, () -> repository.add(adding));

    }

    @Test
    void shouldFindIfExist() {
        Ticket finding = new Ticket(3, "SVO", "GOJ", 3500, 100);
        boolean expected = true;
        boolean result = repository.findOne(finding);
        assertEquals(expected, result);

    }

    @Test
    void shouldNotFindIfNotExist() {
        Ticket finding = new Ticket(7, "SVO", "GOJ", 4200, 100);
        boolean expected = false;
        boolean result = repository.findOne(finding);
        assertEquals(expected, result);

    }

    @Test
    void shouldRemoveExistingTicket() {
        Ticket ticketToRemove = new Ticket(3, "SVO", "GOJ", 3500, 100);
        Ticket[] expected = new Ticket[]{
                new Ticket(1, "SVO", "LED", 3200, 100),
                new Ticket(2, "SVO", "LED", 3700, 120),
                new Ticket(4, "SVO", "LED", 3000, 120)};
        repository.remove(ticketToRemove);
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotRemoveNotExistingTicket() {
        Ticket ticketToRemove = new Ticket(7, "SVO", "GOJ", 4200, 100);
        assertThrows(NotFoundException.class, () -> repository.remove(ticketToRemove));

    }

}