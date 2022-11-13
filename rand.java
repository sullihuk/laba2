import java.lang.Math;
import java.util.*;

public class rand
{
	static int weightCat = 20;
	static int weightDog = 110;
	static int ageCat = 18;
	static int ageDog = 17;
	static String dogN = "Dog";
	static String catN = "Cat";

	
	public static double result(int t)
	{
		double a = (double) (Math.random()*t);
		return a;
	}

	public static ArrayList<Object> animalsList(int number, String name)
	{ 	
		ArrayList<Object> animalsList = new ArrayList<Object>();
		animalsList.add(name+number); 
		animalsList.add(result(ageDog));
		animalsList.add(result(weightDog)); 
		return animalsList;
	}
			
	public static void main(String[] args)
	{
		/* System.out.println("The weight of the cat is: " +result(weightCat));

		System.out.println("The weight of the dog is: " +result(weightDog));
		System.out.println("Age of the cat is: " +result(ageCat));
		System.out.println("Age of the dog is: " +result(ageDog)); */

		for (int i=1; i<=100; i++)
		{
			System.out.println("Stroka will be: " + animalsList(i,dogN));
		}
	}
}
