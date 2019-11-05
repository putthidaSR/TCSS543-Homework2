import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator {

	private static final int FIRST_LIST_MAX_SIZE = 3;
	private static final int SECOND_LIST_MAX_SIZE = 5;
	
	private static final int RANDOM_GENERATOR_RANGE = 9;
	
	public RandomGenerator() {

	}
	
	public static int[] getFirstList() {

		// create instance of Random class
		Random rand = new Random();

		int[] arr = new int[FIRST_LIST_MAX_SIZE];

		for (int i = 0; i < FIRST_LIST_MAX_SIZE; i++) {
			arr[i] = rand.nextInt(RANDOM_GENERATOR_RANGE);
		}
		
		System.out.println("First list: " + Arrays.toString(arr));
		return arr;
	}
	
	public static int[] getSecondList(final int[] initialList, final int deletionPosition) {
		
		int[] secondList = new int[SECOND_LIST_MAX_SIZE];
		
		for (int i = 0; i < FIRST_LIST_MAX_SIZE; i++) {
			secondList[i] = initialList[i];
		}
		
		Random rand = new Random(); 
		for (int i = FIRST_LIST_MAX_SIZE; i < SECOND_LIST_MAX_SIZE; i++) {
			secondList[i] = rand.nextInt(RANDOM_GENERATOR_RANGE);
		}
		//System.out.println(Arrays.toString(secondList));
		
		// Delete the element in the list at the given position
		int[] listAfterDeletionn = removeTheElement(secondList, deletionPosition);
		//System.out.println(Arrays.toString(listAfterDeletionn));

		// Insert the element to the list at the given position
		int[] resultantList = insertElementAtGivenPosition(listAfterDeletionn, rand.nextInt(RANDOM_GENERATOR_RANGE), getInsertionPosition(deletionPosition));
		
		System.out.println("Second list: " + Arrays.toString(resultantList));
		
		return resultantList;
	}
	
	private static int getInsertionPosition(final int deletionPosition) {
		return SECOND_LIST_MAX_SIZE - FIRST_LIST_MAX_SIZE + deletionPosition;
	}
	
	private static int[] removeTheElement(int[] arr, int index) {

		// If the array is empty
		// or the index is not in array range
		// return the original array
		if (arr == null || index < 0 || index >= arr.length) {
			return arr;
		}

		// return the resultant array
		return IntStream
				.range(0, arr.length)
				.filter(i -> i != index)
				.map(i -> arr[i])
				.toArray();
	}

	private static int[] insertElementAtGivenPosition(int[] array, int key, int index) {
		
		List<Integer> result = IntStream
				.of(array)
				.boxed()
				.collect(Collectors.toList());
		
		result.add(index, key);

		return result
				.stream()
				.mapToInt(Integer::intValue)
				.toArray();
	}
	
	/**
	 * Returns a map of deletion position.
	 */
	public static HashMap<Integer, Integer> getDeletePosition() {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int[] deletePositionArray = {10, 50, 100, 200, 400, 600, 800, 100}; // given as part of the assignment
		
		for (int i = 1; i <= 8; i++) {
			map.put(i, deletePositionArray[i - 1]);
		}
		
		return map;
	}

}
