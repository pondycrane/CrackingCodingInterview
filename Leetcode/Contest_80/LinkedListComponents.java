/**
 * We are given head, the head node of a linked list containing unique
 * integer values.
 * We are also given the list G, a subset of the values in the linked list.
 * Return the number of connected components in G, where two values are
 * connected if they appear consecutively in the linked list.
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.stream.Collectors;

class LinkedListComponents {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> gSet = new HashSet<>(Arrays.stream(G).boxed().collect(Collectors.toList()));
        int count = 0;
        boolean continuing = false;
        ListNode now = head;
        while (now != null) {
        	if (gSet.contains(now.val)) {
        		if (!continuing) {
	        		count = count + 1;
	        		continuing = true;
        		}
        	} else {
        		continuing = false;
        	}
        	now = now.next;
        }
        return count;
    }

	private static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		LinkedListComponents llc = new LinkedListComponents();
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		int[] G = {0, 1, 3};
		System.out.println(llc.numComponents(head, G));
	}
}