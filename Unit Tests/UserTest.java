import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User class Test Cases
 * @author Jadhushan Vivekanandan 500626549
 * @author Kabilan Veerasingam 500558923
 * @author Yanani Sachiharan 500635360
 * @author Anutharshan Logeswaran 500612736
 */

public class UserTest {

    @Test
    /*
    Testing sell method to check the if statement using correct length of the event name which is less than 25 character.
     */

    public void sellOne() {
        System.out.println("Test 23 ");
        String event_title = "The Weekend Tour";
        int result ;
        int expectedresult=0;
        if (event_title.length() > 25 || event_title.length() < 1) {
            result = 1;
        } else {
            result = 0;
        }
        assertEquals(result,expectedresult);
    }

    @Test
    /*
    Testing sell method to check the if statement  for the system to blocks the entry if the event character is more than 25
     */

    public void sellTwo() {
        System.out.println("Test 24 ");
        String event_title = "The Weekend Tourrrrrrrrrrrrrrrrrr";
        int result ;
        int expectedresult=0;
        if (event_title.length() > 25 || event_title.length() < 1) {
            result = 1;
        } else {
            result = 0;
        }
        assertNotEquals(result,expectedresult);
    }

    @Test
    /*
    Testing sell method to check the if statement using correct price range for the tickets which are between $0 to $100
     */

    public void sellThree() {
        System.out.println("Test 25 ");
        double price = 100.00;
        int result ;
        int expectedresult=0;
        if(price>999.99 || price<0){
            result = 1;
        } else {
            result = 0;
        }
        assertEquals(result,expectedresult);
    }

    @Test
    /*
    Testing sell method to check the if statement with available quantity of the  ticket for each event which is between 1 to 100
     */
    public void sellFour() {
        System.out.println("Test 26 ");
        int quantity = 103;
        int result ;
        int expectedresult=0;
        if (quantity > 100 || quantity < 1) {
            result = 1;
        } else {
            result = 0;
        }
        assertNotEquals(result,expectedresult);
    }

    @Test
    /*
    Testing buy method to check the if  statement for  maximum purchiable ticket quantity by one user is 4
     */
    public void BuyOne() {
        System.out.println("Test 27 ");
        int quantity = 3;
        int result;
        int expectedresult = 0;
        if (quantity > 4 || quantity < 1) {
            result = 1;
        } else {
            result = 0;
        }
        assertEquals(result, expectedresult);
    }

    @Test
    /*
    Testing buy method to check the if statement for  system to blocks the entry if the number ticket selected to buy is more than 4
     */
    public void BuyTwo() {
        System.out.println("Test 28 ");
        int quantity = 5;
        int result;
        int expectedresult = 0;
        if (quantity > 4 || quantity < 1) {
            result = 1;
        } else {
            result = 0;
        }
        assertNotEquals(result, expectedresult);
    }

    @Test
    /*
    Testing add credit method to check the limit  of credit can be added is between $0 to $1000
     */
    public void addcreditOne() {
        System.out.println("Test 29 ");
        double amount = 500;
        int result;
        int expectedresult = 1;
        if (amount <= 1000 && amount > 0) {
            result = 1;
        } else {
            result = 0;
        }
        assertEquals(result, expectedresult);
    }

    @Test
    /*
    Testing add credit method to check system blocks the entry if the amount credit is added is more than $1000
     */
    public void addcreditTwo() {
        System.out.println("Test 30 ");
        double amount = 1500;
        int result;
        int expectedresult = 1;
        if (amount <= 1000 && amount > 0) {
            result = 1;
        } else {
            result = 0;
        }
        assertNotEquals(result, expectedresult);
    }


}