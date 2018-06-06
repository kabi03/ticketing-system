import java.sql.Ref;
import java.util.*;
import java.io.*;
import org.apache.commons.lang3.*;

/**
 * User Abstract Class
 * Contains Methods and Variables for all Users to extend
 */
public abstract class User {
    protected String user_name;
    protected double credit;
    private static String current_type; //Instance Variable
    private static double current_credit; //Instance Variable
    private static String current_username; //Instance Variable

    /**
     * Sell Method - Perform Sell Transaction for Users
     */
    public void sell(){
        Scanner in = new Scanner(System.in);
        String event_title;
        Double price;
        int quantity;

        //Retrieve event title
        while(true) {
            System.out.println("Enter the event title.");
            event_title=in.nextLine();

            if(event_title.length()>25 || event_title.length()<1){
                System.out.println("This title is too long or empty, try again");
                continue;
            }else{
                break;
            }
        }

        //Retrieve price per ticket
        while(true){


            System.out.println("Enter the price per ticket.");
            try {
                price = in.nextDouble();

            if(price>999.99 || price<0){
                System.out.println("That price is not permitted, try again.");
                continue;
            }else{
                break;
            }

            }catch (Exception e){
                System.out.println("Invalid input");
                in = new Scanner(System.in);
                continue;

            }
        }

        //Retrieve quantity
        while(true){
            System.out.println("Enter the quantity of tickets.");
            try {
                quantity = in.nextInt();

                if (quantity > 100 || quantity < 1) {
                    System.out.println("That quantity is not permitted, try again.");
                    continue;
                } else {
                    break;
                }
            }catch (Exception e){
                System.out.println("Invalid input");
                in = new Scanner(System.in);
                continue;
            }
        }
        //creates a new transaction and puts it into the the arraylist but the tranaction is not performed yet
        Frontend.transactions.add(new Buysell(3, quantity, new Ticket(event_title, this.getUser_name(), price, quantity)));
    }

    /**
     * Buy Method - Perform buy transaction
     */
    public void buy(){
        String event_title;
        String sell_un;
        int quantity;




        while(true) {
            boolean qconditiosn_met = false; //If sufficient tickets available condition
            boolean fconditions_met = false; //If ticket found available condition
            boolean deletedU = false; //If user is deleted or not condition
            int index_found = 0;
            boolean enough = false;
            int finalstep = 0;
            Scanner in = new Scanner(System.in);


            System.out.println("Enter the event title: ");
            event_title = in.nextLine();
            System.out.println("Enter the seller's username: ");
            sell_un = in.nextLine();

            //Checks if the user is deleted
            //Needed when logged in as admin and if admin deleted the user and tries to buy the deleted user's tickets
            for(int i = 0; i<Frontend.transactions.size(); i++){
                if(Frontend.transactions.get(i) instanceof Admintransaction){
                    Admintransaction temp = (Admintransaction) Frontend.transactions.get(i);
                    if(temp.getTransaction_code() == 2 && temp.getSubject().getUser_name().equals(sell_un)){
                        deletedU = true;
                        break;
                    }
                }
            }

            //Asks for quantity and makes sure within 1-4 tickets
            while(true) {
                System.out.println("Enter the quantity you want to buy: ");
                try {
                    quantity = in.nextInt();

                    if (quantity > 4 || quantity < 1) {
                        System.out.println("Quantity must be between 1 and 4, Try Again: ");
                        continue;
                    } else {
                        break;
                    }
                }catch (Exception e){
                    System.out.println("Invalid input");
                    in = new Scanner(System.in);
                    continue;
                }

            }

            //Looks for the ticket in the Arraylist
            for(int i = 0; i< Frontend.tickets.size(); i++){
                if (Frontend.tickets.get(i).getSeller_username().equals(sell_un) && Frontend.tickets.get(i).getEvent_name().equals(event_title)) {
                    index_found = i;
                    fconditions_met = true;
                    if(Frontend.tickets.get(i).getQuantity_avaliable() >= quantity){
                        qconditiosn_met = true;
                    }
                    break;
                }
            }

            Scanner choicein = new Scanner(System.in);
            if(fconditions_met == true && qconditiosn_met == true && deletedU == false){
                double costper = Frontend.tickets.get(index_found).getPrice();
                double costt = Frontend.tickets.get(index_found).getPrice() * quantity;

                for(int i = 0; i<Frontend.users.size(); i++){
                    if(Frontend.users.get(i).getUser_name().equals(current_username)){
                        finalstep = i;
                        if(Frontend.users.get(i).credit < costt){
                            System.out.println("You don't have enough credit, try again.");


                        }else{
                            enough = true;
                        }
                        break;
                    }
                }

                if(enough == false){
                    break;
                }

                while(true) {
                    System.out.println("Cost per ticket: " + costper);
                    System.out.println("Total cost: " + costt);
                    System.out.println("Confirm with YES or NO: ");
                    String choice = choicein.nextLine();



                    if (choice.equals("YES")) {
                        Frontend.tickets.get(index_found).setQuantity_avaliable(Frontend.tickets.get(index_found).getQuantity_avaliable() - quantity);
                        Frontend.users.get(finalstep).setCredit(Frontend.users.get(finalstep).getCredit()-costt);
                        Frontend.transactions.add(new Buysell(4, quantity, Frontend.tickets.get(index_found)));
                        break;
                    } else if (choice.equals("NO")) {
                        System.out.println("Ticket order not placed, try ordering another ticket.");
                        break;
                    }else{
                        System.out.println("Invalid choice, try again.");
                        continue;
                    }
                }
                break;

            }else if(fconditions_met == true && qconditiosn_met == false && deletedU == false){
                System.out.println("The tickets are avaliable but not enough for the specified quantity, try again.");
                continue;
            }else{
                System.out.println("This combination doesn't exist, try again.");
                continue;
            }
        }
    }

    /**
     * Setter Method for User Name Variable
     * @param user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * Getter Method for User Name Variable
     * @return
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * Setter Method for Credit Variable
     * @param credit
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }

    /**
     * Getter Method for Credit Variable
     * @return
     */
    public double getCredit() {
        return credit;
    }

    /**
     * Getter Method for Current Type Variable
     * @return
     */
    public static String getCurrentType() {
        return current_type;
    }

    /**
     * Getter Method for Current Credit Variable
     * @return
     */
    public static double getCurrentCredit() {
        return current_credit;
    }

    /**
     * Getter Method for Current Username Variable
     * @return
     */
    public static String getCurrentUsername() {
        return current_username;
    }

    /**
     * Login Method - Login Using Current User Type
     * @param users
     * @return
     */
    public static boolean login(ArrayList<User> users){
        //creates the appropriate user type buy checking with the users arraylist
        String check_username;
        Scanner login_input = new Scanner(System.in);
        System.out.print("Enter your username: ");
        check_username = login_input.nextLine();
        for(int i = 0; i<users.size(); i++){
            if (users.get(i).getUser_name().equals(check_username)){
                current_username = users.get(i).getUser_name();
                current_credit = users.get(i).credit;
                if(users.get(i) instanceof Admin){
                    current_type = "AA";
                }else if(users.get(i) instanceof Sellstandard){
                    current_type = "SS";
                }else if(users.get(i) instanceof Buystandard){
                    current_type = "BS";
                }else if (users.get(i) instanceof Fullstandard){
                    current_type = "FS";
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Logout Method - Logout and update dailyTransaction File
     * Not Completed Yet
     */
    public void logout(){

        Transaction temp;
        String temp_trans;
        String temp_type = "";
        String tempuser = "";
        String temptickets = "";

        try {
            File filetrans = new File("transactions.txt");
            BufferedWriter fileouttrans = new BufferedWriter(new FileWriter("./" + filetrans, true));

            File fileusers = new File("currentUserAccounts.txt");
            BufferedWriter fileoutusers = new BufferedWriter(new FileWriter("./" + fileusers));

            File filetick = new File("avaliableTickets.txt");
            BufferedWriter fileouttick = new BufferedWriter(new FileWriter("./" + filetick));



            for(int i = 0; i<Frontend.transactions.size(); i++){



                if((temp = Frontend.transactions.get(i)).getTransaction_code() == 1){

                    if(((Admintransaction)temp).getSubject() instanceof Admin){

                        Frontend.users.add(new Admin(((Admintransaction)temp).getSubject().getUser_name(), ((Admintransaction)temp).getSubject().getCredit()));
                        temp_type = "AA";

                    }else if(((Admintransaction)temp).getSubject() instanceof Fullstandard){
                        Frontend.users.add(new Fullstandard(((Admintransaction)temp).getSubject().getUser_name(), ((Admintransaction)temp).getSubject().getCredit()));
                        temp_type = "FS";

                    }else if(((Admintransaction)temp).getSubject() instanceof Buystandard){
                        Frontend.users.add(new Buystandard(((Admintransaction)temp).getSubject().getUser_name(), ((Admintransaction)temp).getSubject().getCredit()));
                        temp_type = "BS";


                    }else if(((Admintransaction)temp).getSubject() instanceof Sellstandard){
                        Frontend.users.add(new Sellstandard(((Admintransaction)temp).getSubject().getUser_name(), ((Admintransaction)temp).getSubject().getCredit()));
                        temp_type = "SS";


                    }

                    temp_trans = StringUtils.leftPad((Integer.toString((temp).getTransaction_code())), 2, '0');
                    temp_trans = temp_trans + " " + StringUtils.rightPad(((Admintransaction)temp).getSubject().getUser_name(), 15, ' ')
                            + " " + temp_type + " " + StringUtils.rightPad(Double.toString(((Admintransaction)temp).getSubject().getCredit()), 9, '0');
                    fileouttrans.write(temp_trans);
                    fileouttrans.newLine();







                }else if((temp = Frontend.transactions.get(i)).getTransaction_code() == 2){

                    if(((Admintransaction)temp).getSubject() instanceof Admin){

                        temp_type = "AA";

                    }else if(((Admintransaction)temp).getSubject() instanceof Fullstandard){
                        temp_type = "FS";

                    }else if(((Admintransaction)temp).getSubject() instanceof Buystandard){
                        temp_type = "BS";


                    }else if(((Admintransaction)temp).getSubject() instanceof Sellstandard){
                        temp_type = "SS";


                    }

                    String delun = ((Admintransaction)temp).getSubject().getUser_name();

                    for (int j = 0; j<Frontend.users.size(); j++){
                        if (Frontend.users.get(j).getUser_name().equals(delun)){
                            Frontend.users.remove(j);
                            break;
                        }
                    }

                    for (int j = 0; j<Frontend.tickets.size(); j++){
                        if (Frontend.tickets.get(j).getSeller_username().equals(delun)){
                            Frontend.tickets.remove(j);
                            break;
                        }
                    }



                    temp_trans = StringUtils.leftPad((Integer.toString((temp).getTransaction_code())), 2, '0');
                    temp_trans = temp_trans + " " + StringUtils.rightPad(((Admintransaction)temp).getSubject().getUser_name(), 15, ' ')
                            + " " + temp_type + " " + StringUtils.rightPad(Double.toString(((Admintransaction)temp).getSubject().getCredit()), 9, '0');
                    fileouttrans.write(temp_trans);
                    fileouttrans.newLine();





                }else if((temp = Frontend.transactions.get(i)).getTransaction_code() == 6){
                    String credun = ((Admintransaction)temp).getSubject().getUser_name();
                    double credam = ((Admintransaction)temp).getAmountt();

                    if(((Admintransaction)temp).getSubject() instanceof Admin){

                        temp_type = "AA";

                    }else if(((Admintransaction)temp).getSubject() instanceof Fullstandard){
                        temp_type = "FS";

                    }else if(((Admintransaction)temp).getSubject() instanceof Buystandard){
                        temp_type = "BS";


                    }else if(((Admintransaction)temp).getSubject() instanceof Sellstandard){
                        temp_type = "SS";


                    }

                    if(current_type == "AA") {
                        for (int j = 0; j < Frontend.users.size(); j++) {
                            if (Frontend.users.get(j).getUser_name().equals(credun)) {
                                Frontend.users.get(j).setCredit(Frontend.users.get(j).getCredit() + credam);
                                break;
                            }
                        }

                    }

                    temp_trans = StringUtils.leftPad((Integer.toString((temp).getTransaction_code())), 2, '0');
                    temp_trans = temp_trans + " " + StringUtils.rightPad(((Admintransaction)temp).getSubject().getUser_name(), 15, ' ')
                            + " " + temp_type + " " + StringUtils.rightPad(Double.toString(((Admintransaction)temp).getSubject().getCredit()), 9, '0');
                    fileouttrans.write(temp_trans);
                    fileouttrans.newLine();


                }else if((temp = Frontend.transactions.get(i)).getTransaction_code() == 5){

                    String buyerun = ((Refund)temp).getBuyer().getUser_name();
                    String sellerun = ((Refund)temp).getSeller().getUser_name();
                    double cred = ((Refund)temp).getRefund_amount();

                    for (int j = 0; j<Frontend.users.size(); j++){
                        if (Frontend.users.get(j).getUser_name().equals(buyerun)){
                            Frontend.users.get(j).setCredit(Frontend.users.get(j).getCredit() + cred);
                            break;
                        }
                    }

                    for (int j = 0; j<Frontend.users.size(); j++){
                        if (Frontend.users.get(j).getUser_name().equals(sellerun)){
                            Frontend.users.get(j).setCredit(Frontend.users.get(j).getCredit() - cred);
                            break;
                        }
                    }

                    temp_trans = StringUtils.leftPad((Integer.toString((temp).getTransaction_code())), 2, '0');
                    temp_trans = temp_trans + " " + StringUtils.rightPad(((Refund)temp).getBuyer().getUser_name(), 15, ' ')
                            + " " + StringUtils.rightPad(((Refund)temp).getSeller().getUser_name(), 15, ' ') + " "
                            + StringUtils.rightPad( (Double.toString(((Refund)temp).getRefund_amount())), 9, '0');


                    fileouttrans.write(temp_trans);
                    fileouttrans.newLine();

                }else if((temp = Frontend.transactions.get(i)).getTransaction_code() == 3){

                    Ticket sell = ((Buysell)temp).getTickets();

                    Frontend.tickets.add(sell);

                    temp_trans = StringUtils.leftPad((Integer.toString((temp).getTransaction_code())), 2, '0');
                    temp_trans = temp_trans + " " + StringUtils.rightPad(((Buysell)temp).getTickets().getEvent_name(), 25, ' ')
                            + " " + StringUtils.rightPad(((Buysell)temp).getTickets().getSeller_username(), 15, ' ') + " "
                    + StringUtils.leftPad((Integer.toString(((Buysell)temp).getQuantity())), 3, '0') + " "
                            + StringUtils.rightPad( (Double.toString(((Buysell)temp).getTickets().getPrice())), 6, '0');



                    fileouttrans.write(temp_trans);
                    fileouttrans.newLine();




                }else if((temp = Frontend.transactions.get(i)).getTransaction_code() == 4){

                    int quantity = ((Buysell)temp).getQuantity();
                    double price = ((Buysell)temp).getTickets().getPrice();
                    double totalcredit = price*quantity;
                    String seller = ((Buysell)temp).getTickets().getSeller_username();

                    for(int j = 0; j<Frontend.users.size(); j++){
                        if(Frontend.users.get(j).getUser_name().equals(seller)){
                            Frontend.users.get(j).setCredit(Frontend.users.get(j).getCredit()+totalcredit);
                            break;
                        }
                    }

                    temp_trans = StringUtils.leftPad((Integer.toString((temp).getTransaction_code())), 2, '0');
                    temp_trans = temp_trans + " " + StringUtils.rightPad(((Buysell)temp).getTickets().getEvent_name(), 25, ' ')
                            + " " + StringUtils.rightPad(((Buysell)temp).getTickets().getSeller_username(), 15, ' ') + " "
                            + StringUtils.leftPad((Integer.toString(((Buysell)temp).getQuantity())), 3, '0') + " "
                            + StringUtils.rightPad( (Double.toString(((Buysell)temp).getTickets().getPrice())), 6, '0');



                    fileouttrans.write(temp_trans);
                    fileouttrans.newLine();


                }
            }

            fileouttrans.write("00");
            fileouttrans.newLine();
            fileouttrans.close();


            for(int k = 0; k<Frontend.users.size(); k++){
                tempuser = StringUtils.rightPad((Frontend.users.get(k).getUser_name()), 15, ' ');
                tempuser = tempuser + " ";

                if(Frontend.users.get(k) instanceof Admin){
                    tempuser = tempuser + "AA" + " ";

                }else if(Frontend.users.get(k) instanceof Fullstandard){
                    tempuser = tempuser + "FS" + " ";

                }else if(Frontend.users.get(k) instanceof Buystandard){
                    tempuser = tempuser + "BS" + " ";

                }else if(Frontend.users.get(k) instanceof Sellstandard){
                    tempuser = tempuser + "SS" + " ";

                }

                tempuser = tempuser + StringUtils.rightPad((Double.toString(Frontend.users.get(k).getCredit())), 9, '0');
                fileoutusers.write(tempuser);
                fileoutusers.newLine();
            }

            fileoutusers.write("END");
            fileoutusers.close();

            for(int k=0; k<Frontend.tickets.size(); k++){
                temptickets = StringUtils.rightPad(Frontend.tickets.get(k).getEvent_name(), 25, ' ') + " "
                + StringUtils.rightPad(Frontend.tickets.get(k).getSeller_username(), 15, ' ') + " "
                        + StringUtils.leftPad(Integer.toString((Frontend.tickets.get(k).getQuantity_avaliable())), 3, '0')
                + " " + StringUtils.rightPad(Double.toString((Frontend.tickets.get(k).getPrice())), 6, '0');
                fileouttick.write(temptickets);
                fileouttick.newLine();
            }

            fileouttick.write("END");
            fileouttick.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * addCredit Method to add credit to user
     */
    public void addcredit(){
        Scanner in = new Scanner(System.in);
        Double amount;
        int person = 0;

        while(true) {
            boolean valid = false;
            System.out.println("Enter how much you want to add.");

            try {
                amount = in.nextDouble();

                if (amount <= 1000 && amount > 0) {
                    valid = true;
                }
                if (valid == true) {
                    break;
                } else {
                    System.out.println("Amount not valid, try again.");
                    continue;
                }


            }catch (Exception e){
                System.out.println("Invalid input");
                in = new Scanner(System.in);
                continue;
            }

        }



        for(int i = 0; i<Frontend.users.size(); i++){
            if(Frontend.users.get(i).getUser_name().equals(current_username)){
                person = i;
            }
        }
        //adds to the transactions arraylist
        Frontend.transactions.add(new Admintransaction(6, Frontend.users.get(person), amount));
        Frontend.users.get(person).setCredit(Frontend.users.get(person).getCredit() + amount);
    }
}
