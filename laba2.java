import java.lang.Math;
import java.util.*;


interface Animal // Инициализация интерфейса 
{

	void printer(int number);
  void fodderCounter();

 }

class Dog implements Animal
{
  double quantityFodder;
  double puppyKittyFactor = 0.5;
  double puppyKittyPortionFactor = 0.07;
  double adultPortionFactor = 0.035;
	double age;
	double weight;
	int weightFactor = 110;
	int ageFactor = 17;
	String name = "Dog_";
	int number = 1;

	ArrayList<Object> animalsList = new ArrayList<Object>();// Объявление массива, который будет содержать информацию о животных: вид животного с порядковым номером; возраст; массу; расчетное количество корма

  public void randomizer(int ageFactor, int weightFactor)
	{
		weight = (Math.random()*weightFactor);
		age = (Math.random()*ageFactor);
	}

  public void fodderCounter()//Метод расчитывает количество корма для животного. Не совсем в соответсвии с заданием т.к. нет принимаемых параметров
    {
      quantityFodder = age <= puppyKittyFactor ? weight*puppyKittyPortionFactor : weight*adultPortionFactor;  
    }

	public void animalsNum()// Метод заполняет массив данными о животине.
	{ 	
		animalsList.add(name+number); 
		animalsList.add(age);
		animalsList.add(weight);
		animalsList.add(quantityFodder);
	}

	public void printer(int number)
	{
    for(int i = 0; i < animalsList.size(); i++)
    {
		System.out.print(animalsList.get(i) + " ");
    }
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
class SearchInfo
{
	double averagePortion = 0;
	double total;
	double[] portionsFodder = new double[100];

	double maxPortion = portionsFodder[0];
	double minPortion = portionsFodder[0];
  
	public char scannerEnter()
	{
		Scanner input = new Scanner(System.in);
		char oneOfthree = input.next().charAt(0);
		return oneOfthree;
	}

	public void computationPortion ()
	{
		for (int i=0; i < portionsFodder.length; i++)
		{
		
			//System.out.println(portionsFodder[i]); //Если расскомментировать: выводит на экран порции всех животных построчно.
		
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
}


class laba2
{
	public static void main(String[] args)
	{
    Dog dog = new Dog();
    dog.randomizer(dog.ageFactor, dog.weightFactor);
    dog.fodderCounter();
    dog.animalsNum();
    dog.printer(10);

	}
}
