import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Frontend Class
 * @author Jadhushan Vivekanandan 500626549
 * @author Kabilan Veerasingam 500558923
 * @author Yanani Sachiharan 500635360
 * @author Anutharshan Logeswaran 500612736
 */
public class Frontend {

    private static User currentUser;
    public static ArrayList<Ticket> tickets;//holds all the tickets from file
    public static ArrayList<User> users;//holds all the users from file
    public static ArrayList<Transaction> transactions;//holds all the transactions for the session
    public static String[] cmd = new String[10];

    /**
     * Main Method - Login Prompt and User Main Menu calls
     * @param args
     */
    public static void main(String[] args){
        for (int i=1;i<args.length;i++) {
            cmd[i] = args[i];
            // System.out.println(args[i]);
        }

        while(true){
            loginMenu(); //User validation
            userMenu(); //Menu options
        }
    }

    /**
     * loginMenu Method - User Validation Login Menu
     */
    public static void loginMenu() {
        users = new ArrayList<User>(); //Creates ArrayList of type User
        transactions = new ArrayList<Transaction>(); //Creates ArrayList of type Transaction
        loadUsers(); //Calls loadUsers method

        while (true) { //Checks user type in file

            if (User.login(users)) { //User data from txt file imported if successful
                if (User.getCurrentType().equals("AA")) { //User type Admin
                    currentUser = new Admin(User.getCurrentUsername(), User.getCurrentCredit());
                    break;
                } else if (User.getCurrentType().equals("FS")) { //User type Full Standard
                    currentUser = new Fullstandard(User.getCurrentUsername(), User.getCurrentCredit());
                    break;
                } else if (User.getCurrentType().equals("BS")) { //User type Buy Standard
                    currentUser = new Buystandard(User.getCurrentUsername(), User.getCurrentCredit());
                    break;
                } else if (User.getCurrentType().equals("SS")) { //User type Sell Standard
                    currentUser = new Sellstandard(User.getCurrentUsername(), User.getCurrentCredit());
                    break;
                } else { //User type Not Found
                    System.out.println("Unidentifiable User Type, Try Again.");
                }
            } else { //Authentification failed
                System.out.println("Wrong Credentials, Try Again.");
            }
        }
    }

    /**
     * userMenu Method - User Decision Main Menu
     */
    public static void userMenu(){
        Scanner input = new Scanner(System.in); //Scans user input
        int choice;
        tickets = new ArrayList<Ticket>(); //Creates ArrayList of type Ticket
        loadTickets(); //Calls loadTickets method
        if(currentUser instanceof Regular){
            while(true) {

               try {

                   System.out.println("------------");
                   System.out.println("1. Sell");
                   System.out.println("2. Buy");
                   System.out.println("3. Logout");
                   System.out.println("4. Addcredit");
                   System.out.println("------------");
                   System.out.println("Please Input the Menu Option Number: ");
                   choice = input.nextInt();
                   if (choice == 1) {
                       currentUser.sell();
                   } else if (choice == 2) {
                       currentUser.buy();
                   } else if (choice == 3) {
                       currentUser.logout();
                       break;
                   } else if (choice == 4) {
                       currentUser.addcredit();

                   } else {
                       System.out.println("Menu Option Invalid!");
                   }
               }catch (Exception e){
                   System.out.println("Invalid input");
                   input = new Scanner(System.in);
                   continue;
               }


            }

        }else if(currentUser instanceof Admin){ //Menu for Users of instance Admin



            while(true) {

                try {

                    System.out.println("------------");
                    System.out.println("1. Sell");
                    System.out.println("2. Buy");
                    System.out.println("3. Logout");
                    System.out.println("4. Create user");
                    System.out.println("5. Delete user");
                    System.out.println("6. Refund");
                    System.out.println("7. Addcredit");
                    System.out.println("------------");
                    System.out.println("Please Input the Menu Option Number: ");
                    choice = input.nextInt();
                    if (choice == 1) {
                        currentUser.sell();
                    } else if (choice == 2) {
                        currentUser.buy();
                    } else if (choice == 3) {
                        currentUser.logout();
                        break;
                    } else if (choice == 4) {
                        ((Admin) currentUser).create();

                    } else if (choice == 5) {
                        ((Admin) currentUser).delete();

                    } else if (choice == 6) {
                        ((Admin) currentUser).refund();
                    } else if (choice == 7) {
                        currentUser.addcredit();

                    } else {
                        System.out.println("Menu Option Invalid!");
                    }
                }catch (Exception e){
                    System.out.println("Invalid input");
                    input = new Scanner(System.in);
                    continue;
                }


            }
        }
    }

    /**
     * loadTickets Method - Loads Ticket information from text file to ArrayList
     */
/*    public static void loadTickets(){
        try {
            File file = new File("/Users/kabilanveerasingam/Documents/university/sem 2/cps888/Ticketingsystem/src/avaliableTickets.txt"); //Import availableTickets.txt
            //URL path = ClassLoader.getSystemResource("availableTickets.txt");
            BufferedReader filein = new BufferedReader(new FileReader(file));
            String line;
            String event_name, seller_username;
            int quantity_avaliable;
            double price;
            String[] str;

            while(!((line = filein.readLine()).equals("END"))){ //Reads ticket content from file
                str = line.split("\\s+");
                event_name = str[0];
                seller_username = str[1];
                quantity_avaliable = Integer.parseInt(str[2]);
                price = Double.parseDouble(str[3]);
                event_name = event_name.replaceAll("\\s+","");
                tickets.add(new Ticket(event_name, seller_username, price, quantity_avaliable)); //Add to ArrayList
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public static void loadTickets(){
        try {
            //File file = new File("/Users/kabilanveerasingam/Documents/university/sem 2/cps888/Ticketingsystem/src/avaliableTickets.txt"); //Import availableTickets.txt
            //URL path = ClassLoader.getSystemResource("availableTickets.txt");
            File file = new File("avaliableTickets.txt"); //Import availableTickets.txt

            BufferedReader filein = new BufferedReader(new FileReader("./" + file));
            String line;
            String event_name, seller_username;
            int quantity_avaliable;
            double price;


            while(!((line = filein.readLine()).equals("END"))){ //Reads ticket content from file

                event_name = line.substring(0,25);
                seller_username = line.substring(26, 41);
                quantity_avaliable = Integer.parseInt(line.substring(42, 45));
                price = Double.parseDouble(line.substring(46, 52));
                event_name = event_name.trim();
                seller_username = seller_username.trim();
                tickets.add(new Ticket(event_name, seller_username, price, quantity_avaliable)); //Add to ArrayList
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /**
     * loadUsers Method - Loads User information from text file to ArrayList
     */
    public static void loadUsers(){
        try {
            //File file = new File("/Users/kabilanveerasingam/Documents/university/sem 2/cps888/Ticketingsystem/src/currentUserAccounts.txt"); //Import currentUsersAccounts.txt
            File file = new File("currentUserAccounts.txt"); //Import currentUsersAccounts.txt

            BufferedReader filein = new BufferedReader(new FileReader("./" + file));
            String line;
            String username, type;
            double credit;
            String[] str;

            while(!((line = filein.readLine()).equals("END"))){ //Reads user content from file
                str = line.split("\\s+");
                username = str[0];
                type = str[1];
                credit = Double.parseDouble(str[2]);
                username = username.replaceAll("\\s+",""); //gets rid of the empty spaces from the username

                if(type.equals("AA")){ //User added to ArrayList depending on User type
                    users.add(new Admin(username, credit));
                }else if(type.equals("FS")){
                    users.add(new Fullstandard(username, credit));
                }else if(type.equals("SS")){
                    users.add(new Sellstandard(username, credit));
                }else if(type.equals("BS")){
                    users.add(new Buystandard(username, credit));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
