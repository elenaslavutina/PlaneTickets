package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

public class TicketsManager {

    private TicketsRepository TicketsRepository = new TicketsRepository();
    public TicketsManager(TicketsRepository repository) {
        this.TicketsRepository = repository;
    }

    public void add(Ticket item) {
        TicketsRepository.add(item);
    }

}

