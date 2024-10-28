package mk.ukim.finki.artefactId.lab.web;

import mk.ukim.finki.wp.lab.model.EventBooking;
import mk.ukim.finki.wp.lab.service.EventBookingService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/eventBooking")
public class EventBookingServlet extends HttpServlet {
    private final EventBookingService eventBookingService;

    public EventBookingServlet(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventName = req.getParameter("selectedEvent");
        int numTickets = Integer.parseInt(req.getParameter("numberOfTickets"));

        EventBooking booking = eventBookingService.placeBooking(eventName, "Petko Petkov", "127.0.0.1", numTickets);
        req.setAttribute("booking", booking);
        req.getRequestDispatcher("/bookingConfirmation.html").forward(req, resp);
    }
}