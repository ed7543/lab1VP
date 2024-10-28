package package mk.finki.ukim.mk.artefactId.lab.repository;

import mk.finki.ukim.mk.artefactId.lab.model.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventRepository {
    private List<Event> events;

    //constructor za da inicijalizirame lista so 10 eventi
    public EventRepository() {
        this.events = new ArrayList<>();

        //inicijaliziranje so 10 razlicni eventi
        //za Event klasata imame name description i popularity score
        events.add(new Event("Event1", "Desc1", "1.0"));
        events.add(new Event("Event2", "Desc2", "8.0"));
        events.add(new Event("Event3", "Desc3", "1.5"));
        events.add(new Event("Event4", "Desc4", "7.0"));
        events.add(new Event("Event5", "Desc5", "6.6"));
        events.add(new Event("Event6", "Desc6", "8.0"));
        events.add(new Event("Event7", "Desc7", "2.3"));
        events.add(new Event("Event8", "Desc8", "8.0"));
        events.add(new Event("Event9", "Desc9", "4.0"));
        events.add(new Event("Event10", "Desc10", "5.0"));
    }

    //metod za vrakjanje na listata
    public List<Event> findAll() {
        return events;
    }


    //metod za orebaruvanje na nastani niz listata
    //gi vrakja tie so ime ili opis koj se prakja kkao argument
    public List<Event> searchEvents(String text) {
        return events.stream();
        .filter(event -> event.getName().toLowerCase().contains(text.toLowerCase()) || event.getDescription().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
    }
}