
public class AnotherWayToDefineThreads {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread thread=new NewThread();
		thread.setName("CutomWorkerThread");
		thread.setPriority(10);
		
		thread.start();
//		thread.sleep(1000L);
		System.out.println("The current thread is: "+Thread.currentThread().getName());
	}
	
	static class NewThread extends Thread{
		@Override
		public void run() {
			System.out.println("Thread name: "+this.getName());
			System.out.println("Thread's priority: "+this.getPriority());
		}
	}

}
