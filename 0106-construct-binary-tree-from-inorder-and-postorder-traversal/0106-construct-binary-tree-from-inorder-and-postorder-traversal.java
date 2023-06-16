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

    public TreeNode ans(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;

        root.left = ans(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = ans(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd -1);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return ans(inorder, 0, inorder.length - 1, postorder, 0, postorder.length -1);
    }
}