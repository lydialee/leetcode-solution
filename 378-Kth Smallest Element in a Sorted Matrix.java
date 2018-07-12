/*
	1 Binary Search
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0
            || matrix[0].length == 0) return -1; // not found
        
        // b-search: step1, find the middle
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1] + 1;
        while (low < high) {
            // count how many <= mid
            int count = 0, mid = low + (high - low) / 2, j = n - 1;
            for (int i = 0; i < n; i++) {
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
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        int n = matrix.length;
            
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxHeap.offer(matrix[i][j]);    
                if (maxHeap.size() > k) {
                    maxHeap.poll();  
                }
            }
        }
        
        return maxHeap.peek();
    }
}

/*
	2 Array
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] list = new int[m*n];

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                list[i * m + j] = matrix[i][j];
            }
        }
        Arrays.sort(list);
        
        return list[k - 1];
    }
}