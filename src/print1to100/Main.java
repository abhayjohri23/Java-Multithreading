package print1to100;

public class Main {
	private static final int INT_MAX=100;
	private static int counter=1;
	
	public static void main(String[] args) {
		Object lock=new Object();
		
		Thread thread1=new Thread(new PrintNumber(lock,1));
		thread1.setName("thread1");
		
		Thread thread2=new Thread(new PrintNumber(lock,2));
		thread2.setName("thread2");
		
		Thread thread3=new Thread(new PrintNumber(lock,3));
		thread3.setName("thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	static class PrintNumber implements Runnable {
		private Object lock;
		private int threadId;
		public PrintNumber(Object lock,int threadId) {
			this.lock=lock;
			this.threadId=threadId;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized (lock) {
				while(true) {
					if(counter > INT_MAX)		break;
					
					if(counter%3 == this.threadId%3) {
						System.out.println(counter);
						counter++;
						
						lock.notifyAll();
					}
					else {
						try {
                            lock.wait();  // Wait for its turn if it's not this thread's turn
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
					}
				}
			}
			
			
		}
	}
}
