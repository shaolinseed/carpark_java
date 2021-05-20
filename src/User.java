import java.time.*;

public class User {
    public static int totalRegular = 309;

    //store numberplate in string
    public String numberPlate = "";
    // date and time when car came in
    public LocalDateTime entryTime = LocalDateTime.now();
    // date and time when car left - empty at the start
    public LocalDateTime exitTime = null;

    //ticket paid true or false
    public boolean ticketPaid = false;

    //used to store ticket id in user class -- needed to include as will make data management easier when forming the usersList Arraylist
    public String ticketId;


    //constructor for user object
    public User(String numberPlate, LocalDateTime entryTime, String ticketId) {
        this.numberPlate = numberPlate;
        this.entryTime = entryTime;
        this.exitTime = null; //upon creation car does not have an assigned exit time so set to null
        this.ticketId = ticketId;
        this.ticketPaid = ticketPaid;
    }

    //not going to alter entryTime

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }


    //get methods


    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    //set exitTime to current time now
    public LocalDateTime setExitTime() {
        exitTime = LocalDateTime.now();
        return exitTime;
    }

    //sourced from Razvan's Example project
    public Duration calcTime() {
        return this.exitTime == null ? null : Duration.between(this.entryTime, this.exitTime);
    }

    //sourced from Razvan's Example project
    public String getStayDurationString() {
        if (this.exitTime == null) {
            return "Still in the Car Park.";
        } else {
            Duration differenceMs = this.calcTime();
            return String.format("%02d:%02d:%02d", differenceMs.toHoursPart(), differenceMs.toMinutesPart(), differenceMs.toSecondsPart());
        }
    }


    //get methods to return important data stored on each user
    public String getTicketId() {
        return ticketId;
    }

    public boolean getTicketPaid() {
        return ticketPaid;
    }

    public boolean setTicketPaid() {
        return ticketPaid = true;
    }


    public String getNumberPlate() {
        return numberPlate;
    }


}

