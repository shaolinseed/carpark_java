import java.time.LocalDateTime;

//class to store info on class mostly ended up being unused due to limitations
//child class of user
public class Staff extends User {
    //encapsulation for staff details
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private boolean idAuth;

    public Staff(String numberPlate, LocalDateTime entryTime, String ticketId) {
        super(numberPlate, entryTime, ticketId);
        this.ticketPaid = true; //set staffpaid to true whenever new staff is created to avoid pay confusion
    }


    //get methods for variables in Staff class

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;

    }

    public boolean getIdAuth() {
        return idAuth;
    }

    // Set methods for variables in Staff class

    public void setId(int newId) {
        this.id = newId;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIdAuth(boolean idAuth) {
        this.idAuth = idAuth;
    }
}
