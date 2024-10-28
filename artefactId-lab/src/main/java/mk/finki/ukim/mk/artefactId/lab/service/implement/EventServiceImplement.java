package mk.ukim.finki.artefactId.lab.service.implement;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.repository.EventRepository;
import mk.ukim.finki.wp.lab.service.EventService;
import java.util.List;
import java.util.stream.Collectors;

public class EventServiceImplement implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImplement(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text, int minRating) {
        return eventRepository.findAll().stream()
                .filter(event -> event.getName().contains(text) || event.getDescription().contains(text))
                .filter(event -> event.getPopularityScore() >= minRating)
                .collect(Collectors.toList());
    }
}
