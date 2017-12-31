/**
 * This is a MergeSort algorithm for LinkedList
 * Time complexity: O(nlogn), space complexity: O(1)
 *
 * @author Hank Huang
 * @lastmodified 20171230
 */

import java.lang.StringBuilder;

class  MergeSortLinkedList {
  public static void main(String[] args) {
    ListNode data = new ListNode(0);
    ListNode temp = data;
    temp.next = new ListNode(9);
    temp = temp.next;
    temp.next = new ListNode(4);
    System.out.println("not sorted data: " + data);
    data = sortList(data);
    System.out.println("sorted data: " + data);
  }

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public String toString() {
      StringBuilder result = new StringBuilder("[");
      ListNode now = this;
      while (now != null) {
        result.append(Integer.toString(now.val));
        result.append(", ");
        now = now.next;
      }
      result.append("]");
      return result.toString();
    }
  }

  public static ListNode sortList(ListNode head) {
    return mergeSort(head);
  }

  public static ListNode mergeSort(ListNode head) {
    if (head == null) return head;
    
    ListNode slow = head;
    ListNode sPrev = head; // Need previous node to cut the LinkedList in half
    ListNode fast = head;
    int len = 0;
    // Find middle point, devide
    while (slow != null && fast != null && fast.next != null) {
      slow = slow.next;
      if (len > 0) {
        sPrev = sPrev.next;
      }
      fast  = fast.next.next;
      len ++;
    }
    // If only one node left, return, else conquer with merging
    if (!head.equals(slow)) {
      sPrev.next = null;
      ListNode first = mergeSort(head);
      ListNode second = mergeSort(slow);
      ListNode merged = new ListNode(0);
      ListNode temp = merged;
      while (first != null && second != null) {
        if (first.val < second.val) {
          temp.next = first;
          first = first.next;
        } else {
          temp.next = second;
          second = second.next;
        }
        temp = temp.next;
        temp.next = null;
      }
      while (first != null) {
        temp.next = first;
        first = first.next;
        temp = temp.next;
      }
      while (second != null) {
        temp.next = second;
        second = second.next;
        temp = temp.next;
      }
      return merged.next;
    } else {
      return head;
    }
  }
}
