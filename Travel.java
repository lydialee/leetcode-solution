/*
	given a list of places. each number represent a place.
	return the min days that contains all places.
	length of array places is N in [1, 100 000]. each element is in [0, N - 1]
	each loacation is non-zero array.
	[1, 2, 1, 2, 3] -> [1, 2, 3] -> 3
 */
import java.util.Map;
import java.util.HashMap;

class Travel {
	// space O(n), time O(n)
	// if we know the range of numbers, map can be replaced by int[], then O(1) space.
	public static int solution(int[] A) {
		if (A == null) return 0;
		if (A.length <= 1) return A.length;

		int[] placeCount = new int[100001];
		for (Integer place : A) {
			placeCount[place]++;
		}

		int start = 0, end = A.length - 1;
		while (start < end && placeCount[A[start]] > 1) {
			placeCount[A[start++]]--;
		}
		System.out.println("start: "+start);
		while (start < end && placeCount[A[end]] > 1) {
			placeCount[A[end--]]--;
		}
		System.out.println("end: "+end);
		return end - start + 1;
	}

	public static void main(String[] args) {
		int[] t1 = {1, 2, 1, 2, 3};
		System.out.println(solution(t1));
		int[] t2 = {7,3,7,3,1,3,4,1};
		System.out.println(solution(t2));
		int[] t3 = {10, 2, 1, 2, 5, 5, 7, 10};
		System.out.println(solution(t3));
	}
}