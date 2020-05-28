package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketsManager {

    private TicketsRepository repository;

    public TicketsManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.add(item);
    }

    public Ticket[] findAllTickets(String from, String to) {

        Ticket[] tmp = __findAllTickets(from, to);

        Arrays.sort(tmp);

        return tmp;
    }

    public Ticket[] findAllTickets(String from, String to, Comparator<Ticket> comparator) {

        Ticket[] tmp = __findAllTickets(from, to);

        Arrays.sort(tmp, comparator);

        return tmp;
    }

    
    public Ticket[] __findAllTickets(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }


}

