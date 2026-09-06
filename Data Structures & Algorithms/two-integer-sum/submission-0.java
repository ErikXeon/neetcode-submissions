class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int targetNum = target - currentNum;
            if(map.containsKey(targetNum)) {
                return new int[] {map.get(targetNum), i};
            }
            map.put(currentNum, i);
        }
        return new int[] {};
    }
}