import java.util.*;

/**
 * Admin Class extends User Abstract Class
 * Contains Methods and Variables for Admin instance only
 */
public class Admin extends User {

    /**
     * Constructor
     * @param user_name - User Name
     * @param credit - Credit Amount
     */
    Admin(String user_name, double credit) {
        this.user_name = user_name;
        this.credit = credit;
    }

    /**
     * Create Method - Creates New Users
     */
    public void create(){
        Scanner in = new Scanner(System.in);
        boolean uexists = false;
        String type, username;
        Double amount;

        //Inputted username boundary check
        while(true){
            System.out.println("Please enter the username");
            username = in.nextLine();
            if(username.length() > 15 || username.length()<1){
                System.out.println("This username is too long or empty, try again.");
                continue;
            }else{
                //Checks if the username already exists
                for (int i = 0; i < Frontend.users.size(); i++) {
                    if (Frontend.users.get(i).user_name.equals(username)) {
                        System.out.println("This username already exists.");
                        uexists = true;
                        break;
                    }
                }

                if(uexists){
                    continue;
                }else{
                    break;
                }
            }
        }

        //Setting new user type
        while(true){
            System.out.println("Enter the type of user (AA, BS, SS, FS)");
            type = in.nextLine();

            if(type.equals("AA") || type.equals("BS")|| type.equals("SS") || type.equals("FS")){
                break;
            }else{
                System.out.println("Enter a valid type, try again.");
                continue;
            }
        }

        //Setting new users initial credit amount
        while (true) {
            System.out.println("Enter the amount of credit.");

            try {
                amount = in.nextDouble();

                if (amount > 999999.00 || amount < 0.0) {
                    System.out.println("The amount is invalid, try again.");
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

        //Creates user transaction and adds to ArrayList
        if(type.equals("AA")){
            Frontend.transactions.add(new Admintransaction(1, new Admin(username, amount), amount));
        }else if(type.equals("SS")){
            Frontend.transactions.add(new Admintransaction(1, new Sellstandard(username, amount), amount));
        }else if(type.equals("BS")){
            Frontend.transactions.add(new Admintransaction(1, new Buystandard(username, amount), amount));
        }else{
            Frontend.transactions.add(new Admintransaction(1, new Fullstandard(username, amount), amount));
        }
    }

    /**
     * Delete Method - Delete specified user
     */
    public void delete(){
        String username;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter the username.");
            username = in.nextLine();

            if(username.equals(this.user_name)){
                System.out.println("Can not delete yourself, try again.");
                continue;
            }else{
                break;
            }
        }

        //Deletes the user not immdeiately but puts into delete transaction
        for(int i = 0; i<Frontend.users.size(); i++){
            if(Frontend.users.get(i).getUser_name().equals(username)){
                Frontend.transactions.add(new Admintransaction(2, Frontend.users.get(i), null));
                break;
            }
        }
    }

    /**
     * Refund Method - Refund transaction for user
     */
    public void refund(){
        Scanner in = new Scanner(System.in);
        String buyer;
        String seller;
        Double amount;
        int bindex = 0, sindex = 0;

        while(true){
            while(true){
                boolean deletedU = false;
                System.out.println("Enter the buyer's username: ");
                buyer = in.nextLine();

                //Checks if user has been deleted
                for(int i = 0; i<Frontend.transactions.size(); i++){
                    if(Frontend.transactions.get(i) instanceof Admintransaction){
                        Admintransaction temp = (Admintransaction) Frontend.transactions.get(i);
                        if(temp.getTransaction_code() == 2 && temp.getSubject().user_name.equals(buyer)){
                            System.out.println("This username has been deleted, try again.");
                            deletedU = true;
                            break;
                        }
                    }
                }

                if(deletedU == false){
                    break;
                }else{
                    continue;
                }
            }
            boolean exists = false;

            for(int i = 0; i<Frontend.users.size(); i++){
                if(Frontend.users.get(i).getUser_name().equals(buyer)){
                    exists = true;
                    bindex = i;
                    break;
                }
            }

            //Prints user cannot be found
            if(exists){
                break;
            } else{
                System.out.println("Can't find the user, try again: ");
                continue;
            }
        }

        while(true){
            while(true){
                boolean deletedU = false;
                System.out.println("Enter the seller's username.");
                seller = in.nextLine();

                for(int i = 0; i<Frontend.transactions.size(); i++){
                    if(Frontend.transactions.get(i) instanceof Admintransaction){
                        Admintransaction temp = (Admintransaction) Frontend.transactions.get(i);

                        if(temp.getTransaction_code() == 2 && temp.getSubject().user_name.equals(seller)){
                            System.out.println("This username has been deleted, try again.");
                            deletedU = true;
                            break;
                        }
                    }
                }

                if(deletedU == false){
                    break;
                }else{
                    continue;
                }
            }
            boolean exists = false;

            for(int i = 0; i<Frontend.users.size(); i++){
                if(Frontend.users.get(i).getUser_name().equals(seller)){
                    exists = true;
                    sindex = i;
                    break;
                }
            }

            if(exists){
                break;
            }else{

                System.out.println("Can't find the user, try again.");
                continue;
            }
        }
        while(true) {

            System.out.println("Enter the amount to refund.");
            try{
                amount = in.nextDouble();
            }catch (Exception e){
                System.out.println("Invalid input");
                in = new Scanner(System.in);
                continue;
            }

            break;

        }
        //creates a refund transaction
        Frontend.transactions.add(new Refund(5, Frontend.users.get(bindex), Frontend.users.get(sindex), amount));
    }

    /**
     * AddCredit Method - Adds credit to user
     */
    public void addcredit(){
        Scanner in = new Scanner(System.in);
        Double amount;
        String user;
        int userindex = 0;

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

        while(true){
            while(true){
                boolean deletedU = false;
                in = new Scanner(System.in);
                System.out.println("Enter the username.");
                user = in.nextLine();

                for(int i = 0; i<Frontend.transactions.size(); i++){
                    if(Frontend.transactions.get(i) instanceof Admintransaction){
                        Admintransaction temp = (Admintransaction) Frontend.transactions.get(i);

                        if(temp.getTransaction_code() == 2 && temp.getSubject().user_name.equals(user)){
                            System.out.println("This username has been deleted, try again.");
                            deletedU = true;
                            break;
                        }
                    }
                }

                if(deletedU == false){
                    break;
                }else{
                    continue;
                }
            }

            boolean exists = false;

            for(int i = 0; i<Frontend.users.size(); i++){
                if(Frontend.users.get(i).getUser_name().equals(user)){
                    exists = true;
                    userindex = i;
                    break;
                }
            }

            if(exists){
                break;
            }else{

                System.out.println("Can't find the user, try again.");
                continue;
            }
        }

        //Creates a add credit transaction
        Frontend.transactions.add(new Admintransaction(6, Frontend.users.get(userindex), amount));

    }
}
