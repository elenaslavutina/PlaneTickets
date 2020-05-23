package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;

public class TicketsManager {

    private TicketsRepository repository = new TicketsRepository();
    public TicketsManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.add(item);
    }

    public Ticket[] findAllTickets(String from, String to) {

        Ticket[] items = repository.findAll();

        int count = 0;
        int i = 0;
        for(i = 0; i < items.length; i++) {
            if (items[i].getTo() == to && items[i].getFrom() == from)
                count += 1;
        }

        Ticket[] tmp = new Ticket[count];

        int j = 0;

        for(i = 0; i < items.length; i++) {
            if (items[i].getTo() == to && items[i].getFrom() == from) {
                tmp[j] = items[i];
                j += 1;
            }
        }

        Arrays.sort(tmp);

        return tmp;
    }


}

