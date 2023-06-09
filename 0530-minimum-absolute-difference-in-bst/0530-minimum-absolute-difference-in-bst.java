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
    List<Integer> list = new ArrayList<>();
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp.val);
            temp = temp.right;
        }        
    }
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;

        inOrder(root);

        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }

        return res;
    }
}