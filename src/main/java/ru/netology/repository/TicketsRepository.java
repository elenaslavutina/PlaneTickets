package ru.netology.repository;
import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;

import java.util.Arrays;

public class TicketsRepository {

    private Ticket[] items = new Ticket[0];

    public void add(Ticket item) {
        if ((item.getPrice()<=0)||(item.getDuraction()<=0))
        {throw new NotFoundException("Incorrect data format");}
        int length = items.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public void remove(Ticket item) {

        if (!findOne(item)) {
            throw new NotFoundException("Ticket: "+ item.toString()+  " not found");
        }
        int length = items.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket current : items) {
            if (!current.equals(item)) {
                tmp[index] = current;
                index++;
            }
        }
        items = tmp;
    }

    public Ticket[] findAll() {
        return items;
    }

    public boolean findOne(Ticket item) {
        for (Ticket current : items) {
            if (current.equals(item)) {
                return true;
            }
        }
        return false;
    }


}
