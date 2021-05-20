import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//gui is a class for the interface
//PayMachine and ExitMachine from class diagram have been combined into this class as well
//due to change from console menu to gui lot's of code from ticket machine classes has been moved into here
//The majority of my code follows the structure of the diagrams. Part of the development process involves changes on primary design. In my java
// project I have decided to use a GUI which meant that my ExitMachine, PayMachine and CarPark ended up being combined into one class named GUI.
// Some functions involving scanning the staff ID have been altered to work with the java interpretation assigning certain ticket ID
public class Gui {

    //create new EntranceMachine object to build up the arraylists
    EntranceMachine ticketMachine = new EntranceMachine();
    private boolean moveMenu = false;

    //custom welcome picture
    private ImageIcon welcomeImage;


    //creating outerPanel
    JPanel contPanel = new JPanel();
    JPanel outerPanel = new JPanel();
    JPanel entryPanel = new JPanel();
    JPanel payPanel = new JPanel();
    JPanel exitPanel = new JPanel();

    //home buttons
    JButton homeEntry = new JButton("Home");
    JButton homePay = new JButton("Home");
    JButton homeExit = new JButton("Home");

    //outer menu buttons
    JButton park = new JButton("Park car");
    JButton pay = new JButton("Pay for ticket");
    JButton exit = new JButton("Exit Car Park");
    JButton help = new JButton("Request Help");
    JButton lists = new JButton("View currently used spaces");

    //entrance select ticket buttons
    JButton regularTicket = new JButton("Regular Ticket");
    JButton staffTicket = new JButton("Staff Ticket");
    JButton handicappedTicket = new JButton("Handicapped Ticket");
    JButton parentAndChildTicket = new JButton("Parent and Child Ticket");

    //pay for ticket components
    JButton confirmPayment = new JButton("Confirm Payment");
    JLabel payMessage = new JLabel("Please enter the ID of the ticket which you would like to pay for");
    JTextField confirmTicketId1 = new JTextField("Ticket Id");

    //exit car park components
    JLabel exitMessage = new JLabel("Please enter the ID of the ticket which you would like to pay for");
    JButton confirmExit = new JButton("Confirm exit");
    JTextField confirmTicketId2 = new JTextField("Ticket Id");

    JFrame frame = new JFrame("Queen Anne Car Park");

    //card layout to flick between panels
    CardLayout cl = new CardLayout();

    //setting up the interface
    public Gui() {
        //start entrance function
        entrance();
        contPanel.setLayout(cl);

//load and align image
        welcomeImage = new ImageIcon(getClass().getResource("resources/welcome.png"));
        JLabel welcomeMessage = new JLabel(welcomeImage);
        welcomeMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        //outer menu
        outerPanel.add(welcomeMessage);
        outerPanel.add(park);
        outerPanel.add(pay);
        outerPanel.add(exit);
        outerPanel.add(help);
        outerPanel.add(lists);


        //pay section
        payPanel.add(payMessage);
        payPanel.add(confirmTicketId1);
        payPanel.add(confirmPayment);
        payPanel.add(homePay);

        //exit section
        exitPanel.add(exitMessage);
        exitPanel.add(confirmTicketId2);
        exitPanel.add(confirmExit);
        exitPanel.add(help);
        exitPanel.add(homeExit);


        //add tp the content panel
        contPanel.add(outerPanel, "1");
        contPanel.add(entryPanel, "2");
        contPanel.add(payPanel, "3");
        contPanel.add(exitPanel, "4");
        //show outer to begin with
        cl.show(contPanel, "1");

        //home buttons couldnt have one for all cases as was taking other uses
        //home button to take from the entry selection panel
        homeEntry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(contPanel, "1");
            }
        });
        //home button to take from the pay panel
        homePay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(contPanel, "1");
            }
        });
        //home button to take from exit panel
        homeExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(contPanel, "1");
            }
        });

        park.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(contPanel, "2"); //shows entry panel if park button pressed
            }
        });
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(contPanel, "3"); //shows pay panel if pay button pressed
                pay();

            }
        });
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cl.show(contPanel, "4"); //show exit panel if exit button presssed
                exit();
            }
        });
        //shows lists of each arraylist containing the users in different spaces in the console
        lists.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Regular spaces used: " + ticketMachine.regularList);
                System.out.println("Staff spaces used: " + ticketMachine.staffList);
                System.out.println("Handicapped spaces used: " + ticketMachine.disabledList);
                System.out.println("Parent and child spaces used: " + ticketMachine.pAndCList);
            }
        });

    }


    //start of program defining the gui attributes
    public void showGui() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 400);
        frame.add(contPanel);
        frame.setVisible(true);


    }

    //select the kind of ticket you wish to continue with
    public void entrance() {

        //entrance section
        entryPanel.add(regularTicket);
        entryPanel.add(staffTicket);
        entryPanel.add(handicappedTicket);
        entryPanel.add(parentAndChildTicket);
        entryPanel.add(homeEntry);

        //actions to do on each variation of ticket button, add to the relevant list and generate the relevant ID
        regularTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("you have successfuly parked");
                ticketMachine.updateRegularSpaces();
                cl.show(contPanel, "1");
                JOptionPane.showMessageDialog(frame.getComponent(0), "You have selected a regular ticket with ID: " + ticketMachine.displayRegularID() + "\n" + "You car's number plate is:  " + ticketMachine.displayRegularNP());
            }
        });

        staffTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("you have successfuly parked");
                ticketMachine.updateStaffSpaces();
                JOptionPane.showMessageDialog(frame.getComponent(0), "You have selected a staff ticket with ID: " + ticketMachine.displayStaffID() + "\n" + "You car's number plate is:  " + ticketMachine.displayStaffNP());
                cl.show(contPanel, "1");
            }
        });
        handicappedTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("you have successfuly parked");
                ticketMachine.updateDisabledSpaces();
                JOptionPane.showMessageDialog(frame.getComponent(0), "You have selected a handicapped ticket with ID: " + ticketMachine.displayDisabledID() + "\n" + "You car's number plate is:  " + ticketMachine.displayDisabledNP());
                cl.show(contPanel, "1");
            }
        });
        parentAndChildTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("you have successfuly parked");
                ticketMachine.updatePAndCSpaces();
                JOptionPane.showMessageDialog(frame.getComponent(0), "You have selected a parent and child ticket with ID: " + ticketMachine.displayPAndCID() + "\n" + "You car's number plate is:  " + ticketMachine.displayPAndCNP());
                cl.show(contPanel, "1");
            }
        });


    }

    //pay for ticket function to search through the relevant array for the ticket the user is trying to pay for
    public void pay() {
        confirmPayment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //get the user input store in confirmTicketId
                String currentTicketId = confirmTicketId1.getText();
                //variable to store first digit as this is needed to determine the variation of ticket
                String firstDigit = String.valueOf(currentTicketId.charAt(0));
                //determine which ticket type with first digit
                if (firstDigit.equals("1")) {
                    for (int i = 0; i < ticketMachine.regularList.size(); i++) { //loop through entire list
                        if (ticketMachine.regularList.get(i).getTicketId().equals(currentTicketId)) { //if ticket found
                            ticketMachine.regularList.get(i).setTicketPaid(); //set ticket paid for current user
                            ticketMachine.regularList.get(i).setExitTime(); //set the exit time to current time
                            System.out.println(ticketMachine.regularList);
                            //sourced from Razvan's project to calculate the price
                            float pricePerMinute = 1.25F;
                            long totalTime = ticketMachine.regularList.get(i).calcTime().getSeconds();
                            float totalCost = pricePerMinute * ((float) totalTime / 60.0F);
                            //JOptionPane.showMessageDialog(frame.getComponent(0), "You succesfully paid for your ticket" +"\n You spent: " + entranceMachine.regularList.get(i).getStayDurationString());
                            JOptionPane.showMessageDialog(frame.getComponent(0), "You succesfully paid for your ticket" + "\n It cost you: " + totalCost);
                            cl.show(contPanel, "1"); //return to outer panel
                        }
                    }

                }
                //staff parking is free
                else if (firstDigit.equals("2")) {
                    JOptionPane.showMessageDialog(frame.getComponent(0), "Staff don't need to pay for parking!");

                } else if (firstDigit.equals("3")) {
                    for (int i = 0; i < ticketMachine.disabledList.size(); i++) {
                        if (ticketMachine.disabledList.get(i).getTicketId().equals(currentTicketId)) {
                            ticketMachine.disabledList.get(i).setTicketPaid();
                            System.out.println(ticketMachine.disabledList);
                            JOptionPane.showMessageDialog(frame.getComponent(0), "You succesfully paid for your ticket");
                            cl.show(contPanel, "1"); //return to outer panel
                        }
                    }

                } else if (firstDigit.equalsIgnoreCase("4")) {
                    for (int i = 0; i < ticketMachine.pAndCList.size(); i++) {
                        if (ticketMachine.pAndCList.get(i).getTicketId().equals(currentTicketId)) {
                            ticketMachine.pAndCList.get(i).setTicketPaid();

                            System.out.println(ticketMachine.pAndCList);
                            JOptionPane.showMessageDialog(frame.getComponent(0), "You succesfully paid for your ticket");
                            cl.show(contPanel, "1"); //return to outer panel
                        }
                    }
                }


            }


        });
    }

    //exit function to search through list to check whether ticket has been paid
    public void exit() {
        confirmExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //get the user input store in confirmTicketId
                String currentTicketId = confirmTicketId2.getText();
                //variable to store first digit as this is needed to determine the variation of ticket
                String firstDigit = String.valueOf(currentTicketId.charAt(0));
                //determine ticket type with the first digit
                if (firstDigit.equals("1")) {
                    for (int i = 0; i < ticketMachine.regularList.size(); i++) { //for all users in current list
                        if (ticketMachine.regularList.get(i).getTicketId().equals(currentTicketId)) { //search to check if equal to given ID
                            if (ticketMachine.regularList.get(i).getTicketPaid() == true) { //check whether current user has paid
                                JOptionPane.showMessageDialog(frame.getComponent(0), "Your ticket has been validated" + "\n Thank you for using Queen Anne Car Park");
                                ticketMachine.regularList.remove(i); //if they paid remove them from the list
                                System.out.println("Your ticket has been paid for"); //confirm ticket paid
                                System.out.println(ticketMachine.regularList); //show the new updated list
                            }

                            cl.show(contPanel, "1"); //return to outer loop
                        }
                    }

                }
                //staff parking is free dont need to check if its been paid for
                else if (firstDigit.equals("2")) {
                    for (int i = 0; i < ticketMachine.staffList.size(); i++) {
                        if (ticketMachine.staffList.get(i).getTicketId().equals(currentTicketId)) {
                            JOptionPane.showMessageDialog(frame.getComponent(0), "Your ticket has been validated" + "\n Thank you for using Queen Anne Car Park");
                            ticketMachine.staffList.remove(i); //remove staff from list without checking whether they have paid as they dont need to
                            System.out.println("Your ticket has been paid for");
                            System.out.println(ticketMachine.staffList);
                        }

                        cl.show(contPanel, "1"); //return to outer panel
                    }
                } else if (firstDigit.equals("3")) {
                    for (int i = 0; i < ticketMachine.disabledList.size(); i++) {
                        if (ticketMachine.disabledList.get(i).getTicketId().equals(currentTicketId)) {
                            if (ticketMachine.disabledList.get(i).getTicketPaid() == true) {
                                JOptionPane.showMessageDialog(frame.getComponent(0), "Your ticket has been validated" + "\n Thank you for using Queen Anne Car Park");
                                ticketMachine.disabledList.remove(i);
                                System.out.println("Your ticket has been paid for");
                                System.out.println(ticketMachine.disabledList);
                            }

                            cl.show(contPanel, "1"); //return to outer panel
                        }
                    }

                } else if (firstDigit.equalsIgnoreCase("4")) {
                    for (int i = 0; i < ticketMachine.pAndCList.size(); i++) {
                        if (ticketMachine.pAndCList.get(i).getTicketId().equals(currentTicketId)) {
                            if (ticketMachine.pAndCList.get(i).getTicketPaid() == true) {
                                JOptionPane.showMessageDialog(frame.getComponent(0), "Your ticket has been validated" + "\n Thank you for using Queen Anne Car Park");
                                ticketMachine.pAndCList.remove(i);
                                System.out.println("Your ticket has been paid for");
                                System.out.println(ticketMachine.pAndCList);
                            }

                            cl.show(contPanel, "1");
                        }
                    }
                }

            }

        });
    }
}
