Implement an iterative, in-order traversal of a given binary tree, return the list of keys of each node in the tree as it is in-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

In-order traversal is [1, 3, 4, 5, 8, 11]

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
public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> ret = new ArrayList<Integer>();
    if (root == null) return ret;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      if (root.left != null) {
        stack.push(root.left);
        root = root.left;
      } else {
        TreeNode temp = stack.pop(); // I know this is right, but not that perfect.
        ret.add(temp.key);
        if (temp.right != null) {
          stack.push(temp.right);
          root = temp.right;
        }
      }
    }
    return ret;
  }
}
