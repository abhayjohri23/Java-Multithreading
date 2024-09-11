import java.lang.Thread;
import java.lang.Thread.UncaughtExceptionHandler;
public class Solution {
	static class Task implements Runnable{
		//Sample Task to feed the Thread class constructor.
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Inside the thread "+Thread.currentThread().getName());
			System.out.println("The priority of this thread is: "+Thread.currentThread().getPriority());
			throw new RuntimeException("Intentional Exception");
		}
		
		
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread thread=new Thread(new Task());
		thread.setName("CustomThread0");		//set the name of the current thread.
		thread.setPriority(10);					//set the priority of the current thread.
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("An uncaught handler is handling the execption thrown for the message "+e.getMessage());
			}
			
		});
		
		System.out.println("Current thread before starting the thread is : "+Thread.currentThread().getName());
		thread.start();		//Makes the declaration of a new thread to the operating system.
		
//		thread.sleep(10000L);
		System.out.println("Thread after the starting of the thread is: "+Thread.currentThread().getName()+" and its priority is: "+Thread.currentThread().getPriority());
		
//		thread.sleep(10000L);	Puts the thread into Thread.state=TIMED_WAITING with the limit of time as 10seconds. It consumes no CPU resources at this stage.
	}

}
