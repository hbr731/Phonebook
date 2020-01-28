package javaapplication2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavaApplication2 {

    private static Scanner kybd = new Scanner(System.in);

    //main function
    public static void main(String[] args) throws IOException {
        PhoneBook pb = new PhoneBook();
        readData(pb);
        workWithData(pb);

        kybd.close();
    }

    //work with the given data
    private static void workWithData(PhoneBook pb) throws FileNotFoundException {
    	PrintWriter outputFile = new PrintWriter("myout.txt");
        boolean flag = false;
        char operation;
        String name, number;
        
        //keep the program running till user enters 'q'
        while (flag != true) {
            System.out.println("Enter L to lookup a phone number or "
                    + "enter R to reverse lookup or q to quit: ");
            
            operation = Character.toLowerCase(kybd.next().charAt(0));
            outputFile.println(operation);
            
            switch (operation) {
                case 'l':
                    System.out.println("Enter the name");
                    name = kybd.next();
                    System.out.println(pb.searchByName(name));
                    outputFile.println(pb.searchByName(name));
                    outputFile.flush();
                    break;
                case 'r':
                    System.out.println("Enter the phone number");
                    number = kybd.next();
                    System.out.println(pb.searchByNumber(number));
                    outputFile.println(pb.searchByNumber(number));
                    outputFile.flush();
                    break;
                case 'q':
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid input! Please try again.");
                    outputFile.println("Invalid input! Please try again.");
                    outputFile.flush();
                    break;
            }
        }
        outputFile.close();
    }

    //read the data from the input file
    private static void readData(PhoneBook pb) throws IOException {
        File myfile = new File("myinput.txt");
        Scanner inputFile = new Scanner(myfile);

        while (inputFile.hasNextLine()) {
            pb.add(inputFile.next(), inputFile.next());
        }

        inputFile.close();
    }
}
