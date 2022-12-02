import java.lang.Math;
import java.util.*;
import java.io.File;
import java.io.RandomAccessFile;

interface Animal
{
	void animalsNum(); 
	void printer(double age);
	void fodderCounter(double age, double weight);
	void randomizer(int ageFactor, int weightFactor);
}

class Dog implements Animal
{
	double age;
	double weight;
	double quantityFodder;
	int weightFactor = 110;
	int ageFactor = 17;
	String dogN = "Dog";

	ArrayList<Object> animalsList = new ArrayList<Object>();

	@Override
	public void fodderCounter(double age, double weight)
	{
		quantityFodder = age <= 0.5 ? weight*0.07 : weight*0.035;  
	}

	@Override
	public void randomizer(int ageFactor, int weightFactor)
	{
		weight = (Math.random()*weightFactor);
		age = (Math.random()*ageFactor);
	}

	@Override
	public void animalsNum()
	{ 	
		animalsList.add(dogN); 
		animalsList.add(age);
		animalsList.add(weight);
	}

	public void printer(double ageDog)
	{
		System.out.println(ageDog);
	}
}

class SearchInfo
{
	public void printInfo (ArrayList info)
	{
		System.out.println("Info about dog: "+info);
	
	}
}

class laba2
{
	public static void main(String[] args)
	{
		Dog dog = new Dog();
		dog.randomizer(dog.ageFactor, dog.weightFactor);
		dog.animalsNum();
		SearchInfo info = new SearchInfo();
		info.printInfo(dog.animalsList);
	}
}

/*class Cat implements Animal  
{
	int weightFactor = 20;
	int ageFactor = 18;
	String catN = "Cat";

}*/
