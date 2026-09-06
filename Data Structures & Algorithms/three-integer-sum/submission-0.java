class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int curr = 0; curr < nums.length; curr++) {
            if (curr > 0 && nums[curr] == nums[curr - 1]) continue;
            int left = curr + 1;
            int right = nums.length - 1;
            int target = -nums[curr];

            while(left < right) {
                if(nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[curr], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left -1]) left++;
                    while(left < right && nums[right] == nums[right +1])  right--;
                }
                else if(nums[left] + nums[right] > target) {
                    right--;
                }
                else if(nums[left] + nums[right] < target) {
                    left++;
                }
            }
        }
        return result;
    }
}
