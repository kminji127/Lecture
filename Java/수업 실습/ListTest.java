import java.util.LinkedList;
import java.util.ListIterator;

public class ListTest {
	
	public static void main(String[] args)
	{
		
		LinkedList<String> friends = new LinkedList<String>();
		
		// friends = [K, L, P, Y]
		friends.addLast("Kim");
		friends.addLast("Lee");
		friends.addLast("Park");
		friends.addLast("Yoon");
		System.out.println(friends);
		
		// []
		ListIterator<String> iterator = friends.listIterator();
		iterator.next(); // [K]
		iterator.next(); // [K, L]
		
		iterator.add("Im"); // [K, L, I]
		iterator.add("Dong"); // [K, L, I, D]
		
		iterator.next(); // [K, L, I, D, P]
		iterator.next(); // [K, L, I, D, P, Y]
		
		iterator.remove(); // [K, L, I, D, P]
		
		System.out.println(friends);
	}

}
