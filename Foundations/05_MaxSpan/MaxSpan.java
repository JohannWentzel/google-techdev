import java.util.*;

public class MaxSpan{
	public static void main(String[] args) {
		int[] testArr1 = new int[]{1,2,1,1,3};
		int[] testArr2 = new int[]{1,4,2,1,4,1,4};
		int[] testArr3 = new int[]{1,4,2,1,4,4,4};


		System.out.println(maxSpan(testArr1));
		System.out.println(maxSpan(testArr2));
		System.out.println(maxSpan(testArr3));

	}

	public static int maxSpan(int[] arr){

		// error case - returns 0 if nothing in the array
		if (arr.length == 0) return 0;

		// default to 1 - a single item is a span of 1.
		int maxSpan = 1;

		// keep track of the numbers we've already seen, as well as the first index they occur.
		HashMap scannedNums = new HashMap();

		for (int i = 0; i < arr.length; i++){
			// if it finds a match, calculate the span.
			if (scannedNums.containsKey(arr[i])){
				int previousOccurrence = (int)scannedNums.get(arr[i]);
				// add 1 here because of the definition of "span" as starting at 1.
				int span = i - previousOccurrence + 1;

				// if the span we found is larger, make that the max.
				maxSpan = Math.max(span,maxSpan);
			}
			// if we haven't seen the number before, put it in the hashmap.
			else{
				scannedNums.put(arr[i], i);
			}
		}

		return maxSpan;

	}
}