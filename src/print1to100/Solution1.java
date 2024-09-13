package print1to100;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution1 {
	public static void main(String[] agrs) {
		Runnable task1=()->{
			System.out.println("Completed the task by the thread: "+Thread.currentThread().getName());
		};
		
		Callable<String> task2=()->{
			System.out.println("Task 2 is getting printed" + Thread.currentThread().getName());
			return "Completed task2";
		};
		
		ExecutorService service=Executors.newFixedThreadPool(2);
		service.execute(task1);
		
		Future<String> futureString=service.submit(task2);
		
		try {
			String result=futureString.get();
			System.out.println("string resulted from it: "+result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.shutdown();
	}
}
