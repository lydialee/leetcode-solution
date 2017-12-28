/*
	given four digits, return max valid time.
	HH:MM
 */

class MaxTime {
	public static String createTime(int A, int B, int C, int D) {
	    int[] numbers = {A, B, C, D};
	    int[] time = new int[4];
	    String ret = "";
	    
	    time[0] = findMaxSpecific(numbers, 2);
	    time[1] = time[0] == 2 ? findMaxSpecific(numbers, 3) : 
	    						findMaxSpecific(numbers, 9);
	    time[2] = findMaxSpecific(numbers, 5);
	    time[3] = findMaxSpecific(numbers, 9);
	    
	    for (int i = 0; i < time.length; i++) {
	    	if (time[i] == -1) return "NOT POSSIBLE";
	    	ret += time[i];
	    	if (i == 1) ret += ":";
	    }
	    return ret;
	}

	public static int findMaxSpecific(int[] arr, int valToFind) {
	    if (arr.length != 4) return -1;
	    int numToFind = -1; 
	    int indexToRemove = -1;

	    for (int i = 0; i < arr.length; i++) {
	        if (arr[i] <= valToFind) {
	            if (arr[i] > numToFind) {
	                numToFind = arr[i];
	                indexToRemove = i;
	            }
	        }
	    }
	    if (indexToRemove == -1) return -1;
	    arr[indexToRemove] = -1;
	    return numToFind;
	}

	public static void main(String[] args) {
        System.out.println(createTime(1, 8, 3, 2));
        System.out.println(createTime(2, 4, 0, 0));
        System.out.println(createTime(3, 0, 7, 0));
        System.out.println(createTime(9, 1, 9, 7));
	}
}