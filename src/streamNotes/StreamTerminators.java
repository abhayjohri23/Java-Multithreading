package streamNotes;

import java.util.List;
import java.util.Optional;

public class StreamTerminators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<Integer> sum=List.of(1,2,4,1,5,6,19).stream().filter(e->e%2!=0).reduce((Integer i1,Integer i2) -> (i1+i2));
		if(!sum.isEmpty())		System.out.println(sum.get());
		
		Optional<Integer> sumOfFirstCharacterOfNames=List.of("abhay","gaurav","naman","manan","ramna").stream().map(str -> (int)str.charAt(0)).reduce(Integer::sum);
		if(!sumOfFirstCharacterOfNames.isEmpty()) {
			System.out.println(sumOfFirstCharacterOfNames.get());
		}
		
		Optional<Integer> sum2=List.of(1,2,4,1,5,6,19).stream().filter(e->e%2!=0).reduce(Integer::sum);
		System.out.println(sum2.get());
		
		//Minimum and Maximum can be calculated either by Integer functions or by passing a function that accepts two values and returns one value.
		Optional<Integer> maximum=List.of(1,2,4,1,5,6,19).stream().filter(e->e%2!=0).reduce(Integer::max);
		Optional<Integer> minimum=List.of(1,2,4,1,5,6,19).stream().filter(e->e%2!=0).reduce(Integer::min);
		
		System.out.println(maximum.get()+","+minimum.get());
	}

}
