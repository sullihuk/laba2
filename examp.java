import java.lang.Math;
import java.text.NumberFormat;
import java.util.*;



class examp
{
	public static void main(String[] args)
	{
    char choice = 'd';
		System.out.println(" Julia please enter desired value of fodder: ");
		Scanner input = new Scanner(System.in);
		String fodderQuantity = input.nextLine();
    fodderQuantity = fodderQuantity.trim();  

    if (choice == 'd' || choice == 'D') {
      while (!fodderQuantity.matches("-?\\d+(\\.\\d+)?") || fodderQuantity == null || fodderQuantity.isEmpty()) {
        System.out.println(" Julia, please enter the value from ");
        fodderQuantity = input.nextLine();

      }
      double inputAsDouble = Double.parseDouble(fodderQuantity);
        while (inputAsDouble < 0.1 || inputAsDouble > 35.0) {
          System.out.println(" Julia the entered value must be between 0.1 and 35:");
           System.out.println(inputAsDouble);
          } 
        
      }
  }
}

