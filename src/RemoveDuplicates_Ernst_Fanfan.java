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
            int choice = start.setChoice(0);//Scan and pass choice
            exit = process(choice);//process choice and query exit
        }
    }

    /***************************************************
     * Support methods
     ***************************************************/
    /**Adding Node Loop*/
    public static void addingNodeLoop(Stack_Ernst_Fanfan<String> originalTest){
        boolean exit = false;//exit trigger

        while(exit != true){//adding node loop
            Menu_Ernst_Fanfan addNodeMenu = new Menu_Ernst_Fanfan();//new menu object
            int choice = addNodeMenu.setChoice(3);//Scan and pass choice
            exit = addNodeProcess(choice, originalTest);//process choice and query exit
        }
    }

    /**removing duplicates*/
    public static void removeDuplicate(BST_Ernst_Fanfan<String> tree, Stack_Ernst_Fanfan<String> originalText){
        while (originalText.isEmpty()!=true){
            tree.insert(originalText.top());
            originalText.pop();
        }
    }

    /**load file*/
    public static void loadFile(BST_Ernst_Fanfan<String> tree) throws IOException {
        File originalTest = new File("OriginalTest.txt");//creat logical file
        originalTest.createNewFile();//create file
        PrintStream output= new PrintStream("OriginalTest.txt");
        output.print("Following the test programs above, write a new test program called\n" +
                "RemoveDuplicates.java. The program reads text input from keyboard or a text file\n" +
                "and adds the words to a BST. The program then traverses the BST and prints out the\n" +
                "words in order on the screen (or to output text file). Note that you may need to\n" +
                "make some changes to BST.java.");
        Scanner input= new Scanner(originalTest);//load file into scanner
        System.out.println("Original Text from input file:");
        while (input.hasNext()){//display loop
            tree.insert(input.next()); //read one word at a time
            System.out.print(input.next()+" ");//Display one word at a time
        }
    }
    /**Save to file*/
    public static void saveToFile(BST_Ernst_Fanfan<String> tree) throws IOException {
        File originalTest = new File("ProcessedText.txt");//creat logical file
        originalTest.createNewFile();//create file
        PrintStream output= new PrintStream(new File("ProcessedText.txt"));//create output stream
        Iterator iterator = tree.iterator();//iterate tree
        while (iterator.hasNext()){//save to file loop
            output.print(iterator.next()+" "); //read one word at a time
        }
    }

    /***************************************************
     * Paths:
     ***************************************************/
     /**From user input*/
    public static void fromUser(){
        BST_Ernst_Fanfan<String> tree = new BST_Ernst_Fanfan<>();//New BST
        Stack_Ernst_Fanfan<String> originalTest = new Stack_Ernst_Fanfan<>();
        Scanner inputString = new Scanner(System.in);//new scanner
        boolean exit = false;

        /**start of method*/
        while(exit != true) {
            System.out.println("Processing from User!");
            Menu_Ernst_Fanfan userInMenu = new Menu_Ernst_Fanfan();//new menu object
            int choice = userInMenu.setChoice(1);//Scan and pass choice
            exit = userProcess(choice, tree, originalTest);
        }
    }
    /**From file*/
    public static void fromFile(){
        BST_Ernst_Fanfan<String> tree = new BST_Ernst_Fanfan<>();//New BST
        Scanner inputString = new Scanner(System.in);//new scanner
        boolean exit = false;

        /**start of method*/
        while(exit != true) {
            System.out.println("Processing from file!");
            Menu_Ernst_Fanfan fileMenu = new Menu_Ernst_Fanfan();//new menu object
            int choice = fileMenu.setChoice(2);//Scan and pass choice
            exit = fileProcess(choice, tree);
        }
    }

    /***************************************************
     * Processing choices
     ***************************************************/
     /** Main menu*/
    public static boolean process(int choice){
        boolean exit = false;//exit trigger

        /**switch between choices*/
        switch (choice){
            case 0://exit
                System.out.println("Goodye!");
                exit = true;//set to exit
                break;
            case 1://from file
                fromFile();
                break;
            case 2://from user
                fromUser();
                break;
        }
        return exit;//return exit trigger
    }
    /**User input menu*/
    public static boolean userProcess(int choice, BST_Ernst_Fanfan<String> tree, Stack_Ernst_Fanfan<String> originalTest){
        boolean exit = false;//exit trigger

        /**switch between choices*/
        switch (choice){
            case 0://to main menu
                exit = true;//set to exit
                break;
            case 1://add node
                System.out.println("Adding node");
                addingNodeLoop(originalTest);
                System.out.println("Current Tree:");
                originalTest.printStack();
                System.out.println();

                break;
            case 2://remove duplicate
                System.out.println("Removing Duplicates");
                System.out.println("\nOriginal Text:");
                originalTest.printStack();
                removeDuplicate(tree,originalTest);
                System.out.println("\nProcessed Text:");
                tree.inorder();
                break;
        }
        return exit;//return exit trigger
    }
    /**Add Node menu*/
    public static boolean addNodeProcess(int choice, Stack_Ernst_Fanfan<String> originalText){
        boolean exit = false;//exit trigger
        Scanner inputString = new Scanner(System.in);//New String Scanner

        /**switch between choices*/
        switch (choice){
            case 0://to main menu
                exit = true;//set to exit
                break;
            case 1://add node
                System.out.print("Enter content of node:\t");
                originalText.push(inputString.nextLine());
                System.out.println("Current Text:\t");
                originalText.printStack();
                exit = false;
                break;
            case 2:
                System.out.println("Removing "+originalText.top());//inform user
                originalText.pop();
                System.out.println("Current Text:\t");
                originalText.printStack();
                exit = false;
                break;
        }
        return exit;//return exit trigger
    }
    /**File menu*/
    public static boolean fileProcess(int choice, BST_Ernst_Fanfan<String> tree){
        boolean exit = false;//exit trigger

        /**switch between choices*/
        switch (choice){
            case 0://to main menu
                exit = true;//set to exit
                break;
            case 1://load file and display
                System.out.println("Displaying file content");
                try {
                     loadFile(tree);
                } catch (IOException e) {
                    System.out.println("File not found. Please make sure file is within folder.");
                }
                break;
            case 2://Remove duplicate
                System.out.println("Processing file");
                System.out.println("Displaying file content");
                try {
                    loadFile(tree);
                    System.out.println("\nProcessed text is saved to output file.");
                    saveToFile(tree);
                } catch (IOException e) {
                    System.out.println("File not found. Please make sure file is within folder.");
                }
                break;
        }
        return exit;//return exit trigger
    }
}
