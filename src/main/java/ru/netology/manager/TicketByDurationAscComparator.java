package ru.netology.manager;

import ru.netology.domain.Ticket;

import java.util.Comparator;

public class TicketByDurationAscComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        return o1.getDuraction() - o2.getDuraction();
    }
}
