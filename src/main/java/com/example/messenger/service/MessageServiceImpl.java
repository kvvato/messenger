package com.example.messenger.service;

import com.example.messenger.entity.Message;
import com.example.messenger.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, JdbcTemplate jdbcTemplate) {
        this.messageRepository = messageRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> findBySender(String sender) {
        return messageRepository.findBySender(sender);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
