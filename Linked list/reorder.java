Reorder the given singly-linked list N1 -> N2 -> N3 -> N4 -> … -> Nn -> null to be N1- > Nn -> N2 -> Nn-1 -> N3 -> Nn-2 -> … -> null

Examples

L = null, is reordered to null
L = 1 -> null, is reordered to 1 -> null
L = 1 -> 2 -> 3 -> 4 -> null, is reordered to 1 -> 4 -> 2 -> 3 -> null
L = 1 -> 2 -> 3 -> null, is reordred to 1 -> 3 -> 2 -> null

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
  public ListNode reorder(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode middleRight = cutMiddle(head);
    middleRight = reverse(middleRight);
    ListNode cur = head;
    ListNode sec = middleRight;
    while (sec != null) {
      ListNode after = cur.next;
      cur.next = sec;
      ListNode temp = sec.next;
      sec.next = after;
      cur = after;
      sec = temp;
    }
    return head;
  }

  private ListNode cutMiddle(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode after = slow.next;
    slow.next = null;
    return after;
  }

  private ListNode reverse(ListNode head) {
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
