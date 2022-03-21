package PasswordGenerator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


	// Ask the user for how many passwords they want and the length of the password
        Scanner sc = new Scanner(System.in);
        System.out.println("How many random passwords you want to generate?");
        int total =  sc.nextInt();
        System.out.println("How many characters long password do you want to generate?");
        int length = sc.nextInt();

        //creating array to store random passwords
        String[] randomPasswords = new String[total];

        //loop for total number of passwords
        for(int i = 0;i < total; i++)
        {
            //generate one random password
            String randomPassword = "";
            for(int j = 0;j < length; j++)
            {
                //generate one random character
                randomPassword = randomPassword + randomCharacter();
            }
            //add our random password to the array
            randomPasswords[i] = randomPassword;

        }

        //printing the passwords
        printPasswords(randomPasswords);

        //printing password strength
        System.out.println(getPasswordStrength(length));
    }
    //0-9 ==> 48-57 in ASCII
    //A-Z ==> 65-90 in ASCII
    //a-z ==> 97-122 in ACII

    public static char randomCharacter() {
        //Generate a random number that represents all possible characters in our password
        //10digits + 26 uppercase letters + 26 lowercaseletters =  62 possible characters
        int rand = (int)(Math.random()*62);

        //break rand into intervals to represent digits, uppercase letters, Lowercase letters
        //if rand is in between 0-9 it is digit
        //if rand is in between 10-35 it is uppercase letter
        //if rand is in between 35-61 it is lowercase letter

        if(rand<=9)
        {
            //digit
            //converting 0-9 digit to ASCII value
            int ascii = rand + 48;
            return (char)(ascii);
        }
        else if(rand <= 35)
        {
            //uppercase
            //converting 10-35 uppercase to 65-90 ASCII value
            int ascii = rand + 55;
            return (char)(ascii);
        }
        else
        {
            //lowercase
            //converting 36-61 lowercase to 97-122 ASCII value
            int ascii = rand + 61;
            return (char)(ascii);
        }
    }

    public static void printPasswords(String[] arr)
    {
        for(int i = 0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    public static String getPasswordStrength(int length)
    {
        if(length < 8)
            return "weak";
        else if(length < 10)
            return "moderate";
        else
            return "strong";
    }

}
