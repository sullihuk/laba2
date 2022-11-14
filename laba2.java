import java.lang.Math;
import java.util.*;
import java.io.File;
import java.io.RandomAccessFile;

interface Animal
{

	void randomaizer(int factor);
	void animalsList (int number, String name);// float weight, float age, float quntityFodder);
	void counterFodder (float weigth, float age);	

}

class Dog implements Animal
{
	float ageDog;
	float weightDog;
	float quantityFodder;
	int weightFactor = 110;
	int ageFactor = 17;
	String dogN = "Dog";
	ArrayList<Object> animalsList;

	@Override
	public void randomizer(weightFactor)
	{
		weightDog = (Math.random()*weightFactor);
	}

	@Override
	public void randomizer(ageFactor)
	{
		ageDog = (Math.random()*ageFactor);
	}

	@Override
	public void ArrayList<Object> animalsList(int number, String name)
	{ 	
		ArrayList<Object> animalsList = new ArrayList<Object>();
		animalsList.add(dogN+number); 
		animalsList.add(ageDog);
		animalsList.add(weightDog);
		animalsList.add(quantityFodder);
	}

	@Override
	public void counterFodder(ageDog, weigthDog)
	{

		quntityFodder = 
	}



}

/*class Cat implements Animal  
{
	int weightFactor = 20;
	int ageFactor = 18;
	String catN = "Cat";

}*/
