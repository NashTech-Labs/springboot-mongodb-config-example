package com.knoldus.springmongo.service;

import com.knoldus.springmongo.dto.CreateRequest;
import com.knoldus.springmongo.dto.Message;
import com.knoldus.springmongo.dto.MessageId;

import java.util.List;

public interface MessageService {

    List<Message> getAll();
    MessageId saveMessage(CreateRequest request);

    void delete(MessageId id);

}
