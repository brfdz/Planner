import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
//		
//		PlannerDoublyLinked pdl = new PlannerDoublyLinked();
//		DayNode dn1 = new DayNode();
//		//dn1.setDate(dn1.getDate().plusDays(1));
//		DayNode dn2 = new DayNode();
//		dn2.setDate(dn2.getDate().minusDays(5));
//		
//		DayNode dn3 = new DayNode();
//		
//		dn3.setDate(dn3.getDate().plusDays(10));
//		
//		pdl.insert(dn1);
//		pdl.insert(dn2);
//		pdl.insert(dn3);
//		
//		pdl.printAll();
//		
//		System.out.println(pdl.isExists(LocalDate.now()));
		
		StreaksMaxHeap sh = new StreaksMaxHeap();
		sh.addValue(7);
		sh.addValue(3);
		sh.addValue(5);
		sh.addValue(1);sh.addValue(4);
		sh.addValue(10);
		System.out.println(sh.getHeap());
		
		System.out.println(sh.getMax());
		
		sh.update(2, 11);
		System.out.println(sh.getHeap());
		System.out.println(sh.getMax());
		
		sh.update(2, 6);
		
		System.out.println(sh.getHeap());
		
		sh.update(1, 4);
		System.out.println(sh.getHeap());
	}
}
