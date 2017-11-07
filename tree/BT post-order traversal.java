Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Post-order traversal is [1, 4, 3, 11, 8, 5]

Corner Cases

What if the given binary tree is null? Return an empty list in this case.
How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
//using 2 stacks
public class Solution {
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> ret = new ArrayList<Integer>();
    Stack<TreeNode> stack1 = new Stack<TreeNode>();
    Stack<TreeNode> stack2 = new Stack<TreeNode>();
    if (root == null) return ret;
    stack1.push(root);
    while (!stack1.isEmpty()) {
      TreeNode cur = stack1.pop();
      stack2.push(cur);
      if (cur.left != null) stack1.push(cur.left);
      if (cur.right != null) stack1.push(cur.right);
    }
    while (!stack2.isEmpty()) {
      TreeNode cur = stack2.pop();
      ret.add(cur.key);
    }
    return ret;
  }
}
