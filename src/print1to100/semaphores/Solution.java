package print1to100.semaphores;

import java.util.concurrent.CountDownLatch;

public class Solution {
	public static void main(String[] args) {
		CountDownLatch latch=new CountDownLatch(2);
		
		Thread t1=new Thread(new Task(latch),"Worker1");
		Thread t2=new Thread(new Task(latch),"Worker2");
		
		t1.start();
		t2.start();
		try {latch.await();}catch(Exception e) {e.printStackTrace();}
		
		System.out.println("Main thread executes!");
	}
	static class Task implements Runnable {
		private CountDownLatch latch;
		public Task(CountDownLatch latch) {
			this.latch=latch;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println(Thread.currentThread().getName()+ " Does something!");
			latch.countDown();
		}
		
	}
}

