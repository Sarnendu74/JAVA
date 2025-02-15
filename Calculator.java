import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){

        System.out.println("Welcome to Ghosh Calculator");

        float num1;
        float num2;

//      Taking inout from user
        System.out.print("Enter your First Number: ");
        Scanner sc = new Scanner(System.in);
        num1 = sc.nextInt();

        System.out.print("Enter your First Number: ");
        Scanner sc2 = new Scanner(System.in);
        num2 = sc2.nextInt();

//      Addition
        float sum;
        sum = (num1 + num2);

//      Subtraction
        float sub;
        sub = (num1 - num2);

//      Multiplication
        float multiplication;
        multiplication = (num1 * num2);

//     Division
       float divi;
       divi = num1 / num2 ;


        System.out.println("1.Addition");
        System.out.println("2.Subtraction");
        System.out.println("3.Multiplication");
        System.out.println("4.Division");

        System.out.print("Enter your Choice: ");
        Scanner sc3 =  new Scanner(System.in);
        int choice = sc3.nextInt();
        switch (choice){
            case 1:
                System.out.println("Addition is: "+sum);
                break;
            case 2:
                System.out.println("Subtraction is:"+sub);
                break;
            case 3:
                System.out.println("Multiplication is: " + multiplication);
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Division is:" + divi);
                    break;
                }
                else {
                    System.out.println("Error! Division by Zero !");
                }
                break;
            default:
                System.out.println("Invalid Input !");


        }

        System.out.println("Thank you for using Calculator :)");

    }
}
