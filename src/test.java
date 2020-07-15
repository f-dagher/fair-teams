import java.util.*;
public class test {

	public static void main(String[] args) {
		ArrayList l1 = new ArrayList();
		ArrayList l2 = new ArrayList();
		ArrayList l3 = new ArrayList();
		
		
		int a,b,c,d;
		a=1;b=2;c=3;d=4;
		
		l1.add(a); l1.add(b);
		l2.add(a); l2.add(c);
		l3.add(c); l3.add(d);
		
		System.out.println(Collections.disjoint(l1, l2));
		System.out.println(Collections.disjoint(l1, l3));
		
		

	}

}
