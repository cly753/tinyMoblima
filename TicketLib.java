package Moblima;

import java.util.ArrayList;

// do we need this?
// yes. definitely
public class TicketLib {

    private ArrayList<Ticket> tiLib;

    public TicketLib() {
        tiLib = new ArrayList<Ticket>();
    }

    public boolean addTicket(Ticket currentTicket) {
        tiLib.add(currentTicket);
        return true;
    }

    public int getNumOfTicket() {
        return tiLib.size();
    }
    
    public Ticket searchTicketByID(int ticketID) {
        for (Ticket t: tiLib)
            if (t.getTicketID() == ticketID)
                return t;
        return null;
    }
}
