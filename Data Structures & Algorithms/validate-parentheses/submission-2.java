class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> pairs = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
        );
        for(char c : s.toCharArray()) {
            if(pairs.containsKey(c)) {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) {
                    return false;
                }
                char prev = stack.pop();
                if(c != pairs.get(prev)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
