/*
	1 Binary Search
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0
            || matrix[0].length == 0) return -1; // not found
        
        // b-search: step1, find the middle
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1] + 1;
        while (low < high) {
            // count how many <= mid
            int count = 0, mid = low + (high - low) / 2, j = n - 1;
            for (int i = 0; i < m; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/*
	2 Priority Queue
*/
