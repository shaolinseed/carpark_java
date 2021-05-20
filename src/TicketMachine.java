import java.util.*;
import java.time.*;

//TicketMachine class is upper class of entrancemachine

public class TicketMachine {

    //used to store the remaining amount of ticket paper
    public int ticketPaperAvailable;

    public LocalDateTime entryTime = LocalDateTime.now();

    //Each variation of user is stored in its own arraylist to keep track of the amount of each type of space
    //regularsList to store max of 309 users
    public ArrayList<User> regularList = new ArrayList<User>(309);
    //staff list of 4 max
    public ArrayList<Staff> staffList = new ArrayList<Staff>(4);
    //handicapped list of 30 max
    public ArrayList<User> disabledList = new ArrayList<User>(30);
    //
    public ArrayList<User> pAndCList = new ArrayList<User>(12);

    //new scanner object
    Scanner input = new Scanner(System.in);

    //outer menu loop for main functions of carpark

    //constructor
    public TicketMachine() {
        this.ticketPaperAvailable = ticketPaperAvailable;
        this.entryTime = entryTime;
    }

    public int getTicketPaperAvailable() {
        return ticketPaperAvailable;
    } //unused but could be needed in real project

    public void setTicketPaperAvailable() {
        this.ticketPaperAvailable = ticketPaperAvailable;
    } //unused but could be needed in real project

    //all of random generation functions

    //create an instance of Random class
    public Random random = new Random();

    //create random number plate
    public String genNumberPlate() {
        return this.genRandomChar()
                + this.genRandomChar()
                + this.genRandomDigit()
                + this.genRandomDigit()
                + this.genRandomChar()
                + this.genRandomChar()
                + this.genRandomChar();

    }

    //generate random single digit
    public String genRandomDigit() {
        return String.valueOf(random.nextInt(10));

    }

    //generate random character for number plate
    public String genRandomChar() {
        char c = (char) (random.nextInt(26) + 'A');
        return String.valueOf(c);
    }

    //help method accessible from any point on any machine
    public void help() {

    }
}
