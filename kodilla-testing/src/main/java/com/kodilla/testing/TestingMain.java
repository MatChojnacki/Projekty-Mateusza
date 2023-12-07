
package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;
public class TestingMain {
        public static void main(String[] args) {
            SimpleUser simpleUser = new SimpleUser("theForumUser");

            String result = simpleUser.getUsername();

            if (result.equals("theForumUser")) {
                System.out.println("test OK");
            } else {
                System.out.println("Error!");
            }

            Calculator calculator = new Calculator();

            int result1 = calculator.add(5,3);
            int result2 = calculator.subtract(20,14);

            if (result1 == 8) {
                System.out.println("Test result1 finished Positive ");
            } else {
                System.out.println("Test result1 finished Negative ");
            }

            if (result2 == 6) {
                System.out.println("Test result2 finished Positive ");
            } else {
                System.out.println("Test result2 finished Negative ");
            }





        }
    }