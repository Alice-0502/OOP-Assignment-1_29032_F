import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    static   Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) {


        while(true) {

            System.out.println("Welcome to Employee MIS");

            System.out.println("1. FullTime Employee");
            System.out.println("2. PartTime Employee");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){

                case 1 :

                    fullTimeInfo();


            }






        }




    }

    private static void fullTimeInfo() {
        FullTime  ft = new FullTime();

        while (true)
        {
            System.out.println("Enter 1. To Save");
            System.out.println("Enter 2. To Display");
            int choice = sc.nextInt();
             sc.nextLine();
            switch (choice){
                case 1 :
                    ft.save();
                    break;

                case 2:
                    ft.display();
                     break;
                case 3:
                    exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");

            }

        }




    }

}