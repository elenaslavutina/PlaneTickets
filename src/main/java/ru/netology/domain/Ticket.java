package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Ticket implements Comparable {

    private int    id;
    private String from;
    private String to;
    private int    price;     // in rubles
    private int    duraction; // in minutes

    @Override
    public int compareTo(Object o) {
        Ticket ticket = (Ticket) o;
        return this.price - ticket.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                price == ticket.price &&
                duraction == ticket.duraction &&
                Objects.equals(from, ticket.from) &&
                Objects.equals(to, ticket.to);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", price=" + price +
                ", duraction=" + duraction +
                '}';
    }
}
