//Class: CS 5040
//Term: Fall 2019
//Name: Ernst Fanfan
//Instructor: Dr. Haddad
//Assignment: 5
//IDE Name: IntelliJ

import java.io.*;
import java.util.InputMismatchException;
import java.util.*;

public class RemoveDuplicates_Ernst_Fanfan {
    public static void main (String [] Args){
        boolean exit = false;//exit trigger

        /**Start of program*/
        while(exit != true) {//main loop
            Menu_Ernst_Fanfan start = new Menu_Ernst_Fanfan();//new menu object
            int choice = start.setChoice();//Scan and pass choice
            exit = level2(choice);//process choice and query exit
        }
    }

    /*********************
     * Level 2 of program*
     * *******************/
    private static boolean level2(int choice) {//controls flow to the second lvl of program
        boolean exit = false;//holds exit trigger
        if (choice == 0)
            exit = true;
        else if (choice == 1)
            processFromFile();
        else
            processFromUser();
        return exit;
    }

    /**path 1 start*/
    private static void processFromFile() {//request file path and name from user, load data then pass to lvl 3
        boolean exit = false;
        while (exit != true) {
            try {
                System.out.print("Please provide file to process:\t");
                Scanner inputString = new Scanner(System.in);//new scanner
                String fileName = inputString.nextLine();//scan file name
                Scanner fileContents = new Scanner(new File(fileName));//load file to V-file
                System.out.println("Original text from input file:\n");
                while (fileContents.hasNext()){//display file
                    System.out.print(fileContents.next() +" ");
                }
                BST_Ernst_Fanfan<String> loadedFile = new BST_Ernst_Fanfan<String>();//new BST
                fileContents = new Scanner(new File(fileName));//reload file to V-file
                load2BST(fileContents,loadedFile);
                saveToFile(loadedFile);
                System.out.println("\nProcessed text is saved to output file.");
                exit =  true;
            } catch (FileNotFoundException e) {
                System.out.println("\nFile not fount!\n");
                exit = false;
            }
        }
    }

    /**path 2 start*/
    private static void processFromUser() {//request input from user then pass data to lvl 3
        System.out.print("Please enter text to process:\t");
        Scanner inputLine = new Scanner(System.in);//new scanner
        String lineInputed =  inputLine.nextLine();//scan to string
        System.out.println("Original Text:\n" + lineInputed);//feedback input
        Scanner lineContent = new Scanner(lineInputed);//load string to new scanner
        BST_Ernst_Fanfan<String> loadedFile = new BST_Ernst_Fanfan<String>();//new BST
        load2BST(lineContent, loadedFile);//load input to BST
        System.out.println("\nProcessed Text:");
        loadedFile.inorder();//remove duplicates and display in order
    }

    /*********************
     * Level 3 of Program*
     * *******************/
    /**all paths merge here*/
    private static void load2BST(Scanner fileContents, BST_Ernst_Fanfan<String> loadedFile){//takes in test loads to BST
        while(fileContents.hasNext()){
            loadedFile.insert(fileContents.next());
        }
    }

    /*********************
     * Level 4 of Program*
     * *******************/
    /**save to file*/
    public static void saveToFile(BST_Ernst_Fanfan<String> tree) {
        boolean exit = false;
        while (exit != true) {
            try {
                System.out.print("\nPlease provide output file:\t");
                Scanner inputString = new Scanner(System.in);//new scanner
                String fileName = inputString.nextLine();
                File originalTest = new File(fileName);//creat logical file
                originalTest.createNewFile();//create file
                PrintStream output = new PrintStream(new File(fileName));//create output stream
                Iterator iterator = tree.iterator();//iterate tree
                while (iterator.hasNext()) {//save to file loop
                    output.print(iterator.next() + " "); //read one word at a time
                }
                exit = true;
            } catch (FileNotFoundException e) {
                System.out.println("\nFile not fount!\n");
            } catch (IOException e) {
                System.out.println("\nUnable to save file in that location!\n");
            }
        }
    }
}

