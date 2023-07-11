/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> nodeParent;

    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            nodeParent.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        nodeParent = new HashMap<>();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(null);
        queue.offer(target);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(null);
        seen.add(target);

        int depth = 0;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                if (depth == k) {
                    List<Integer> list = new ArrayList<>();
                    for (TreeNode node: queue) {
                        list.add(node.val);
                    }
                    return list;
                }
                depth++;
                queue.offer(null);
            }else {
                if (!seen.contains(temp.left)) {
                    seen.add(temp.left);
                    queue.offer(temp.left);
                }
                if (!seen.contains(temp.right)) {
                    seen.add(temp.right);
                    queue.offer(temp.right);
                }
                TreeNode parent = nodeParent.get(temp);
                if (!seen.contains(parent)) {
                    seen.add(parent);
                    queue.offer(parent);
                }
            }
        }

        return new ArrayList<>();
    }
}