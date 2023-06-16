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
    public TreeNode ans(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
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

        preStart = preStart + 1;

        root.left = ans(preorder, preStart, preStart + leftSize - 1, inorder, inStart, rootIndex - 1);
        root.right = ans(preorder, preEnd - rightSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return ans(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}