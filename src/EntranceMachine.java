
//entrancemachine is a subclass of ticket machine it contains functions for the entrance panel
public class EntranceMachine extends TicketMachine {

    public EntranceMachine() {
    }

    //Create new ticket object type of ticket is specified as a string in the parameters
    public void updateRegularSpaces() {
        Ticket regularTicket = new Ticket("regular"); //create new ticket
        regularList.add(new User(this.genNumberPlate(), this.entryTime, regularTicket.genTicketId())); //add new user to relevant list
        System.out.println("Greetings your number plate is: " + regularList.get(regularList.size() - 1).getNumberPlate());
        System.out.println("Your ticket ID is: " + regularList.get(regularList.size() - 1).getTicketId()); //print most recent added to list ticket id
        System.out.println("list of regular users: " + this.regularList); //display the list in console

    }

    public void updateStaffSpaces() {
        Ticket staffTicket = new Ticket("staff"); //create new ticket
        staffList.add(new Staff(this.genNumberPlate(), this.entryTime, staffTicket.genTicketId())); //add to relevant list creating random attributes
        System.out.println("Greetings your number plate is: " + staffList.get(staffList.size() - 1).getNumberPlate());
        System.out.println("Your ticket ID is: " + staffList.get(staffList.size() - 1).getTicketId()); //print most recent added to list ticket id
        System.out.println("list of staff users: " + this.staffList);
    }

    public void updateDisabledSpaces() {
        Ticket disabledTicket = new Ticket("disabled"); //create new ticket
        disabledList.add(new User(this.genNumberPlate(), this.entryTime, disabledTicket.genTicketId())); //add to relevant list creating random attributes
        System.out.println("Greetings your number plate is: " + disabledList.get(disabledList.size() - 1).getNumberPlate());
        System.out.println("Your ticket ID is: " + disabledList.get(disabledList.size() - 1).getTicketId()); //print most recent added to list ticket id
        System.out.println("list of handicapped users: " + this.disabledList);
    }

    public void updatePAndCSpaces() {
        Ticket pAndCTicket = new Ticket("pAndC"); //create new ticket
        pAndCList.add(new User(this.genNumberPlate(), this.entryTime, pAndCTicket.genTicketId())); //add to relevant list creating random attributes
        System.out.println("Greetings your number plate is: " + pAndCList.get(pAndCList.size() - 1).getNumberPlate());
        System.out.println("Your ticket ID is: " + pAndCList.get(pAndCList.size() - 1).getTicketId()); //print most recent added to list ticket id
        System.out.println("list of parent and child users: " + this.pAndCList);
    }

    //methods to return number plate of most recently entered vehicle in list
    public String displayRegularNP() {
        return regularList.get(regularList.size() - 1).getNumberPlate();
    }

    public String displayStaffNP() {
        return staffList.get(staffList.size() - 1).getNumberPlate();
    }

    public String displayDisabledNP() {
        return disabledList.get(disabledList.size() - 1).getNumberPlate();
    }

    public String displayPAndCNP() {
        return pAndCList.get(pAndCList.size() - 1).getNumberPlate();
    }


    //methods to return ticket ID of most recently entered vehicle in list
    public String displayRegularID() {
        return regularList.get(regularList.size() - 1).getTicketId();
    }

    public String displayStaffID() {
        return staffList.get(staffList.size() - 1).getTicketId();
    }

    public String displayDisabledID() {
        return disabledList.get(disabledList.size() - 1).getTicketId();
    }

    public String displayPAndCID() {
        return pAndCList.get(pAndCList.size() - 1).getTicketId();
    }


}
