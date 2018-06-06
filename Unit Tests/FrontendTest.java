import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.*;


/**
 * Frontend class Test Cases
 * @author Jadhushan Vivekanandan 500626549
 * @author Kabilan Veerasingam 500558923
 * @author Yanani Sachiharan 500635360
 * @author Anutharshan Logeswaran 500612736
 */

public class FrontendTest {
    @Test
    /*
    Testing loginMenu method to accept Admin instance object ONLY
    */
    public void loginMenuOne() {
        System.out.println("Test 1");
        ArrayList<User> user = new ArrayList<User>();
        user.add(new Admin("Kabilan", 100.00));
        int result = 1;
        int expresult = 0;
        if (user.get(0) instanceof Admin) {
            result = 0;
        }
        assertEquals(expresult, result);
    }

    @Test
    /*
    Testing loginMenu method to accept Buy standard instance object ONLY
    */
    public void loginMenuTwo(){
        System.out.println("Test 2");
        ArrayList<User> user = new ArrayList<User>();
        user.add(new Buystandard("Anu", 100.00));
        int result = 1;
        int expresult = 0;
        if (user.get(0) instanceof Buystandard) {
            result = 0;
        }
        assertEquals(expresult, result);
    }

    @Test
    /*
    Testing loginMenu method to accept Sell standard instance object ONLY
    */
    public void loginMenuThree(){
        System.out.println("Test 3");
        ArrayList<User> user = new ArrayList<User>();
        user.add(new Sellstandard("Jad", 100.00));
        int result = 1;
        int expresult = 0;
        if (user.get(0) instanceof Sellstandard) {
            result = 0;
        }
        assertEquals(expresult, result);
    }
    @Test
    /*
    Testing loginMenu method to accept Full standard instance object ONLY
    */
    public void loginMenuFour(){
        System.out.println("Test 4");
        ArrayList<User> user = new ArrayList<User>();
        user.add(new Fullstandard("Yanani", 100.00));
        int result = 1;
        int expresult = 0;
        if (user.get(0) instanceof Fullstandard) {
            result = 0;
        }
        assertEquals(expresult, result);
    }

    @Test
    /*
    Testing loadUser method to load  Admin instance object ONLY
    */
    public void loadUserOne(){
        System.out.println("Test 5");
        {
            try {
                File file = new File("/Users/owner/Downloads/TicketingSystem/TicketingSystem/src/Frontend/currentUserAccounts.txt"); //Import currentUsersAccounts.txt
                BufferedReader filein = new BufferedReader(new FileReader(file));
                String line;
                String username, type;
                double credit;
                String[] str;
                ArrayList<User> users = new ArrayList<User>();
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
                int result = 1;
                int expresult = 0;
                if (users.get(0) instanceof Admin) {
                    result = 0;
                }
                assertEquals(expresult, result);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    /*
    Testing loadUser method to load Full standard instance object ONLY
    */
    public void loadUserTwo(){
        System.out.println("Test 6");
        {
            try {
                File file = new File("/Users/owner/Downloads/TicketingSystem/TicketingSystem/src/Frontend/currentUserAccounts.txt"); //Import currentUsersAccounts.txt
                BufferedReader filein = new BufferedReader(new FileReader(file));
                String line;
                String username, type;
                double credit;
                String[] str;
                ArrayList<User> users = new ArrayList<User>();
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
                int result = 1;
                int expresult = 0;
                if (users.get(1) instanceof Fullstandard) {
                    result = 0;
                }
                assertEquals(expresult, result);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    /*
    Testing loadUser method to load Sell Standard instance object ONLY
    */
    public void loadUserThree(){
        System.out.println("Test 7");
        {
            try {
                File file = new File("/Users/owner/Downloads/TicketingSystem/TicketingSystem/src/Frontend/currentUserAccounts.txt"); //Import currentUsersAccounts.txt
                BufferedReader filein = new BufferedReader(new FileReader(file));
                String line;
                String username, type;
                double credit;
                String[] str;
                ArrayList<User> users = new ArrayList<User>();
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
                int result = 1;
                int expresult = 0;
                if (users.get(2) instanceof Sellstandard) {
                    result = 0;
                }
                assertEquals(expresult, result);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    /*
    Testing loadUser method to load Buy Standard instance object ONLY
    */
    public void loadUserFour(){
        System.out.println("Test 8");
        {
            try {
                File file = new File("/Users/owner/Downloads/TicketingSystem/TicketingSystem/src/Frontend/currentUserAccounts.txt"); //Import currentUsersAccounts.txt
                BufferedReader filein = new BufferedReader(new FileReader(file));
                String line;
                String username, type;
                double credit;
                String[] str;
                ArrayList<User> users = new ArrayList<User>();
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
                int result = 1;
                int expresult = 0;
                if (users.get(3) instanceof Buystandard) {
                    result = 0;
                }
                assertEquals(expresult, result);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    /*
    Testing loadTicket method to load Travis Scott Tour tickets from the text file
     */
    public  void loadTicketsOne(){
        System.out.println("Test 9");
        try {
            File file = new File("/Users/owner/Downloads/TicketingSystem/TicketingSystem/src/avaliableTickets.txt"); //Import availableTickets.txt
            //URL path = ClassLoader.getSystemResource("availableTickets.txt");
            BufferedReader filein = new BufferedReader(new FileReader(file));
            String line;
            String event_name, seller_username;
            int quantity_avaliable;
            double price;
            ArrayList<Ticket> tickets = new ArrayList<Ticket>();


            while(!((line = filein.readLine()).equals("END"))){ //Reads ticket content from file

                event_name = line.substring(0,25);
                seller_username = line.substring(26, 41);
                quantity_avaliable = Integer.parseInt(line.substring(42, 45));
                price = Double.parseDouble(line.substring(46, 52));
                event_name = event_name.trim();
                seller_username = seller_username.trim();
                tickets.add(new Ticket(event_name, seller_username, price, quantity_avaliable)); //Add to ArrayList


                int result = 1;
                int expresult = 0;
                if (tickets.get(0).getEvent_name().equals("Travis Scott Tour") ){
                    result = 0;
                }
                assertEquals(result, expresult);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    /*
    Testing loadTicket method to load The Weekend Tour tickets from the text file
     */
    public  void loadTicketsTwo(){
        System.out.println("Test 10");
        try {
            File file = new File("/Users/owner/Downloads/TicketingSystem/TicketingSystem/src/avaliableTickets.txt"); //Import availableTickets.txt
            //URL path = ClassLoader.getSystemResource("availableTickets.txt");
            BufferedReader filein = new BufferedReader(new FileReader(file));
            String line;
            String event_name, seller_username;
            int quantity_avaliable;
            double price;
            ArrayList<Ticket> tickets = new ArrayList<Ticket>();


            while(!((line = filein.readLine()).equals("END"))){ //Reads ticket content from file

                event_name = line.substring(0,25);
                seller_username = line.substring(26, 41);
                quantity_avaliable = Integer.parseInt(line.substring(42, 45));
                price = Double.parseDouble(line.substring(46, 52));
                event_name = event_name.trim();
                seller_username = seller_username.trim();
                tickets.add(new Ticket(event_name, seller_username, price, quantity_avaliable)); //Add to ArrayList


                int result = 1;
                int expresult = 0;
                if (tickets.get(1).getEvent_name().equals("The Weekend Tour") ){
                    result = 0;
                }
                assertEquals(result, expresult);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    /*
    Testing loadTicket method to load Kayne West Tour tickets from the text file
     */
    public  void loadTicketsThree(){
        System.out.println("Test 11");
        try {
            File file = new File("/Users/owner/Downloads/TicketingSystem/TicketingSystem/src/avaliableTickets.txt"); //Import availableTickets.txt
            //URL path = ClassLoader.getSystemResource("availableTickets.txt");
            BufferedReader filein = new BufferedReader(new FileReader(file));
            String line;
            String event_name, seller_username;
            int quantity_avaliable;
            double price;
            ArrayList<Ticket> tickets = new ArrayList<Ticket>();


            while(!((line = filein.readLine()).equals("END"))){ //Reads ticket content from file

                event_name = line.substring(0,25);
                seller_username = line.substring(26, 41);
                quantity_avaliable = Integer.parseInt(line.substring(42, 45));
                price = Double.parseDouble(line.substring(46, 52));
                event_name = event_name.trim();
                seller_username = seller_username.trim();
                tickets.add(new Ticket(event_name, seller_username, price, quantity_avaliable)); //Add to ArrayList


                int result = 1;
                int expresult = 0;
                if (tickets.get(2).getEvent_name().equals("Kanye West Tour") ){
                    result = 0;
                }
                assertEquals(result, expresult);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}