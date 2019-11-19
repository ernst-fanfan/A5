import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Ernst_Fanfan {
    //states
    private int choice =-1;

    public void startMenu(){
        System.out.println("\n \n-----MAIN MENU-----\n" +
                "0 - Exit Program\n" +
                "1 – Read Input From Text File\n" +
                "2 – Read Input Form Keyboard");
    }

    public void fromUserMenu(){
        System.out.println("\n \n-----USER MENU-----\n" +
                "0 - Main Menu\n" +
                "1 – Add Node\n" +
                "2 - Remove Duplicates");
    }

    public void fromFileMenu(){
        System.out.println("\n \n-----FILE MENU-----\n" +
                "0 - Main Menu\n" +
                "1 – Load and Display file content\n" +
                "2 - Process File");
    }

    public void addNodeMenu(){
        System.out.println("\n \n-----ADD NODE MENU-----\n" +
                "0 - User Menu\n" +
                "1 – Add Node\n"+
                "2 - Remove Last Node");
    }

    /**updating choice from user*/
    public int setChoice(int menu){
        Scanner intInput =  new Scanner(System.in);//scanner
        boolean continueLoop = true;//exit loop trigger
        do {//data validation loop
            try{//exception handling
                if (menu == 0)
                    startMenu();//call start menu
                else if (menu == 1)
                    fromUserMenu();//call from user menu
                else if (menu == 2)
                    fromFileMenu();//call from file menu
                else
                    addNodeMenu();//call from add node menu

                choice = intInput.nextInt();//set choice to input
                if (choice < 0 || choice > 2)
                    System.out.println("Try again. Invalid input.\nPlease enter 0, 1, or 2");//error message
                else
                    continueLoop = false;//all good then stop loop
            }
            catch (InputMismatchException ex){//not good display error and loop
                System.out.println("Try again. Invalid input.\nPlease enter 0, 1, or 2");//error message
                intInput.nextLine();//discard input
            }
        }while (continueLoop);
        return choice;
    }
}
