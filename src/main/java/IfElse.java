
import java.util.Scanner;

public class IfElse {

    public static void main(String[] args){

        Scanner userName = new Scanner(System.in);
        System.out.println(" Please enter your age: \n");
        int age = userName.nextInt();

        boolean eligible = false;
        if (age >= 35) {
            eligible = true;
        }
        else if (age >=25  && age < 30){
            System.out.println("you are not eligible for vaccine");
        }
        else
        {
            eligible = false;
        }
        System.out.println("Is Eligible for vaccine is: " + eligible);


    }
}