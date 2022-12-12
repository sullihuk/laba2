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
	
	double[] portionsFodder = new double[100];

	public char scannerEnter()
	{
		Scanner input = new Scanner(System.in);
		char oneOfthree = input.next().charAt(0);
		return oneOfthree;
	}

	double maxPortion = portionsFodder[0];
	double minPortion = portionsFodder[0];
	double averagePortion = 0;
	double total = 0;

	for (int i=1; i < portionsFodder.length; i++)
	{
		if(portionsFodder[i] > maxPortion) 
			maxPortion = portionsFodder[i];

		if(portionsFodder[i] < minPortion) 
			minPortion = portionsFodder[i];
		total += portionFodder[0];
		averagePortion = total/portionsFodder.length;
	}



	public void printInfo (ArrayList info)
	{
		//System.out.println("Info about dog: "+info);
	
	}
}

class laba2
{
	public static void main(String[] args)
	{
		SearchInfo info = new SearchInfo();
		for (int i=1; i<=100; i++) // Создание группы экземпляров класса Dog, по условию задачи. Сто штук собакенов.
		{
			Dog dog = new Dog();
			dog.randomizer(dog.ageFactor, dog.weightFactor);
			dog.fodderCounter(dog.age, dog.weight);
			dog.animalsNum(dog.number=i); // Удивительно, но это работает, правда непонятно как)) Присваивает каждому собакентию номер.
			info.portionsFodder[i-1] = dog.quantityFodder;
		}

		for(int i=0; i<portionsFodder.length; i++)
		{
			System.out.println(info.portionsFodder[i]);
		}

	//	info.printInfo(dog.animalsList); 


		if (info.scannerEnter = "m") 
			System.out.println("The biggest portion is: " +info.maxPortion);
		else if (info.scannerEnter = "n")
			System.out.println("The smallest portion is: " +SearchInfo.minPortion);
		else if (info.scannerEnter = "a")
			System.out.println("The average portion is: " +SearchInfo.averagePortion);
	}
}

/*class Cat implements Animal  
{
	int weightFactor = 20;
	int ageFactor = 18;
	String catN = "Cat_";

}*/
