package ru.netology.domain;

public class Ticket {

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

}
