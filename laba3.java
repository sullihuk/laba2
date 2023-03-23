import java.lang.Math;
import java.util.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


interface Animal // Инициализация интерфейса 
{

	void animalsNum(int number);// Инициализация  
	void printer(double age);
  void fodderCounter(double puppyKittyPortionFactor, double puppyKittyFactor, double adultPortionFactor, double age, double weight)
	default void randomizer(double age ,double weight, int ageFactor, int weightFactor)
    {
      weight = (Math.random()*weightFactor);
      age = (Math.random()*ageFactor);
    }

 }

class Dog implements Animal
{
  double puppyKittyFactor = 0.5;
  double puppyKittyPortionFactor = 0.07;
  double adultPortionFactor = 0.035;
	double age;
	double weight;
	int weightFactor = 110;
	int ageFactor = 17;
	String name = "Dog_";
	int number;

	ArrayList<Object> animalsList = new ArrayList<Object>();// Объявление массива содержащего информацию о животных: вид животного с порядковым номером; возраст; массу; расчетное количество корма

	@Override
  public void fodderCounter(double puppyKittyPortionFactor, double puppyKittyFactor, double adultPortionFactor, double age, double weight)//Метод расчитывает количество корма для животного этого класса
    {
      quantityFodder = age <= puppyKittyFactor ? weight*puppyKittyPortionFactor : weight*adultPortionFactor;  
    }

/*	@Override
	public void randomizer(int ageFactor, int weightFactor)
	{
		weight = (Math.random()*weightFactor);
		age = (Math.random()*ageFactor);
	}*/

	@Override
	public void animalsNum(int number)// Метод заполняет массив данными о животине.
	{ 	
		animalsList.add(name+number); 
		animalsList.add(age);
		animalsList.add(weight);
		animalsList.add(quantityFodder);
	}

	public void printer(double age)
	{
		System.out.println(age);
	}
}

class Cat extends Dog implements Animal  
{
  double puppyKittyFactor = 1;
  double puppyKittyPortionFactor = 0.017;
  double adultPortionFactor = 0.011;
	int weightFactor = 20;
	int ageFactor = 18;
	String name = "Cat_";


}

/*class SearchInfo
{
	double maxPortion = portionsFodder[0];
	double minPortion = portionsFodder[0];
	double averagePortion = 0;
	double total;

	double[] portionsFodder = new double[100];

	public char scannerEnter()
	{
		Scanner input = new Scanner(System.in);
		char oneOfthree = input.next().charAt(0);
		return oneOfthree;
	}

	public void computatitonPortion (int ageFactor, int weightFactor, double age, double weight, int number, double quantityFodder)
	{
		for (int i=0; i < portionsFodder.length; i++)
		{
		
			//obj instanceName; 
			Dog dog = new Dog();
			randomizer(ageFactor, weightFactor);
			
			fodderCounter(age, weight); // Вычисляет порцию каждой псины в зависимости от возраста и массы животного.
			animalsNum(number=i+1); // Удивительно, но это работает, правда непонятно как)) Присваивает каждому собакентию номер.
			info.portionsFodder[i] = quantityFodder; // Наполняет массив данными о порциях собак.
			System.out.println(info.portionsFodder[i]); //Если расскомментировать: выводит на экран порции всех собак построчно.
			info.printInfo(dog.animalsList); 
		
			if(portionsFodder[i] > maxPortion) 
				maxPortion = portionsFodder[i];

			if(portionsFodder[i] < minPortion) 
				minPortion = portionsFodder[i];

			total += portionsFodder[i];
		}
			averagePortion = total/portionsFodder.length;
			java.util.Arrays.sort(portionsFodder);	
			maxPortion = portionsFodder[portionsFodder.length-1];
			minPortion = portionsFodder[0];
	}	



	public void printInfo (ArrayList info)
	{
		System.out.println("Info about dog: "+info);
	}

	public void printInteract()
	{
		System.out.println(" To see maximum portion press (m).\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n To see minimum portion press (n).\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n To see avrage portion press (a).\n");
	}
}*/

class laba2
{
	public static void main(String[] args)
	{
		//SearchInfo info = new SearchInfo();

		/*for (int i=0; i<info.portionsFodder.length; i++) // Создание группы экземпляров класса Dog, по условию задачи. Сто штук собакенов.
		{
			Dog dog = new Dog();
			dog.randomizer(dog.ageFactor, dog.weightFactor);
			dog.fodderCounter(dog.age, dog.weight); // Вычисляет порцию каждой псины в зависимости от возраста и массы животного.
			dog.animalsNum(dog.number=i+1); // Удивительно, но это работает, правда непонятно как)) Присваивает каждому собакентию номер.
			info.portionsFodder[i] = dog.quantityFodder; // Наполняет массив данными о порциях собак.
			//System.out.println(info.portionsFodder[i]); //Если расскомментировать: выводит на экран порции всех собак построчно.
			//info.printInfo(dog.animalsList); 
		} */

		//info.computatitonPortion();
		//System.out.println("Total having gobbled up for period of time: "+ info.total+"\n");
		//info.printInteract();


		//char havingEntered = info.scannerEnter();

		/*if ( havingEntered == 'm') 
			System.out.println("The biggest portion is: " +info.maxPortion);
		else if (havingEntered == 'n')
			System.out.println("The smallest portion is: " +info.minPortion);
		else if (havingEntered == 'a')
			System.out.println("The average portion is: " +info.averagePortion);
*/
		
	}
}


