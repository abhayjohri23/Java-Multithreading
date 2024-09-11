package streamNotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=List.of(1,2,3,4,5,6,7,8,9,10);
		Stream streamObject=list.stream().filter((el)->el%2==0);
		int count=(int) streamObject.count();
		
		System.out.println(count);
//Ways to create the stream:
		//1. If we have a collection concrete class object - List, ArrayList, LinkedList etc
		List<Integer> list1=List.of(1,2,3,4);
		List<String> list2=List.of("Abhay","Abhishek","Raghav");
		
		List<Integer> list3=new ArrayList<Integer>();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		
		Stream<Integer> stream1=list1.stream();
		Stream<String> stream2=list2.stream();
		Stream<Integer> stream3=list3.stream();		//Stream<E> - refers generic type objects.
		
		//2. If we have an array: Arrays
		int[] arr1= {1,2,3,4,5,6};
		int[] arr2=new int[] {1,2,3};
		String[] arr3= {"Abhay","Shaikh","Mansoor"};
		
		IntStream intstream1=Arrays.stream(arr1);		//Because the elements are primitive in nature, we define them in IntStream class.
		IntStream intstream2=Arrays.stream(arr2);
		Stream<String> stringStream=Arrays.stream(arr3);	//Because strings are not primitive in nature.
		
		//3. If we know the elements: Use Stream.of() method
		Stream<Integer> stream4=Stream.of(1,2,3,4);
		Stream<String> stream5=Stream.of("Abhay","Akshita");
		
		//4. Using StreamBuilder: Returns the Stream<Object>
		Stream<Object> stream6=Stream.builder().add(2).add(4).add(6).add(7).build();
		
	}

}
