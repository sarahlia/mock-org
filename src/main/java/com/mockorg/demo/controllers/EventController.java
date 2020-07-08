package com.mockorg.demo.controllers;

import com.mockorg.demo.daos.EventsRepository;
import com.mockorg.demo.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EventController {

    //dependency injection
    private EventsRepository eventsDao;

    public EventController(EventsRepository eventsRepository) {
        this.eventsDao = eventsRepository;
    }

    @GetMapping("/events")
    public String index(Model model) {
        List<Event> eventsList = eventsDao.findAll();
        model.addAttribute("events", eventsList);
        return "events/index";
    }
}
