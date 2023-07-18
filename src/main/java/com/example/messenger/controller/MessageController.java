package com.example.messenger.controller;

import com.example.messenger.entity.Message;
import com.example.messenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class MessageController {
    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public String showMessages(@RequestParam(name = "sender", required = false) String sender, ModelMap model) {
        if (sender == null)
            model.put("messages", messageService.findAll());
        else {
            model.put("messages", messageService.findBySender(sender));
            model.put("sender", sender);
        }
        return "messages";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String addMessage(@RequestParam(name = "text") String text, ModelMap model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Message message = new Message(new Date(), username, text);
        messageService.save(message);
        return "redirect:/messages";
    }
}
