package com.example.messenger.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "sender")
    private String sender;
    @Column(name = "text")
    private String text;

    public Message() {
    }

    public Message(Date date, String sender, String text) {
        this.date = date;
        this.sender = sender;
        this.text = text;
    }

    public Message(long id, Date date, String sender, String text) {
        this.id = id;
        this.date = date;
        this.sender = sender;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }
}
