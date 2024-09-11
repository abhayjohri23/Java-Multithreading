package problem_Thief_Police_simpleThreadCreation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	private static final int MAX_PASSWORD=9999;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vault myVault=new Vault(new Random().nextInt(MAX_PASSWORD));
		
		List<Thread> listOfThreads=new ArrayList<>();

		listOfThreads.add(new AscendingHackerThread(myVault));
		listOfThreads.add(new DescendingHackerThread(myVault));
		listOfThreads.add(new PoliceThread());
		
		for(Thread thread: listOfThreads) {
			thread.start();
		}
	}
	
	private static class Vault{
		private int vaultPassword=MAX_PASSWORD;
		
		public Vault() {
		}
		public Vault(int password) {
			this.vaultPassword=password;
		}
		
		public boolean passwordMatches(int guess) {
			return this.vaultPassword==guess;
		}
	}
	
	private static abstract class HackerThread extends Thread {
		private Vault toBeHackedVault;
		public HackerThread(Vault toBeHackedVault) {
			this.toBeHackedVault=toBeHackedVault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(MAX_PRIORITY);
		}
		
		@Override
		public void start() {
			System.out.println("Starting thread "+this.getName());
			super.start();
		}

		public Vault getToBeHackedVault() {
			return toBeHackedVault;
		}

		public void setToBeHackedVault(Vault toBeHackedVault) {
			this.toBeHackedVault = toBeHackedVault;
		}
		
		
	}
	
	private static class AscendingHackerThread extends HackerThread {
		public AscendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for(int guess=0;guess<=MAX_PASSWORD;++guess) {
				if(this.getToBeHackedVault().passwordMatches(guess)) {
					System.out.println(this.getName()+" hacked the password!"+this.getToBeHackedVault().vaultPassword);
					System.exit(0);
				}
				
				try {
					this.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class DescendingHackerThread extends HackerThread {
		public DescendingHackerThread(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for(int guess=MAX_PASSWORD;guess>=0;--guess) {
				if(this.getToBeHackedVault().passwordMatches(guess)) {
					System.out.println(this.getName()+" hacked the password "+this.getToBeHackedVault().vaultPassword);
					System.exit(0);
				}
				
				try {
					this.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class PoliceThread extends Thread {
		@Override
		public void run() {
			for(int time=0;time<=100;++time) {
				try {
					this.sleep(1000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(time);
			}
			
			System.out.println("Game over now! All Hackers are caught.");
			System.exit(0);
		}
	}
}
