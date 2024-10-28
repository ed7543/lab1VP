package package mk.finki.ukim.mk.artefactId.lab.service;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.EventBooking;
import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvents(String text);
}
public interface EventBookingService{
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
}