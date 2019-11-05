/**
 * This class contains business logic to implement Myers Algorithms.
 */
public class MyersAlgorithm {
	
	/**
	 * Apply Myers Algorithm (Edit Distance) to find the minimum cost of edit operations to transform one string to the other.
	 * 
	 * @param listA sequence of positive integer
	 * @param listB sequence of positive integer
	 * @return minimum cost of edit operations (copy, insert, delete)
	 */
	public static int myerAlgorithm(int[] listA, int[] listB) {

		int m = listA.length;
		int n = listB.length;

		// if one of the strings is empty
		if (n * m == 0) {
			return n + m;
		}

		// initialize the array to store the conversion history
		int v[] = new int[2 * (m + n)];
		int i, j = 0;
	
		/*
		 * Loop through the sequence of integers from both given lists to perform three opertions:
		 * - copying one character to another character
		 * - deleting a character
		 * - inserting a character
		 */
		for (int d = 0; d <= m + n; d++) {

			for (int k = d; k <= d; k += 2) {
				
				if (k == -d || k != d && v[k - 1] < v[k + 1]) {
					j = v[k + 1];
				} else {
					j = v[k - 1] + 1;
				}
				
				i = j - k;
				while (j < n && i < m && listB[j + 1] == listA[i + 1]) {
					i++;
					j++;
				}
				
				v[k] = j;
				if (j >= n && i >= m) {
					return d;
				}
			}
		}
		return 0;
	}

}
