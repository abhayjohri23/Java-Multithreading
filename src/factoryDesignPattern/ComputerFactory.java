package factoryDesignPattern;

public class ComputerFactory {
	public Computer getComputer(ComputerType type,int hdd,int ram,int cpu) throws Exception {
		switch(type) {
			case PC: return new PC(hdd,ram,cpu);	
			case Server: return new Server(hdd,ram,cpu);
			default: throw new Exception("No such type of computer exists");
		}
	}
}
