package singletonDesignPattern;

public class SingletonClass {
	//Made static so that it loads with class.
	private static SingletonClass instance;
	//Constructor is made private, so that no one can access it.
	private SingletonClass() {
	}
	
	//Lazy initialization of the instance variable. 
	public static SingletonClass getInstance() {
		if(instance==null)		instance=new SingletonClass();
		return instance;
	}
	
	//No setters are provided for the instance method.
}
