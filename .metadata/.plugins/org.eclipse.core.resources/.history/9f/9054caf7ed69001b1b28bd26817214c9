import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {


	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(9);
		list.add(8);
		list.add(6);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(9);
		list.add(11);
		
		Stream<Integer> stream = Stream.of(99,98,22);
		stream.forEach(System.out :: print);
		
		Stream<Integer> st = list.stream();
		 List<Integer> collect = st.map(i -> i+1).filter(i -> i%2==0).collect(Collectors.toList());
		//Stream<Object> op = st.map(i->i+2);
		
		Iterator<Integer> itr = collect.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		Iterator<Integer> itr2 = list.iterator();
		while(itr2.hasNext()) {
			System.out.print(itr2.next()+" ");
		}
		 

	}

}
