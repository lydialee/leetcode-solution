class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int current = nums[0];
        int count = 1;
        int prev = 0; // prevCount
        int result = 0;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == current) {
                count ++;
            } else {
                if (nums[i] == current + 1) {
                    prev = count;
                } else {
                    prev = 0;
                }
                current = nums[i];
                count = 1;
            }
            
            if (prev > 0) {
                result = Math.max(result, prev + count);
            }
        }
        return result;
    }
}
