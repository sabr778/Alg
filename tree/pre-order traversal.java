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
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> ret = new ArrayList<Integer>();
    if (root == null) return ret;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        stack.push(cur);
        ret.add(cur.key);
        cur = cur.left;
      } else {
        TreeNode cur = stack.pop(); 
        cur = cur.right;
      }
    }
    return ret;
  }
}