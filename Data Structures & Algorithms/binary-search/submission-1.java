class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int midl = left + (right - left) / 2;
            if(nums[midl] == target) return midl;
            if(nums[midl] > target) {
                right = midl - 1;
            }
            if(nums[midl] < target) {
                left = midl + 1;
            }
        }
        return -1;
    }
}
