/**
 * Refund Class that includes Transaction Class Methods and Variables
 * @author Jad-PC
 */
public class Refund extends Transaction{
    private User buyer;
    private User seller;
    private double refund_amount;

    /**
     * Refund Constructor to initialize object when called
     * @param transaction_code
     * @param buyer
     * @param seller
     * @param refund_amount
     */
    Refund(int transaction_code, User buyer, User seller, double refund_amount){
        this.transaction_code = transaction_code;
        this.buyer = buyer;
        this.seller = seller;
        this.refund_amount = refund_amount;
    }

    /**
     * Setter Method for Buyer
     * @param buyer
     */
    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    /**
     * Setter Method for Refund Amount
     * @param refund_amount
     */
    public void setRefund_amount(double refund_amount) {
        this.refund_amount = refund_amount;
    }

    /**
     * Setter Method for Seller
     * @param seller
     */
    public void setSeller(User seller) {
        this.seller = seller;
    }

    /**
     * Getter Method for Refund Amount
     * @return
     */
    public double getRefund_amount() {
        return refund_amount;
    }

    /**
     * Getter Method for Buyer
     * @return
     */
    public User getBuyer() {
        return buyer;
    }

    /**
     * Getter Method for Seller
     * @return
     */
    public User getSeller() {
        return seller;
    }
}
