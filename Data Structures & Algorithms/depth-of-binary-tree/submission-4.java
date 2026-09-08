/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{root, 1});
        int max = 0;
        while(!stack.isEmpty()) {
            Object[] cur = stack.pop();
            TreeNode node = (TreeNode) cur[0];
            int depth = (int) cur[1];
            max = Math.max(max, depth);
            if(node.left !=null) stack.push(new Object[] {node.left, depth + 1});
            if(node.right !=null) stack.push(new Object[] {node.right, depth + 1});
        }
        return max;
    }
}
