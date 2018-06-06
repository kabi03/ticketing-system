public class Sellstandard extends Regular {

    /**
     * Sellstandard Constructor to initialize object when called
     * @param user_name
     * @param credit
     */
    Sellstandard(String user_name, Double credit){
        this.user_name = user_name;
        this.credit = credit;
    }

    /**
     * Buy Method - Printout Error
     */
    public void buy() {
        System.out.println("You are a sell standard, you can't buy tickets.");
    }
}
