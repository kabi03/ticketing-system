import java.util.ArrayList;

/**
 * Buysell Method that includes Transaction Class Methods and Variables
 * @author Jad-PC
 */
public class Buysell extends Transaction{
    private int quantity;
    private Ticket tickets;

    /**
     * Buysell Constructor to initialize object when called
     * @param transaction_code
     * @param quantity
     * @param tickets
     */
    Buysell(int transaction_code, int quantity, Ticket tickets){
        this.transaction_code = transaction_code;
        this.quantity = quantity;
        this.tickets  = tickets;
    }

    /**
     * Setter Method for Tickets
     * @param tickets
     * @param quantity
     */
    public void setTickets(Ticket tickets, int quantity) {
        this.tickets = tickets;
        this.quantity = quantity;
    }

    /**
     * Getter Method for Tickets
     * @return
     */
    public Ticket getTickets() {
        return tickets;
    }

    /**
     * Setter Method for Quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter Method for Quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }
}
