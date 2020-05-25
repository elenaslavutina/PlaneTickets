package ru.netology.domain;
import java.util.Objects;
public class Ticket implements Comparable {

    private int    id;
    private String from;
    private String to;
    private int    price;     // in rubles
    private int    duraction; // in minutes

    public Ticket(int id, String from, String to, int price, int duration) {
        this.id    = id;
        this.from  = from;
        this.to    = to;
        this.price = price;
        this.duraction = duration;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public int getDuraction() {
        return this.duraction;
    }

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
