package ParkingLot.Repositry;

import ParkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Long , Ticket> ticketsDB = new HashMap<>();
    private long autoSequenceId = 0L;

    public Ticket save(Ticket ticket){
        autoSequenceId++;
        ticket.setId(autoSequenceId);
        ticketsDB.put(autoSequenceId, ticket);
        return ticket;
    }
}
