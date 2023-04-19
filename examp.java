import java.lang.Math;
import java.text.NumberFormat;
import java.util.*;



class examp
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println(" Julia please enter desired value of fodder: ");
		double fodderQuantity = input.nextDouble();
    
    while (fodderQuantity == null || fodderQuantity.isEmpty()) {
        System.out.println(" Julia, please enter something: ");
        fodderQuantity = input.nextLine();
      }
    fodderQuantity = fodderQuantity.trim();  
    if (!fodderQuantity.matches("-?\\d+(\\.\\d+)?"))
    {
        fodderQuantity = input.nextLine();
      return;
    }

    double inputAsDouble = Double.parseDouble(fodderQuantity);
    if (inputAsDouble < 0.1 || inputAsDouble > 35.0) {
          System.out.println(" Julia the entered value must be between 0.1 and 35:");
           System.out.println(inputAsDouble);
    } 
        
  }
  
}

