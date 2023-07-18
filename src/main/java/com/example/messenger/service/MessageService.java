package com.example.messenger.service;

import com.example.messenger.entity.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();
    List<Message> findBySender(String sender);
    Message save(Message message);
}
