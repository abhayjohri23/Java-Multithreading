package factoryDesignPattern;

public class Main {
	public static void main(String[] args) {
		ComputerFactory compFactory=new ComputerFactory();
		try {
			Computer pcComputer=compFactory.getComputer(ComputerType.PC, 100, 20, 2);
			System.out.println("We have created the computer type of "+ComputerType.PC.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			Computer serverComputer=compFactory.getComputer(ComputerType.Server, 2000, 1000, 200);
			System.out.println("We have created the computer type of "+ComputerType.Server.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
