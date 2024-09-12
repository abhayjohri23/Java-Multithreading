package factoryDesignPattern;

public class Server extends Computer{
	public int externalHDD;
	public int externalRAM;
	
	public Server(int hdd, int ram, int cpu) {
		super(hdd, ram, cpu);
		// TODO Auto-generated constructor stub
		this.externalHDD=1000;
		this.externalRAM=200;
	}

	@Override
	public void setHDD(int hdd) {
		// TODO Auto-generated method stub
		this.hdd+=externalHDD;
		return ;
	}

	@Override
	public void setRAM(int ram) {
		// TODO Auto-generated method stub
		this.ram+=externalRAM;
		return ;
	}

	@Override
	public void setCPU(int cpu) {
		// TODO Auto-generated method stub
		return ;
	}

}
