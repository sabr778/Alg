Insert a value in a sorted linked list.

Examples

L = null, insert 1, return 1 -> null
L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null

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
  public ListNode insert(ListNode head, int value) {
    if (head == null || value <= head.value) {
      ListNode newHead = new ListNode(value);
      newHead.next = head;
      return newHead;
    }
    ListNode prev = head;
    ListNode cur = head.next;
    while (cur != null && cur.value < value) {
      prev = cur;
      cur = cur.next;
    }
    prev.next = new ListNode(value);
    prev.next.next = cur;
    return head;
  }
}