import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		//new HabitWindow().setVisible(true);
	
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
		
		Streak s = new Streak();
		StreaksMaxHeap sh = new StreaksMaxHeap(s);
	
	
		for (int i = 0; i < 5; i++) {
			s.getDates().add(LocalDate.now().plusDays(i));
			System.out.println(sh.toString());
		}
		
		
	}
}
