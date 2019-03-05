package test.edu.xalead;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Test1 {
	@Test
	public void test1() {
		ArrayList<String> t = new ArrayList<String>();
		t.add("asdfsadfdf");
		t.add("3232");
		t.add("ada34345");
//		
//		System.out.println(t.get(0));
//		System.out.println(t.get(1));
		
		System.out.println(t.size());
		
		for(int i = 0 ; i < t.size() ;i++) {
			System.out.println(t.get(i));
		}
	}
}
