import java.lang.Math;
import java.util.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


interface Animal
{
	void animalsNum(int number); 
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
	String dogN = "Dog_";
	int number;

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
	public void animalsNum(int number)
	{ 	
		animalsList.add(dogN+number); 
		animalsList.add(age);
		animalsList.add(weight);
		animalsList.add(quantityFodder);
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

		double[] portionsFodder = new double[100];

		for (int i=1; i<=100; i++) // Создание группы экземпляров класса Dog, по условию задачи. Сто штук собакенов.
		{
			Dog dog = new Dog();
			dog.randomizer(dog.ageFactor, dog.weightFactor);
			dog.fodderCounter(dog.age, dog.weight);
			dog.animalsNum(dog.number=i); // Удивительно, но это работает, правда непонятно как)) Присваивает каждому собакентию номер.
			SearchInfo info = new SearchInfo();
			info.printInfo(dog.animalsList); 
			portionsFodder[i-1] = dog.quantityFodder;
		}
		double maxPortion = portionsFodder[0];

		for (int i=1; i<portionsFodder.length; i++)
		{
			if(portionsFodder[i] > maxPortion) maxPortion = portionsFodder[i];
		}

		for(int i=0; i<portionsFodder.length; i++)
		{
			System.out.println(portionsFodder[i]);
		}
	}
}

/*class Cat implements Animal  
{
	int weightFactor = 20;
	int ageFactor = 18;
	String catN = "Cat_";

}*/
