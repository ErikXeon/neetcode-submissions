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
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode temp = new TreeNode();
        TreeNode curr = new TreeNode();
        if(root == null) return root;
        stack.push(root);
        while(!stack.isEmpty()) {
            curr = stack.pop();
            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }
        return root;
    }
}
