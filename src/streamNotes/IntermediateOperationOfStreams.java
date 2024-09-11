package streamNotes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperationOfStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//1. Filter operation - to filter some of the elements of the entire stream, to get selected elements that match one particular condition of predicate.
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(2);
//Distinct - to filter out the distinct elements from the list.
		Stream<Integer> distinctElementsStream=list.stream().distinct();
		List<Integer> finalList=distinctElementsStream.collect(Collectors.toList());
		
		for(int i=0;i<finalList.size();++i)		System.out.print(finalList.get(i)+",");
		System.out.println();
		List<Integer> filteredList=list.stream().filter(e->e%2==0).collect(Collectors.toList());
		
		for(int i=0;i<filteredList.size();++i)		System.out.print(filteredList.get(i)+",");	
		System.out.println();
		
		List<String> listOfEmails= List.of("abhay@mail.com","akshita@mail.com","seema@gail.com").stream()
				.filter(name -> name.contains("mail.com")).collect(Collectors.toList());
		
		for(String emails:listOfEmails)		System.out.println(emails);
		
//Map - if we need to map each element of the stream to yet another form, we use map function. It accepts a function.
		List<Character> listOfFirstCharacterOfNames=List.of("Abhay","Mansoor","Rajeev","Karthik").stream().map(name -> name.charAt(0)).collect(Collectors.toList());
		
		System.out.println();
		for(char ch:listOfFirstCharacterOfNames)			System.out.print(ch+" ");
		
		System.out.println();
		int bias=220;
		List<Integer> newListAfterAddition=List.of(1,2,3,4,5,6).stream().map(e -> (e+bias)).collect(Collectors.toList());
		for(int number:newListAfterAddition)					System.out.print(number+" ");

//Limit - To truncate the elements from the stream of integers,we use limit function.
		Stream<Integer> streamOfIntegers=Stream.iterate(0,(Integer n) -> (n+500)).limit(10);
		streamOfIntegers.forEach(System.out::println);
		
//Sorting - of the elements works with sorted() method. We can also use the comparator inside the sorted() method. It is same as sort method of Collections or Arrays.
		List<String> listOfNames=List.of("abhay","akanksha","kshitij","rajeev","kartikey").stream().sorted().collect(Collectors.toList());
		for(String name:listOfNames)			System.out.print(name+", ");
		System.out.println();
		
		List<Character> listOfCharacters=List.of("Abhay","Pragy","Naman").stream().map(name -> name.charAt(0)).distinct().sorted().collect(Collectors.toList());
		for(char ch:listOfCharacters) {
			System.out.print(ch+", ");
		}
		System.out.println();
		
//MapToInt,MapToDouble and so on - It is an extension of the 'map' function.
		List.of("1","2","30","24","12").stream().mapToInt((String val) -> Integer.parseInt(val)).sorted().forEach(System.out::println);
	}

}
