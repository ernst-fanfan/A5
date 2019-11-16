import java.util.Scanner;

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
     * Paths:
     * From user input*/
    public static void fromUser(){
        BST_Ernst_Fanfan<String> tree = new BST_Ernst_Fanfan<>();//New BST
        Scanner inputString = new Scanner(System.in);//new scanner
        boolean exit = false;

        /**start of method*/
        while(exit != true) {
            System.out.println("Processing from User!");
            Menu_Ernst_Fanfan userInMenu = new Menu_Ernst_Fanfan();//new menu object
            int choice = userInMenu.setChoice(1);//Scan and pass choice
            exit = userProcess(choice);
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
            exit = fileProcess(choice);
        }
    }

    /***************************************************
     * Processing choices
     * Main menu*/
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
    public static boolean userProcess(int choice){
        boolean exit = false;//exit trigger

        /**switch between choices*/
        switch (choice){
            case 0://to main menu
                exit = true;//set to exit
                break;
            case 1://add node
                System.out.println("Adding node");
                break;
            case 2://delete last node
                System.out.println("Deleting node");
                break;
        }
        return exit;//return exit trigger
    }
    /**File menu*/
    public static boolean fileProcess(int choice){
        boolean exit = false;//exit trigger

        /**switch between choices*/
        switch (choice){
            case 0://to main menu
                exit = true;//set to exit
                break;
            case 1://add node
                System.out.println("Displaying file content");
                break;
            case 2://delete last node
                System.out.println("Processing file");
                break;
        }
        return exit;//return exit trigger
    }
}
