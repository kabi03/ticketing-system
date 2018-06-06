/**
 * Ticket Class
 * @author Jad-PC
 */
public class Ticket {
    private String event_name;
    private String seller_username;
    private double price;
    private int quantity_avaliable;

    /**
     * Ticket Constructor to initialize object when called
     * @param event_name
     * @param seller_username
     * @param price
     * @param quantity_avaliable
     */
    Ticket(String event_name, String seller_username, double price, int quantity_avaliable){
        this.event_name = event_name;
        this.seller_username = seller_username;
        this.price = price;
        this.quantity_avaliable = quantity_avaliable;

    }

    /**
     * Setter Method for Event Name Variable
     * @param event_name
     */
    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    /**
     * Setter Method for Seller Username Variable
     * @param seller_username
     */
    public void setSeller_username(String seller_username) {
        this.seller_username = seller_username;
    }

    /**
     * Setter Method for Price Variable
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Setter Method for Quantity Available Variable
     * @param quantity_avaliable
     */
    public void setQuantity_avaliable(int quantity_avaliable) {
        this.quantity_avaliable = quantity_avaliable;
    }

    /**
     * Getter Method for Event Name Variable
     * @return
     */
    public String getEvent_name() {
        return event_name;
    }

    /**
     * Getter Method for Seller User Name Variable
     * @return
     */
    public String getSeller_username() {
        return seller_username;
    }

    /**
     * Getter Method for Price Variable
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter Method for Quantity Available Method
     * @return
     */
    public int getQuantity_avaliable() {
        return quantity_avaliable;
    }

}
