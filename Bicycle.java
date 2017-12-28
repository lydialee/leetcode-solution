/*
	given a list of locations of bicycles. 
	A[i] = k means: the ith bike is located at k.
	now you need to locate a new bike, two conditions:
		1) put it in the area between leftest and rightest bikes.
		2) maximize the distance between with the nearst left and right bikes.
	return the distance above.
 */
import java.util.Arrays;

class Bicycle {
	public static int solution(int[] bikes) {
		Arrays.sort(bikes);
		int ret = Integer.MIN_VALUE;
		for (int i = 1; i < bikes.length; i++) {
			ret = Math.max(ret, bikes[i] - bikes[i - 1]);
		}

		return ret / 2;
	}

	public static void main(String[] args) {
		int[] t1 = {-1,8,0,2,10};
		System.out.println(solution(t1));
	}
}