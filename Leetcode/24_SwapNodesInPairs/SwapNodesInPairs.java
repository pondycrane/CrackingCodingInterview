class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode now = head;
		// Swapping first pair
		ListNode temp = now.next.next;
		head = now.next;
		head.next = now;
		head.next.next = temp;
		swapPairsHelper(head.next);
		return head;
	}

	private void swapPairsHelper(ListNode root) {
		if (root == null || root.next == null || root.next.next == null) {
			return;
		} else {
			ListNode temp = root.next;
			ListNode temp1 = root.next.next.next;
			root.next = root.next.next;
			root.next.next = temp;
			root.next.next.next = temp1;
		}
		swapPairsHelper(root.next.next);
	}

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("[");
			ListNode now = this;
			while (now != null) {
				sb.append(String.valueOf(now.val));
				now = now.next;
				if (now != null) {
					sb.append(", ");
				}
			}
			sb.append("]");
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		SwapNodesInPairs snip = new SwapNodesInPairs();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head = snip.swapPairs(head);
		System.out.println(head);
	}
}