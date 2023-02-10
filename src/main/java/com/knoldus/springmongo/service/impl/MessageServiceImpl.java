package com.knoldus.springmongo.service.impl;

import com.knoldus.springmongo.dto.CreateRequest;
import com.knoldus.springmongo.repository.MessageDocument;
import com.knoldus.springmongo.repository.MessageRepository;
import com.knoldus.springmongo.dto.Message;
import com.knoldus.springmongo.dto.MessageId;
import com.knoldus.springmongo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAll() {
        List<Message> result = new ArrayList<>();
        messageRepository.findAll().forEach(m -> {
            result.add(new Message(m.getId(), m.getMessage()));
        });
        return result;
    }

    @Override
    public MessageId saveMessage(CreateRequest request) {
        MessageDocument saved = messageRepository.save(new MessageDocument(null, request.message()));
        return new MessageId(saved.getId());
    }

    @Override
    public void delete(MessageId id) {
        messageRepository.deleteById(id.id());
    }

}
