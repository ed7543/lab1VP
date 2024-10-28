package mk.ukim.finki.artefactId.lab.web;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.service.EventService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class EventListServlet extends HttpServlet {
    private final EventService eventService;

    public EventListServlet(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchText = req.getParameter("searchText");
        int minRating = req.getParameter("minRating") != null ? Integer.parseInt(req.getParameter("minRating")) : 0;

        List<Event> events = (searchText != null) ?
                eventService.searchEvents(searchText, minRating) :
                eventService.listAll();

        req.setAttribute("events", events);
        req.getRequestDispatcher("/listEvents.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventName = req.getParameter("eventName");
        int numberOfTickets = Integer.parseInt(req.getParameter("numTickets"));
        req.setAttribute("selectedEvent", eventName);
        req.setAttribute("numberOfTickets", numberOfTickets);
        resp.sendRedirect("/eventBooking");
    }
}