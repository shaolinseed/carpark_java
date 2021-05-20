import java.util.*;


public class Ticket {

    private String ticketId;
    public boolean ticketPaid;
    public String ticketType;

    //create an instance of Random class
    public Random random = new Random();


    /**
     * create a new ticket by initializing
     * ticketPaid is initially set to false
     *
     * @param ticketId   unique id for each ticket
     * @param ticketType String to store the variation of ticket
     */
    public Ticket(String ticketType) {
        this.ticketId = ticketId;
        this.ticketType = ticketType;
        this.ticketPaid = false;

    }


    //get methods to return the attributes of ticket
    public String getTicketId() {

        return ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public boolean getTickedPaid() {
        return ticketPaid;
    }


    /**
     * ticketId and ticketType never needs to be changed so no set method needed
     * used to update whether the ticket has been paid
     *
     * @param ticketPaid new value of ticketPaid
     */

    public void setTicketPaid(boolean ticketPaid) {
        this.ticketPaid = ticketPaid;
    }

    public String genRandomDigit() {
        return String.valueOf(random.nextInt(10));

    }

    /**
     * starts with a unique key depending on ticket type
     *
     * @return unique key followed by 4 random digits
     */
    public String genTicketId() {
        if (ticketType == "regular") {
            //start ALL Regular ticket ID's with a 1
            ticketId = "1" + this.genRandomDigit()
                    + this.genRandomDigit()
                    + this.genRandomDigit();
        } else if (ticketType == "staff") {
            //start ALL Staff ticket ID's with a 2
            ticketId = "2" + this.genRandomDigit()
                    + this.genRandomDigit()
                    + this.genRandomDigit();
        } else if (ticketType == "disabled") {
            //start ALL Disabled ticket ID's with a 3
            ticketId = "3" + this.genRandomDigit()
                    + this.genRandomDigit()
                    + this.genRandomDigit();
        } else if (ticketType == "pAndC") {
            //start ALL Staff ticket ID's with a 2
            ticketId = "4" + this.genRandomDigit()
                    + this.genRandomDigit()
                    + this.genRandomDigit();

        }
        return ticketId;
    }


}
