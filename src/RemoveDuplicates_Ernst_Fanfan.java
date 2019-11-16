public class RemoveDuplicates_Ernst_Fanfan {
    public static void main (String [] Args){
        boolean exit = false;//exit trigger

        /**Start of program*/
        while(exit != true) {//main loop
            Menu_Ernst_Fanfan start = new Menu_Ernst_Fanfan();//new menu object
            int choice = start.setChoice();//Scan and pass choice
            exit = process(choice);//process choice and query exit
        }
    }

    public static boolean process(int choice){
        boolean exit = false;//exit trigger

        /**switch between choices*/
        switch (choice){
            case 0://exit
                System.out.println("Goodye!");
                exit = true;//set to exit
                break;
            case 1://from file
                System.out.println("Processing from file!");
                break;
            case 2://from user
                System.out.println("Processing from User!");
                break;
        }
        return exit;//return exit trigger
    }
}
