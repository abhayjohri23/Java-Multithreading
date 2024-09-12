package factoryDesignPattern;

public abstract class Computer {
	public int hdd;
	public int ram;
	public int cpu;
	
	public Computer(int hdd,int ram,int cpu) {
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	public abstract void setHDD(int hdd);
	public abstract void setRAM(int ram);
	public abstract void setCPU(int cpu);
}
