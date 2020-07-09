package com.mockorg.demo.controllers;

import com.mockorg.demo.daos.EventsRepository;
import com.mockorg.demo.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/events/{id}")
    public String show(@PathVariable long id, Model model) {
        Event event = eventsDao.getOne(id);
        model.addAttribute("event", event);
        model.addAttribute("eventId", id); //this is optional, just to have this attribute in case it needs to be used in the view at some point.
        return "events/show";
    }

    @GetMapping("/events/create")
    public String showForm(Model model) {
        model.addAttribute("event", new Event());
        return "events/create";
    }

    @PostMapping("/events/create")
    public String save(@ModelAttribute Event eventToBeSaved) {
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        eventToBeSaved.setUser(currentUser);
        Event savedEvent = eventsDao.save(eventToBeSaved);
//        emailService.prepareAndSend(savedEvent, "A new event has been created.", "A new event has been created with the id of " + savedEvent.getId());
        return "redirect:/events/" + savedEvent.getId(); //if we just want to redirect it to the /events page, no need to concatenate with savedEvent.getId()
    }

}
