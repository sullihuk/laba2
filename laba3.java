import java.lang.Math;
import java.util.*;
import java.io.File;
import java.io.RandomAccessFile;

interface Animal
{

	void animalsNum (); 
	void printer (double age);
	void fodderCounter(double age, double weight);
	void randomizer(int ageFactor, int weightFactor)
		
}

class Dog implements Animal
{
	double ageDog;
	double weightDog;
	double quantityFodder;
	int weightFactor = 110;
	int ageFactor = 17;
	String dogN = "Dog";
	ArrayList<Object> animalsList = new ArrayList<Object>();

	@Override
	public void fodderCounter(double age, double weight)
	{
		quantityFodder = age <= 0.5 ? weight*0.07 : weightDog*0.035;  
	}
	
	public void animalsNum()
	{ 	
		public void randomizer(int ageFactor, int weightFactor)
		{
			weight = (Math.random()*weightFactor);
			age = (Math.random()*ageFactor);
		}

		animalsList.add(dogN); 
		animalsList.add(ageDog);
		animalsList.add(weightDog);
	
	}

	public void printer(ageDog)
	{
		System.out.println(ageDog);
	}
}

class SearchInfo
{
	Dog dog = new Dog();
	public void printInfo ()
	{
		System.out.println("Info about dog: "+dog.animalsList);
	
	}
}

class laba2
{
	public static void main(String[] args)
	{
		Dog dog = new Dog();
		SearchInfo info = new SearchInfo();
			
		info.printInfo();
		dog.printer();
	}
}

/*class Cat implements Animal  
{
	int weightFactor = 20;
	int ageFactor = 18;
	String catN = "Cat";

}*/
