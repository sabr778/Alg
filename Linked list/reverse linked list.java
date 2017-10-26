Reverse a singly-linked list.

Examples

L = null, return null
L = 1 -> null, return 1 -> null
L = 1 -> 2 -> 3 -> null, return 3 -> 2 -> 1 -> null

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = head;
    ListNode cur = head.next;
    while (cur != null) {
      ListNode after = cur.next;
      cur.next = prev;
      prev = cur;
      cur = after;
    }
    head.next = null;
    return prev;
  }
}
