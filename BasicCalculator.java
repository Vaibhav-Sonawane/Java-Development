//TASK 2)Basic Calculator
/**
 * Develop a basic calculator application that can perform addition, subtraction, multiplication, and division.
 * Use console input and output for simplicity.
 */
import java.util.*;
public class BasicCalculator {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 boolean loop= true;
		 	while(loop) {
	        System.out.println("Welcome to Basic Calculator");
	        System.out.print("Enter first number: ");
	        double num1 = scanner.nextDouble();
	       
	        System.out.print("Enter second number: ");
	        double num2 = scanner.nextDouble();
	       
	        System.out.println("Select operation:");
	        System.out.println("1. ADDITION");
	        System.out.println("2. SUBTRACTION");
	        System.out.println("3. MULTIPLICATION");
	        System.out.println("4. DIVISION");
	        System.out.println("5. Exit");
	        System.out.print("Enter your choice (1 / 2 / 3 / 4 / 5): ");
	        int choice = scanner.nextInt();

	        switch (choice) {
	        	case 1:
	        		double addResult= num1+num2;
	        		System.out.println("Result of Addition: "+addResult);
	        		break;
	        	case 2:
	        		double subtractResult=num1-num2;
	        		System.out.println("Result of Subtraction: "+subtractResult);
	        		break;
	        	case 3:
	                double multiplicationResult = num1 * num2;
	                System.out.println("Result of multiplication: " + multiplicationResult);
	                break;
	            case 4:
	                if (num2 != 0) {
	                    double divisionResult = num1 / num2;
	                    System.out.println("Result of division: " + divisionResult);
	                } else {
	                    System.out.println("Cannot divide by zero");
	                }
	                break;
	            case 5:
	            	loop = false;
	            	break;
	            default:
	                System.out.println("Invalid choice.Try Again");
	        }
            if (loop) {
                System.out.print("Do you want to continue? (yes/no): ");
                String answer = scanner.next();
                loop = answer.equalsIgnoreCase("yes");
             }
	        }
	        scanner.close();  
	    }
	}


