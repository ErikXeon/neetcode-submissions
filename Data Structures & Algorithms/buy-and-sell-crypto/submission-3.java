class Solution {
    public int maxProfit(int[] nums) {
        int left = 0;
        int result = 0;

        for(int right = 0; right < nums.length; right++) {
            int min = nums[left];
            if(nums[right] < min) {
                while(left != right) {
                    left++;
                }
                continue;
            }
              int pr = nums[right] - nums[left];
              result = Math.max(pr, result);
        }
        return result;
    }
}
