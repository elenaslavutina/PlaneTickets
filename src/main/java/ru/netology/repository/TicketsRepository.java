package ru.netology.repository;
import ru.netology.domain.Ticket;

public class TicketsRepository {

    private Ticket[] items = new Ticket[0];

    public void add(Ticket item) {
        int length = items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Ticket[] findTickets(String from, String to) {

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

        return tmp;
    }

}
