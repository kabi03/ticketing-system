import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * Admin class Test Cases
 * @author Jadhushan Vivekanandan 500626549
 * @author Kabilan Veerasingam 500558923
 * @author Yanani Sachiharan 500635360
 * @author Anutharshan Logeswaran 500612736
 */

import static org.junit.Assert.*;

public class AdminTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    /*
    Testing create method to satisfy the if statement using valid length of the username
     */
    public void createOne() {
        System.out.println("Test 12");
        {
            String username = "Yanani";
            int result;
            int expresult=1;
            if(username.length() > 15 || username.length()<1){
                result =0;
                System.out.println("This username is too long or empty, try again.");
            }else{
                result =1;
            }
            assertEquals(result,expresult);
        }
    }
    @Test
    /*
    Testing create method to satisfy the if statement using invalid length of the username
     */
    public void createTwo() {
        System.out.println("Test 13");
        {
            String username = "Yananisaciharan23081996";
            int result;
            int expresult=0;
            if(username.length() > 15 || username.length()<1){
                result =0;
            }else{
                result =1;
            }
            assertEquals(result,expresult);
        }
    }
    @Test
    /*
    Testing create method to check if statements using valid user type (AA) admin
     */
    public void createThree() {
        System.out.println("Test 14");
        {
            String type = "AA";
            int result;
            int expresult=0;
            {
                if(type.equals("AA") || type.equals("BS")|| type.equals("SS") || type.equals("FS")){
                    result=0;
                }
                else{
                   result =1;
                }
            }
            assertEquals(result,expresult);
        }
    }

    @Test
    /*
    Testing create method to check if statements using invalid user type (AB)
     */
    public void createFour() {
        System.out.println("Test 15");
        {
            String type = "AB";
            int result;
            int expresult=0;
            {
                if(type.equals("AA") || type.equals("BS")|| type.equals("SS") || type.equals("FS")){
                    result=0;
                }
                else{
                    result =1;
                }
            }
            assertNotEquals(result,expresult);
        }
    }

    @Test
    /*
    Testing create method to check if statements using valid user type (BS) Buy Standard
     */
    public void createFive() {
        System.out.println("Test 16");
        {
            String type = "BS";
            int result;
            int expresult=0;
            {
                if(type.equals("AA") || type.equals("BS")|| type.equals("SS") || type.equals("FS")){
                    result=0;
                }
                else{
                    result =1;
                }
            }
            assertEquals(result,expresult);
        }
    }


        @Test
        /*
        Testing create method to check the if statements using valid credit amount (100.00)
         */
        public void createSix() {
        System.out.println("Test 17");
        int result;
        int expresult = 1;
        {
            try {
                double amount = 100.00;
                if (amount > 999999.00 || amount < 0.0) {
                    result = 0;
                } else {
                    result = 1;
                }
                assertEquals(result, expresult);
            } catch (Exception e) {
                System.out.println("Invalid input");

            }

        }
    }

    @Test
    /*
    Testing create method to check the  if statements using invalid credit amount (1000000000000000000.00)
     */
    public void createSeven() {
        System.out.println("Test 18");
        int result;
        int expresult = 1;
        {
            try {
                double amount = 1000000000000000000.00;
                if (amount > 999999.00 || amount < 0.0) {
                    result = 0;
                } else {
                    result = 1;
                }
                assertNotEquals(result, expresult);
            } catch (Exception e) {
                System.out.println("Invalid input");

            }

        }
    }



    @Test
    /*
    Testing delete method to check the if statements using the same username as logged in
     */
    public void deleteOne() {
        {
            System.out.println("Test 19");
            String username = "vkabilan";
            String user_name = "vkabilan";
            int result;
            int expresult = 1;
            ;
            if (username.equals(user_name)) {
                result = 1;
            } else {
                result = 0;
            }
        }
    }
        @Test
        /*
        Testing delete method to check the if statements using the different username as logged in
         */
        public void deleteTwo()
            {
                System.out.println("Test 20");
                String username = "anu";
                String user_name = "vkabilan";
                int result;
                int expresult = 1;
                if (username.equals(user_name)) {
                    result = 0;
                } else {
                    result = 1; }
            }



    @Test
    /*
    Testing add credit method to check the if statements using valid credit amount (1000)
     */
    public void addcreditOne() {
        System.out.println("Test 21 ");
        try
        {
            int amount = 100;
            int result ;
            int expresult=1;
            if (amount <= 1000 && amount > 0) {
                result =1;
            }
            else {
               result =0;
            }
            assertEquals(result,expresult);
        }
        catch (Exception e){
        }
    }

    @Test
    /*
    Testing add credit method to check the if statements using invalid credit amount (10000000000)
     */
    public void addcreditTwo() {
        System.out.println("Test 22 ");
        try
        {
            int amount = 1000000000;
            int result ;
            int expresult=1;
            if (amount <= 1000 && amount > 0) {
                result =1;
            }
            else {
                result =0;
            }
            assertNotEquals(result,expresult);
        }
        catch (Exception e){
        }
    }
    }
