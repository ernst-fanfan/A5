import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_Ernst_Fanfan {
    //states
    private int choice =-1;

    public void startMenue(){
        System.out.println("-----MAIN MENU-----\n" +
                "0 - Exit Program\n" +
                "1 – Read Input From Text File\n" +
                "2 – Read Input Form Keyboard");
    }

    /**updating choice from user*/
    public int setChoice(){
        Scanner intInput =  new Scanner(System.in);//scanner
        boolean continueLoop = true;//exit loop trigger
        do {//data validation loop
            try{//exception handling
                startMenue();//call start menu
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
