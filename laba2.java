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
	double maxPortionG = 0;
  ArrayList<Object> listOfObjectsD = new ArrayList<Object>();
  ArrayList<Object> listOfObjectsC = new ArrayList<Object>();
  
  Dog dog = new Dog();
	public char scannerEnter()
	{
		System.out.println(" To see portions of dogs which gobbled up more than others press (D).\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n To see portions of cats which gobbled up more than others press (C).\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
		Scanner input = new Scanner(System.in);
		char oneOfthree = input.next().charAt(0);
		return oneOfthree;
	}

	public void groupOfObjects()//        double maxPortionG   добавить как параметр
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
      
    dog.printer(listOfObjectsD);
    dog.printer(listOfObjectsC);
		  /*char havingEntered = scannerEnter();
      if (scannerEnter() == 'c' || scannerEnter() == 'C')
		  System.out.println(" Enter the value up to: "+ cat.weightFactorC*cat.kittyPortionFactor);
      if (scannerEnter() == 'd' || scannerEnter() == 'D')
		  System.out.println(" Enter the value up to: "+ dog.weightFactorD*dog.puppyPortionFactor);*/
  }

   
	/*public void printInfo ()
	{
      System.out.print("Info about dog: ");
    for (int i = 0; i < listOfObjectsD.size(); i++)
    {
      System.out.print(listOfObjectsD.get(i)+"\t");
      System.out.println();
    }
	}*/
}


class laba2
{
	public static void main(String[] args)
	{
    SearchInfo info = new SearchInfo();
    info.groupOfObjects();
    //info.printInfo();
    /*for (int i = 0; i < 100; i++) {
   
      Dog dog = new Dog();
      Cat cat = new Cat();

      dog.fodderCounter(dog.name, i+1, dog.weightFactorD, dog.ageFactorD, dog.puppyFactor, dog.puppyPortionFactor, dog.adultPortionFactorD);
      cat.fodderCounter(cat.nameC, i+1, cat.weightFactorC, cat.ageFactorC, cat.kittyFactor, cat.kittyPortionFactor, cat.adultPortionFactorC );
      dog.printer();
      cat.printer();
      System.out.println();
    }*/
	}
}
