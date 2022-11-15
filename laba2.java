import java.lang.Math;
import java.util.*;
import java.io.File;
import java.io.RandomAccessFile;

interface Animal
{

	void animalsNum (); 
	void printer ();

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
	public void animalsNum()
	{ 	
		weightDog = (Math.random()*weightFactor);
		ageDog = (Math.random()*ageFactor);

		quantityFodder = ageDog <= 0.5 ? weightDog*0.07 : weightDog*0.035;  

		animalsList.add(dogN); 
		animalsList.add(ageDog);
		animalsList.add(weightDog);
		animalsList.add(quantityFodder);
	
	}

	public void printer()
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
