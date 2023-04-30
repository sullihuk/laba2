import java.lang.Math;
import java.text.NumberFormat;
import java.util.*;


interface Animal // Инициализация интерфейса 
{

	void printer(ArrayList list);// Инициализация метода выводящего информацию о животном
  void fodderCounter(String name, int number, int weightFactor, int ageFactor, double youngFactor, double  youngPortionFactor, double adultPortionFactor);// Инициализация метода расчитывающего количество корма 
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
  

      animalsList.add(name+number); // Добавление в массив имени и номера животного 
      animalsList.add(weight);// Добавление в массив массы животного 
      animalsList.add(age);// Добавление в массив возраста животного 
      animalsList.add(quantityFodder);// Добавление в массив расчитанного количества корма животного 

    }

  @Override
	public void printer(ArrayList list) // Метод реализует вывод на экран информации о животном
	{
    NumberFormat form = NumberFormat.getInstance();// Создание перменной для форматирования чисел, без нее переменные типа double выводятся "не кузяво"

    for(int i = 0; i < list.size(); i++) // Итератор пробегает по всем элементам массива содержащего информацию о животном
    {
      if (i == 0){
        System.out.print(list.get(i) + "\t"); // Первым элементом массива идет имя животного, поэтому оно выводится без какого-либо форматирования
      } else if (i != list.size()-1) {
        form.setMaximumFractionDigits(1); // Назначение переменной, отвечающей за округление и количество знаков после запятой        
        System.out.print(form.format(list.get(i)) + "\t"); // Второй и третий элементы - вес и возраст животных округляются и выводятся с точностью до десятых долей

      }
      else {
        form.setMaximumFractionDigits(3); // Назначение переменной, отвечающей за округление и количество знаков после запятой
        System.out.print(form.format(list.get(i)) + "\t\t");// Последний элемент - количество корма выводится с точностью до тысячных
      } 
    }
	}
}

class Cat extends Dog implements Animal  
{
  double kittyFactor = 1;//Возраст кошкэ, до которого она считается котенком 
  double kittyPortionFactor = 0.017;// Порция для котеночка на кг веса
  double adultPortionFactorC = 0.011;// Порция для взрослого кошкэ
	int weightFactorC = 20;// Максимальный вес кошкэ
	int ageFactorC = 18;// Максимальный возраст кошкэ
	String nameC = "Cat_";//Шаблон имени кошкэ
}

class SearchInfo // Класс содержит методы: создания группы объектов класса; для общения с пользователем; вывод интересующей информации на экран
{
  int quantityObjects = 100;// Количество создаваемых обЪектов соответствующих классов, по заданию

  ArrayList<Object> listOfObjectsD = new ArrayList<>(); // Инициализация списка собак с расчитанным количеством корма для них
  ArrayList<Object> listOfObjectsC = new ArrayList<>();// Инициализация списка кошкэ с расчитанным количеством корма для них
  
  Dog dog = new Dog();//Создание вспомогательного экземпляра класса для пёсов
  Cat cat = new Cat();//Создание вспомогательного экземпляра класса для кошкэ 

  double minPortionD = dog.adultPortionFactorD;// Назначение переменной минимальной порции для собакентиев
  double maxPortionD = dog.puppyPortionFactor*dog.weightFactorD*0.5;// Назначение переменной минимальной порции для собакентиев
  double minPortionC = cat.adultPortionFactorC*0.4;// Назначение переменной минимальной порции для кошкэ
  double maxPortionC = cat.kittyPortionFactor*cat.weightFactorC*0.7;// Назначение переменной максимальной порции для кошкэ
    
  NumberFormat form = NumberFormat.getInstance();// Создание перменной для форматирования/округления чисел, без нее переменные типа double выводятся "не кузяво"
                                                 
	public String scannerChoice() // Метод для выбора разновидности животного, для которого будет выводится информация
	{
		System.out.println(" To see portions of dogs which gobbled up more than others press (D).\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n To see portions of cats which gobbled up more than others press (C).\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n"); 
		Scanner input = new Scanner(System.in);// Инициализация переменной для ввода пользователем
		String oneOfAnimals = input.nextLine();// Назначение переменной для ввода
    oneOfAnimals = oneOfAnimals.trim();  // Переменная переназначается в саму себя но с обрезкой, т.н. "белых символов"

    while (!oneOfAnimals.equalsIgnoreCase("d") && !oneOfAnimals.equalsIgnoreCase("c"))// Цикл будет просить пользователя ввести "d" или "с", для выбора собак или кошек соответсвенно 
    {
		  System.out.println(" Enter either (D) or (C):\n.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.\n");
      oneOfAnimals = input.nextLine();
      oneOfAnimals = oneOfAnimals.trim();  
    }
		return oneOfAnimals;//Метод возвращает выбранное пользователем значение
	}


	public double scannerValue(double maxPortion, double minPortion, String name)// Метод просит пользователя ввести значение в заданном диапазоне. Параметрами являются максимальная, минимальная порции, а также имя (здесь просто тип) животного. При вызове метода будут использоваться соответствующие значения для собак и кошек
	{
    form.setMaximumFractionDigits(3);// Т.к. значение корма выводится в тысячных устанавливается значение 3 знака после запятой
    
		Scanner input = new Scanner(System.in);
    double truValue = 0; // Инициализируется и назначается возвращаемое методом значение 
    boolean validInput;// Инициализируется вспомогательная логическая переменная для поддержания бесконечности цикла ниже

		  System.out.println(" Julia please enter a desired value of fodder for "+name.substring(0,3)+"s.\n Julia, the value must be from " + form.format(minPortion) + " to " + form.format(maxPortion)  +":"); // Выражение просит ввести пользователя число в заданном диапазоне 

    do { // Цикл просит пользователя ввести число в заданном диапазоне. Архитектура цикла подсказана ChatGPT, т.к. самостоятельные попытки его написать не увенчались успехом

      if(input.hasNextDouble())// Условный оператор проверяет чтобы введенное значение было числом, если так, то, переменной присваивается это значение и запускается внутренний условный оператор
      {
        truValue = input.nextDouble();
        
          if(truValue > minPortion && truValue < maxPortion)//Условный оператор проверяет чтобы присвоенное значение было в заданном диапазоне, если так, то, логической переменной присваивается значение истины... 
          {
            validInput = true;
          } else {   //... если нет, то, пользователя просят повторить ввод, а логическая переменная принимает значение ложь
            System.out.println(" Julia, the value must be in the given range, try again:");
            validInput = false;
          }
      } else {    // Если введенное значение не является числом, пользователю предлагается повторить ввод
        System.out.println(" Julia, the value must be in the given range, try again:");
        input.next();
        validInput = false;
      }
    } 
    while (!validInput);// До тех пор пока логическая переменая не примет значение истина цикл будет запускаться заново 

    return truValue;// Как только цикл прекращается, метод возвращает введенное пользователем значение
  }

	public void printerInfo(ArrayList list, double enteredValue) //Метод выводит информацию о тех животных, на которых ушло корма больше, чем то значение количества корма, котoрое ввел пользователь. Параметрами являются: список каких-либо животных, знчение корма, которое ввел пользователь
	{

    for(int i = 0; i < list.size(); i++)//Цикл пробегает по всем элементам полученного на входе массива/списка
    {
      if (i%2 == 1){ //Условный оператор заставляет цикл выбирать каждое нечетное значение, которым является значение корма, т.к. массив заполнялся подряд - Имя Кличество корма, Имя2 Количество корма и т.д. Т.е. цикл фактически обрабатывает только значения количества корма
      String givenValue = list.get(i).toString();// Полученное значение вначале преобразутеся в тип String...
      double objValue = Double.valueOf(givenValue).doubleValue(); // ... далее в тип Double
      
        if (objValue >= enteredValue){ // Вложенный условный оператор определяет какие значения пропускать на вывод
            System.out.print(list.get(i-1) + "\t");//Выводит на экран предыдущее значение i, т.е. соответствующее значению корма имя
            form.setMaximumFractionDigits(3);// Т.к. значение корма выводится в тысячных устанавливается значение 3 знака после запятой
            System.out.println(form.format(list.get(i)));//Выводит на экран количество корма
        }
      }
    }
  }
    
	public void groupOfObjects()// Метод создает группу объектов классов Dog и Cat
	{
    for (int i = 0; i < quantityObjects; i++) { // Цикл создает количество объектов равное классовой переменной
   
      Dog dog = new Dog();//Создание объекта класса Dog
      Cat cat = new Cat();//Создание объекта класса Cat

      dog.fodderCounter(dog.name, i+1, dog.weightFactorD, dog.ageFactorD, dog.puppyFactor, dog.puppyPortionFactor, dog.adultPortionFactorD); //Вызом метода для расчета количества корма для собакентиев
      listOfObjectsD.add(dog.animalsList.get(0));//Добавление в список имени отдельной псины
      listOfObjectsD.add(dog.animalsList.get(3));//Добавление в список количества корма для отдельной псины

      cat.fodderCounter(cat.nameC, i+1, cat.weightFactorC, cat.ageFactorC, cat.kittyFactor, cat.kittyPortionFactor, cat.adultPortionFactorC);//Вызом метода для расчета количества корма для кошкэ
      listOfObjectsC.add(cat.animalsList.get(0));//Добавление в список имени отдельной кошкэ
      listOfObjectsC.add(cat.animalsList.get(3));//Добавление в список количества корма для отдельной кошкэ


      dog.printer(dog.animalsList);//Вызов метода выводящего на экран информацию об отдельной псине 
      cat.printer(cat.animalsList);//Вызов метода выводящего на экран информацию об отдельной кошкэ
      System.out.println();//Переход на новую строку на каждой итерации цикла
    }
  }
}


class laba2
{
	public static void main(String[] args)
	{
    Dog dog = new Dog();//Вспомогательный экземпляр класса
    Cat cat = new Cat();// ----//------

    SearchInfo info = new SearchInfo();//Создание экземпляра класса вывода информации на экран
    info.groupOfObjects();//Вызов классового метода для вывода на экран группы объектов соответствующих классов
    if (info.scannerChoice().equalsIgnoreCase("d"))//Условный оператор решает для какого типа животного выводить информацию
      info.printerInfo (info.listOfObjectsD,  info.scannerValue(info.maxPortionD, info.minPortionD, dog.name));//Выводит на экран информации о собаках, сожравших корма больше, введенного пользователем значения
      else 
      info.printerInfo (info.listOfObjectsC,  info.scannerValue(info.maxPortionC, info.minPortionC, cat.nameC));//Выводит на экран информации о кошечках, сожравших корма больше, введенного пользователем значения

	}
}
