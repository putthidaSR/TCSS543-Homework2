/**
 * This class contains business logic to implement Wu Miller Algorithm.
 * 
 * Reference:
 * 
 * S. Wu, U, Manber, E. Myers, W. Miller, “An O(NP) sequence comparison algorithm”, 
 * Information Processing Letters vol. 35, pp. 317-323, Springer, 1990
 */
public class MillersAlgorithm {

	public static void main(String[] args) {
		int[] listA = RandomGenerator.getFirstList();
		int[] listB = RandomGenerator.getSecondList(listA, 2);

		millerAlgorithm(listA, listB);
	}
	
	/**
	 * Apply Wu Miller Algorithm (Edit Distance) to find the minimum cost of edit operations to transform one string to the other.
	 * 
	 * @param listA sequence of positive integer
	 * @param listB sequence of positive integer
	 * @return minimum cost of edit operations (copy, insert, delete)
	 */
	public static int millerAlgorithm(int[] listA, int[] listB) {
		
		int m = listA.length;
		int n = listB.length;

		// if one of the strings is empty
		if (n * m == 0) {
			return n + m;
		}
		
		// initialize the array to store the conversion history
		int[] fp = new int[m + n + 3];
		int p, delta;
		delta = n - m;
		p = -1;

		/*
		 * Loop through the sequence of integers from both given lists to perform three opertions:
		 * - copying one character to another character
		 * - deleting a character
		 * - inserting a character
		 */
		while (fp[delta] != n) {
			p = p + 1;
			
			for (int k = -p; k <= delta - 1; k++) {
				fp[k] = snake(listA, listB, m, n, k, Math.max(fp[k - 1] + 1, fp[k + 1]));
			}
			
			for(int k = delta + p; k >= delta + 1; k--) {
				fp[k] = snake(listA, listB, m, n, k, Math.max(fp[k - 1] + 1, fp[k + 1]));
			}
			
			fp[delta] = snake(listA, listB, m, n, delta, Math.max(fp[delta - 1] + 1, fp[delta + 1]));
		}
		return delta + 2 * p;
	}
	
	private static int snake(int[] listA, int[] listB, int m, int n, int k, int j) {
		int i = j - k;
		while (i < m && j < n && listA[i + 1] == listB[j + 1]) {
			i++;
			j++;
		}
		return j;
	}

}
