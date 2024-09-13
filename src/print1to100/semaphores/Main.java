package print1to100.semaphores;

import java.util.concurrent.Semaphore;

public class Main {
	static class Resource{
		public void useResource() throws InterruptedException{
			System.out.println(Thread.currentThread().getName() + " using the resource for a while.");
			Thread.sleep(1000);
			System.out.println("Resource usage completed by the thread: "+Thread.currentThread().getName());
		}
	}
	public static void main(String[] args) {
		Semaphore sem=new Semaphore(2);
		Resource resource=new Resource();
		
		Runnable task = () -> {
			try {
				System.out.println(Thread.currentThread().getName()+" is going to axquire the resource.");
				sem.acquire();
				System.out.println(Thread.currentThread().getName()+" got the resource.");
				resource.useResource();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				sem.release();
				System.out.println(Thread.currentThread().getName()+" released the lock.");
			}
		};
		
		Thread t1=new Thread(task,"T1");
		Thread t2=new Thread(task,"T2");
		Thread t3=new Thread(task,"T3");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
