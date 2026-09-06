class Solution {
    public int maxArea(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int s = 0;
        int result = 0;
        while(left < right) {
            int window_size = right - left;
            if(nums[left] <= nums[right]) {
                s = window_size * nums[left];
                left++;
            }
            else if(nums[left] > nums[right]) {
                s = window_size * nums[right];
                right--;
            }
            result = Math.max(result, s);
        }
        return result;
    }
}
