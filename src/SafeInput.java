/**
 *
 * @author Daniel Sandy sandyds@mail.uc.edu
 */

import java.util.Scanner; // import Scanner class

public class SafeInput // class SafeInput library
{
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) // method to return a non-zero length string
    {
        String retString = ""; // set this to zero length & run loop until it is not zero length
        do // input validation check
        {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine(); // save input into retString
        }while (retString.length() == 0); // ensure user cannot just press enter

        return retString; // return user input

    } // end method

    /**
     *
     * @param pipe a Scanner to read from System.in
     * @param prompt prompt for user
     * @return an integer response
     */
    public static int getInt(Scanner pipe, String prompt) // method to get an integer
    {
        int value = 0; // declare & initialize the integer
        boolean isDone = false; // set isDone to false
        String trash = ""; // store user trash input in variable
        do // validate user input
        {
            System.out.print("\n" + prompt + ": "); // output the prompt
            if (pipe.hasNextInt()) // if user inputs an integer
            {
                value = pipe.nextInt(); // save integer in value variable
                pipe.nextLine(); // newline to clear buffer
                isDone = true; // stop the do while loop
            }
            else // if user inputs a non integer
            {
                trash = pipe.nextLine(); // save their trash input
                System.out.println("You must enter a valid number not: " + trash); // throw trash back at them
            }
        }while (!isDone); // only stop loop if user input an integer

        return value; // return the user's integer
    } // end method

    /**
     *
     * @param pipe a Scanner to read from System.in
     * @param prompt prompt for user
     * @return a double response
     */
    public static double getDouble(Scanner pipe, String prompt) // method to get a double
    {
        double value = 0.0; // declare & initialize the double
        boolean isDone = false; // set isDone to false
        String trash = ""; // store user trash input in variable
        do // validate user input
        {
            System.out.print("\n" + prompt + ": "); // output the prompt
            if (pipe.hasNextDouble()) // if user inputs a double
            {
                value = pipe.nextDouble(); // save user double
                pipe.nextLine(); // newline to clear buffer
                isDone = true; // stop the do while loop
            }
            else // if user inputs a non double
            {
                trash = pipe.nextLine(); // save their trash input
                System.out.println("You must enter a valid number not: " + trash); // throw trash input back at user
            }
        }while (!isDone); // only stop loop if user inputs a double

        return value; // return user's double

    } // end method

    /**
     *
     * @param pipe a Scanner to read from System.in
     * @param prompt prompt for user
     * @param low minimum value
     * @param high maximum value
     * @return an integer response in a range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) // method to get an integer in a range
    {
        int value = 0; // declare & initialize the integer
        boolean isDone = false; // set isDone to false
        String trash = ""; // store user trash input
        do // validate user input
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: "); // output the prompt
            if (pipe.hasNextInt()) // if user input an integer
            {
                value = pipe.nextInt(); // save user integer in value
                pipe.nextLine(); // newline to clear buffer
                if (value >= low && value <= high) // if integer is in range
                {
                    isDone = true; // end do while loop
                }
                else // if user integer is not in range
                {
                    System.out.println("Number is out of range [" + low + " - " + high + "] not: " + value); // reject user input since it is out of range
                }
            } // end if
            else // if user did not input an integer
            {
                trash = pipe.nextLine(); // save their trash input
                System.out.println("You must enter a valid number not: " + trash); // throw user trash input back at them
            }
        }while(!isDone); // only end loop with valid integer in specified range

        return value; // return acceptable integer

    } // end method

    /**
     *
     * @param pipe a Scanner to read from System.in
     * @param prompt prompt for user
     * @param low minimum value
     * @param high maximum value
     * @return a double response in a range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) // method to get a double in a range
    {
        double value = 0.0; // declare & initialize double in value
        boolean isDone = false; // set isDone to false
        String trash = ""; // variable to store invalid user input
        do // validate user input
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: "); // output the prompt
            if (pipe.hasNextDouble()) // if user input a double
            {
                value = pipe.nextDouble(); // save that double in value
                pipe.nextLine(); // newline to clear buffer
                if (value >= low && value <= high) // if the double is in the specified range
                {
                    isDone = true; // end the do while loop
                }
                else // if user double is not in range
                {
                    System.out.println("Number is out of range [" + low + " - " + high + "] not: " + value); // reject their double since out of range
                }
            }
            else // if user input something other than a double
            {
                trash = pipe.nextLine(); // save their trash input
                System.out.println("You must enter a valid number not: " + trash); // throw trash input back at user
            }
        }while(!isDone); // only end loop if user input valid double in specified range

        return value; // return valid input

    } // end method

    /**
     *
     * @param pipe a Scanner to read System.in
     * @param prompt prompt for user
     * @return a boolean response
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) // method for user to enter Y or N
    {
        String yNConfirm = "Y"; // declare & initialize Y in variable
        boolean yNConfirmed = false; // set YNConfirmed to false
        boolean isDone = false; // set isDone to false
        do { // validate user input
            System.out.print("\n" + prompt + " [Y/N]: "); // output prompt
            yNConfirm = pipe.nextLine(); // save user input in variable
            if (yNConfirm.equalsIgnoreCase("Y")) // if user entered Y or y
            {
                yNConfirmed = true; // set Y equal to true
                isDone = true; // end do while loop
            }
            else if (yNConfirm.equalsIgnoreCase("N")) // if user entered N or n
            {
                yNConfirmed = false; // set N value to false
                isDone = true; // end do while loop
            }
            else // if user entered an invalid response
            {
                System.out.println("You must enter a valid response [Y/N] not: " + yNConfirm); // throw trash input back at them
                isDone = false; // restart the do while loop
            }
        }while (!isDone); // only end loop after user entered Y, y, N, or n

        return yNConfirmed; // return true for user input Y/y & false for user input N/n

    } // end method

    /**
     *
     * @param pipe a Scanner to read System.in
     * @param prompt prompt for user
     * @param regEx pattern that input must follow
     * @return String response that fits regEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) // method to ensure user input follows specified format
    {
        String userInput = ""; // delcare & initialize variable to store user input
        boolean thisWorks = false; // set thisWorks to false
        do // validate user input
        {
            System.out.print("\n" + prompt + ": "); // output prompt
            userInput = pipe.nextLine(); // save user input
            if (userInput.matches(regEx)) // if user input follows specified format
            {
                thisWorks = true; // end do while loop
            }
            else // if user input is not in correct format
            {
                System.out.println("Formatting error: " + userInput); // output to let user know that they did not enter accurate information
            }
        }while(!thisWorks); // end do while loop when user inputs information that follows correct format

        return userInput; // return user input in correct format

    } // end method

    /**
     *
     * @param pipe a Scanner to read System.in
     * @param prompt prompt for user
     */
    public static void prettyHeader(Scanner pipe, String prompt) // method to display a user message with a header
    {
        System.out.println(); // clear a line for visual effects
        String message = ""; // declare & intitialize a variable to save user input
        System.out.print(prompt + ": "); // output prompt
        message = pipe.nextLine(); // save user input
        System.out.println(); // clear a line for visual effects
        int messageLength = message.length(); // length of user's input
        int totalSpace = 54 - messageLength; // total space 60 minus 6 star minus length of user's message
        int leftSpace = totalSpace / 2; // space on left after three stars
        int rightSpace = totalSpace - leftSpace; // space on right before 3 stars
        for (int i = 0; i < 60; i++) // loop for top line of 60 stars
        {
            System.out.print("*"); // print top line
        } // end loop
        System.out.println(); // drop to newline
        System.out.print("***"); // print three stars at beginning of 2nd line
        for (int i = 0; i < leftSpace; i++) // loop to create space on left so message is centered
        {
            System.out.print(" "); // space between 3 stars and message
        } // end loop
        System.out.print(message); // print message on same line as prior loop & same line as the next one
        for (int i = 0; i < rightSpace; i++) // loop for space to right of message and left of last 3 stars on 2nd line
        {
            System.out.print(" "); // printing space
        } // end loop
        System.out.print("***"); // print three stars at end of line 2
        System.out.println(); // move to line 3
        for (int i = 0; i < 60; i++) // loop for third line of 60 stars
        {
            System.out.print("*"); // print bottom line
        }
        System.out.println(); // print line at very end for visual effects
    } // end method
} // end class
