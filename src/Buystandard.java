/**
 * Buystandard Class that is an instance of Regular Abstract Class
 * @author Jad-PC
 */
public class Buystandard extends Regular {

    /**
     * Buystandard Constructor to initialize object when called
     * @param user_name
     * @param credit
     */
    Buystandard(String user_name, Double credit){
        this.user_name = user_name;
        this.credit = credit;
    }

    @Override
    public void sell() {
        System.out.println("You are a buy standard, you can't sell tickets!");
    }
}
