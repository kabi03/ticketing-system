/**
 * Admintransaction Class that includes Transaction Class Methods and Variables
 * @author Jad-PC
 */
public class Admintransaction extends Transaction{
    private User subject;
    private Double amountt;

    /**
     * Admintransaction Constructor to initialize object when called
     * @param transaction_code
     * @param subject
     * @param amount
     */
    Admintransaction(int transaction_code, User subject, Double amount){
        this.transaction_code = transaction_code;
        this.subject = subject;
        this.amountt = amount;
    }

    /**
     * Setter Method for Subject
     * @param subject
     */
    public void setSubject(User subject) {
        this.subject = subject;
    }

    /**
     * Getter Method for Subject
     * @return
     */
    public User getSubject() {
        return subject;
    }

    public void setAmountt(Double amountt) {
        this.amountt = amountt;
    }

    public Double getAmountt() {
        return amountt;
    }
}
