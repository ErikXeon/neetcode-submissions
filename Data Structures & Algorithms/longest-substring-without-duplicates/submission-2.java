class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        for(int right = 0; right < s.length(); right++) {
            if(!set.add(s.charAt(right))) {
            while(!set.add(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
                set.add(s.charAt(right));
            }
            result = Math.max(result, set.size());
        }
        return result;
    }
}
