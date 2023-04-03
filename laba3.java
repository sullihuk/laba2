import java.lang.Math;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;


interface Animal // Инициализация интерфейса 
{
	void printer(double age);
  void fodderCounter(int number);
 }

class Dog implements Animal
{
  double quantityFodder; //Инициализация переменной количества корма
  double puppyKittyFactor = 0.5; // Инициализация и присвоение значения переменной коэффициента возраста щенка
  double puppyKittyPortionFactor = 0.07; // Инциализация и присвоение значения переменной коэффициента порции для щенка
  double adultPortionFactor = 0.035;// Инциализация и присвоение значения переменной коэффициента порции для взрослого собакентия

	double age;// инициализация переменной возраста животного
	double weight;// Инициализация переменной веса животного
	int weightFactor = 110;// Максимальная масса собаки справочное значение
	int ageFactor = 17; // Максимальный возраст собаки 
	String name = "Dog_";// Шаблон клички животного
	int number;// Переменная номер для клички животных

	ArrayList<Object> animalsList = new ArrayList<Object>();// Объявление массива, который будет содержать информацию о животных: вид животного с порядковым номером; возраст; массу; расчетное количество корма

	@Override
  public void fodderCounter(int number)//Метод расчитывает количество корма для животного 
    {
      weight = (Math.random()*weightFactor);// Генерирование случайного веса животного
      age = (Math.random()*ageFactor);// Генерирование случайного возраста животного

      quantityFodder = age <= puppyKittyFactor ? weight*puppyKittyPortionFactor : weight*adultPortionFactor; // Тернарный оператор для расчета количества корма для щенка/котенка или взрослой особи 
                                    
                                    // Добавление в массив информации о животном:
      animalsList.add(name); // шаблон имени и номер;     
      animalsList.add(age); // возраст;
      animalsList.add(weight); // вес\масса;
      animalsList.add(quantityFodder); // расчитанное, согласно данным, количество корма
    }

	public void printer()
	{
    for (int i = 0; i < animalList.length; i++) {
     if (i == 0)
       System.out.println(animalsList[i]i+1);
		System.out.println(animalsList[i]);
	}
}

class Cat extends Dog implements Animal  
{
  double puppyKittyFactor = 1;// Инциализация и присвоение значения переменной коэффициента возраста котенка
  double puppyKittyPortionFactor = 0.017;// Инциализация и присвоение значения переменной коэффициента порции для котенка
  double adultPortionFactor = 0.011;// Инциализация и присвоение значения переменной коэффициента порции для взрослого кошкэ
	int weightFactor = 20; // Назначение максимального вeca для кошкэ, справочное значение
	int ageFactor = 18; // Назначение максимального возраста для кошкэ 
	String name = "Cat_";//Шаблон для клички кошкэ

}

class SearchInfo
{
	double averagePortion = 0;
	double total;
	double[][] portionsFodder = new double[100][];

	double maxPortion;// = portionsFodder[0];
	double minPortion;// = portionsFodder[0];
  
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
		
			Dog dog = new Dog();
      Cat cat = new Cat();
      for (int j=0; j < dog.animalsList.length; j++) 
      {
      }
			//dog.fodderCounter(dog.number=i+1);// Вычисляет порцию каждой псины в зависимости от возраста и массы животного.
			//portionsFodder[i] = dog.quantityFodder; // Наполняет массив данными о порциях собак.
      //dog.animalsList.add(portionsFodder[i]);
		
			if(portionsFodder[i] > maxPortion) 
				maxPortion = portionsFodder[i];

			if(portionsFodder[i] < minPortion) 
				minPortion = portionsFodder[i];

			System.out.println(portionsFodder[i]); //Если расскомментировать: выводит на экран порции всех собак построчно.
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
		SearchInfo info = new SearchInfo();
    info.computationPortion(); 
    info.printInfo(info.portionsFodder);
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


