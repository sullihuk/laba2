import java.lang.Math;
import java.text.NumberFormat;
import java.util.*;


interface Animal // Инициализация интерфейса 
{

	void printer(ArrayList list);
  void fodderCounter(String name, int number, int weightFactor, int ageFactor, double youngFactor, double  youngPortionFactor, double adultPortionFactor);
 }

class Dog implements Animal
{
  double quantityFodder; //Расчетное количество корма
  double puppyFactor = 0.5; //Возраст псины, до которого она считается щенком 
  double puppyPortionFactor = 0.07; // Порция для щенка на кг веса
  double adultPortionFactorD = 0.035; // Порция для взрослого собакентия
	double age; //Возраст животного
	double weight; //Вес/масса животного
	int weightFactorD = 110; // Максимальный вес собакeнтиев
	int ageFactorD = 17;// Максимальный возраст собак
	String name = "Dog_";// Шаблон имени собакентия


	ArrayList<Object> animalsList = new ArrayList<>();// Объявление массива, который будет содержать информацию о животных: вид животного с порядковым номером; возраст; массу; расчетное количество корма

  @Override
  public void fodderCounter(String name, int number, int weightFactor, int ageFactor , double youngFactor, double  youngPortionFactor, double adultPortionFactor)//Метод расчитывает количество корма для животного. Не совсем в соответсвии с заданием, т.к. принимаемых параметров больше чем по заданию, однако, они необходимы для генерации экземпляров соответствующих классов 
    {
      weight = (Math.random()*weightFactor);//Генератор веса животных
		  age = (Math.random()*ageFactor); //Генератор возраста животных

      quantityFodder = age <= youngFactor ? weight*youngPortionFactor : weight*adultPortionFactor;//Тернарный оператор для расчета количества корма для щенка/котенка или взрослой особи 
  

      animalsList.add(name+number); 
      animalsList.add(weight);
      animalsList.add(age);
      animalsList.add(quantityFodder);
    }

  @Override
	public void printer(ArrayList list)
	{
    NumberFormat form = NumberFormat.getInstance();

    for(int i = 0; i < list.size(); i++)
    {
      if (i == 0){
        System.out.print(list.get(i) + "\t");
      } else if (i != list.size()-1) {
        form.setMaximumFractionDigits(1);
        System.out.print(form.format(list.get(i)) + "\t");
      }
      else {
        form.setMaximumFractionDigits(3);
        System.out.print(form.format(list.get(i)) + "\t\t");
      } 
    }
	}
}

class Cat extends Dog implements Animal  
{
  double kittyFactor = 1;
  double kittyPortionFactor = 0.017;
  double adultPortionFactorC = 0.011;
	int weightFactorC = 20;
	int ageFactorC = 18;
	String nameC = "Cat_";
}

class SearchInfo
{
  int quantityObjects = 100;

  ArrayList<Object> listOfObjectsD = new ArrayList<>();
  ArrayList<Object> listOfObjectsC = new ArrayList<>();
  
  Dog dog = new Dog();
  Cat cat = new Cat();

  double minPortionD = dog.adultPortionFactorD*0.1;
  double maxPortionD = dog.puppyPortionFactor*dog.weightFactorD;

  double minPortionC = cat.adultPortionFactorC*0.1;
  double maxPortionC = cat.kittyPortionFactor*cat.weightFactorC;
    
	public String scannerChoice()
	{
		System.out.println(" To see portions of dogs which gobbled up more than others press (D).\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n To see portions of cats which gobbled up more than others press (C).\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
		Scanner input = new Scanner(System.in);
		String oneOfAnimals = input.nextLine();
    oneOfAnimals = oneOfAnimals.trim();  

    while (!oneOfAnimals.equalsIgnoreCase("d") && !oneOfAnimals.equalsIgnoreCase("c")) 
    {
		  System.out.println(" Enter either (D) or (C):\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
      oneOfAnimals = input.nextLine();
      oneOfAnimals = oneOfAnimals.trim();  
    }
		return oneOfAnimals;
	}

	public double scannerValue(double maxPortion, double minPortion, String name)
	{
    NumberFormat form = NumberFormat.getInstance();
    form.setMaximumFractionDigits(3);
    
    double truValue; 
		String fodderQuantity;

		System.out.println(" Julia please enter a desired value of fodder for "+name.substring(0,3)+"s.\n Julia, the value must be from " + form.format(minPortion) + " to " + form.format(maxPortion)  +":");
		Scanner input = new Scanner(System.in);
    do {
      
      System.out.println(" Julia, please enter the value from " + form.format(minPortion) + " to " + form.format(maxPortion)  +":");

      fodderQuantity = input.nextLine();
      fodderQuantity = fodderQuantity.trim();  
        while(fodderQuantity == null || fodderQuantity.isEmpty()) {
          System.out.println(" Julia, the value can't be empty, try again:");
          fodderQuantity = input.nextLine();
          fodderQuantity = fodderQuantity.trim();  
        }

      truValue = Double.valueOf(fodderQuantity).doubleValue();

    } 
    while (truValue < minPortion || truValue > maxPortion); 
      
    return  truValue;
  }

	public void printerInfo(ArrayList list, double enteredValue)
	{
    NumberFormat form = NumberFormat.getInstance();

    for(int i = 0; i < list.size(); i++)
    {
      if (i%2 == 1){
      String givenValue = list.get(i).toString();
      double objValue = Double.valueOf(givenValue).doubleValue();
      
        if (objValue <= enteredValue){
            System.out.print(list.get(i-1) + "\t");
            form.setMaximumFractionDigits(3);
            System.out.print(form.format(list.get(i)) + "\t\t");
            System.out.println();
        }
      }
    }
  }
    
	public void groupOfObjects()
	{
    for (int i = 0; i < quantityObjects; i++) {
   
      Dog dog = new Dog();
      Cat cat = new Cat();

      dog.fodderCounter(dog.name, i+1, dog.weightFactorD, dog.ageFactorD, dog.puppyFactor, dog.puppyPortionFactor, dog.adultPortionFactorD);
      listOfObjectsD.add(dog.animalsList.get(0));
      listOfObjectsD.add(dog.animalsList.get(3));
      cat.fodderCounter(cat.nameC, i+1, cat.weightFactorC, cat.ageFactorC, cat.kittyFactor, cat.kittyPortionFactor, cat.adultPortionFactorC);
      listOfObjectsC.add(cat.animalsList.get(0));
      listOfObjectsC.add(cat.animalsList.get(3));

      dog.printer(dog.animalsList);
      cat.printer(cat.animalsList);
      System.out.println();
    }
  }
}


class laba2
{
	public static void main(String[] args)
	{
    Dog dog = new Dog();
    Cat cat = new Cat();

    SearchInfo info = new SearchInfo();
    info.groupOfObjects();
    if (info.scannerChoice().equalsIgnoreCase("d"))
      info.printerInfo (info.listOfObjectsD,  info.scannerValue(info.maxPortionD, info.minPortionD, dog.name));
      else 
      info.printerInfo (info.listOfObjectsC,  info.scannerValue(info.maxPortionC, info.minPortionC, cat.name));

      //info.scannerChoice().equalsIgnoreCase("d") ? info.printInfo (info.listOfObjectsD,  info.scannerValue(info.maxPortionD, info.minPortionD, dog.name)): info.printInfo (info.listOfObjectsC,  info.scannerValue(info.maxPortionC, info.minPortionC, cat.name));
 //Тернарный оператор для расчета количества корма для щенка/котенка или взрослой особи 
	}
}
