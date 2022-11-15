import java.lang.Math;
import java.util.*;
import java.io.File;
import java.io.RandomAccessFile;

interface Animal
{

	void randomaizer();
	void animalsNum (); 
	void counterFodder ();	

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
	int [] arr = {10, 20, 40};
	

	@Override
	public void randomaizer()
	{
		weightDog = (Math.random()*weightFactor);
		ageDog = (Math.random()*ageFactor);
	}


	@Override
	public void animalsNum()
	{ 	
		animalsList.add(dogN); 
		animalsList.add(ageDog);
		animalsList.add(weightDog);
		animalsList.add(quantityFodder);
	}

	@Override
	public void counterFodder()
	{
		 quantityFodder = ageDog <= 0.5 ? weightDog*0.07 : weightDog*0.035;  
	}



}

class SearchInfo
{
	Dog dog = new Dog();
	public void printInfo ()
	{
		System.out.println("Info about dog: "+dog.arr);
	
	}
}

class laba2
{
	public static void main(String[] args)
	{
		Dog dog = new Dog();
		SearchInfo info = new SearchInfo();
			
		info.printInfo();
		
	}
}

/*class Cat implements Animal  
{
	int weightFactor = 20;
	int ageFactor = 18;
	String catN = "Cat";

}*/
