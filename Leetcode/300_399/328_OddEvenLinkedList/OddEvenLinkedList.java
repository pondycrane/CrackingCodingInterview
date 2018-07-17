class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode oddP = null;
        ListNode even = new ListNode(0);
        ListNode evenAnchor = even;
        while (odd != null && odd.next != null) {
        	ListNode temp = odd.next;
        	odd.next = odd.next.next;
        	oddP = odd;
        	odd = odd.next;
        	temp.next = even.next;
        	even.next = temp;
        	even = even.next;
        }
        if (odd != null) {
        	odd.next = evenAnchor.next;
        } else {
        	oddP.next = evenAnchor.next;
        }
        return head;
    }

	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }

		public String toString() {
			ListNode now = this;
			StringBuilder sb = new StringBuilder();
			while (now != null) {
				sb.append(Integer.toString(now.val));
				sb.append(", ");
				now = now.next;
			}
			return sb.toString();
		}
	}

	private static ListNode generateLN(int[] data) {
		ListNode result = new ListNode(0);
		ListNode now = result;
		for (int i = 0; i < data.length; i++) {
			now.next = new ListNode(data[i]);
			now = now.next;
		}
		return result.next;
	}

	public static void main(String[] args) {
		OddEvenLinkedList oell = new OddEvenLinkedList();

		ListNode case1 = generateLN(new int[]{1, 2, 3, 4, 5});
		System.out.println(oell.oddEvenList(case1));

		ListNode case2 = generateLN(new int[]{2, 1, 3, 5, 6, 4, 7});
		System.out.println(oell.oddEvenList(case2));
	}
}