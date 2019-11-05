import java.util.HashMap;

public class MainSimulator {
	
	/**
	 * Generate 8 pairs of random sequences for two lists, and apply both Miller and Myers algorithms to analyze the 
	 * comparison performance of each algorithm between elements in both list.
	 */
	public static void main(String[] args) {
		
		HashMap<Integer, Integer> deletionMap = RandomGenerator.getDeletePosition();
		
		for (int i = 1; i <= 8; i++) {
			
			int[] listA = RandomGenerator.getFirstList();
			int[] listB = RandomGenerator.getSecondList(listA, deletionMap.get(i));
			
			System.out.println("Myers Algorithm: " + MyersAlgorithm.myerAlgorithm(listA, listB));
			System.out.println("Miller Algorithm: " + MillersAlgorithm.millerAlgorithm(listA, listB));

			System.out.println("------------------------");
		}
	}

}
