public class CanBalance{
	public static void main(String[] args) {
		int[] testArray1 = new int[]{1,1,1,2,1};
		int[] testArray2 = new int[]{2,1,1,2,1};
		int[] testArray3 = new int[]{10,10};

		System.out.println(canBalance(testArray1));
		System.out.println(canBalance(testArray2));
		System.out.println(canBalance(testArray3));
	}

	public static boolean canBalance(int[] arr){

		// GENERAL STRATEGY: Scan through once for the left side sum,
		// then scan from the right to left, subtracting each element
		// from the left and adding to the right. If left and right ever
		// equal, return true. Else return false.

		int leftSum = 0;
		int rightSum = 0;

		for (int i : arr){
			leftSum += i;
		}

		for (int i = arr.length - 1; i >= 0; i--){
			leftSum -= arr[i];
			rightSum += arr[i];

			if (leftSum == rightSum){
				return true;
			}
		}

		return false;
	}
}