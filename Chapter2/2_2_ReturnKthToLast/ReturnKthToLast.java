class ReturnKthToLast {

  static LinkedListNode returnKthToLast(LinkedListNode head, int index) {
    int len = 0;
    LinkedListNode end = head;
    while (end.next != null) {
      len ++;
    }

    int idx = len-k;
    LinkedListNode lastK = head;
    for (int i=0; i<idx; i++) {
      lastK = lastK.next;
    }

    while (lastK != null) {
      System.out.println(lastK.val);
      lastK = lastK.next;
    }

    return lastK;
  }

  public static void main(String[] args) {
    LinkedListNode head = new LinkedListNode(1);
    LinkedListNode end = head;
    end.next = new LinkedListNode(2);
    end = end.next;
    end.next = new LinkedListNode(4);

    System.out.println(returnKthToLast(head, 1));
  }
}

class LinkedListNode {
  int val;
  LinkedListNode next;
  LinkedListNode(int val) {
    this.val = val;
    next = null;
  }
}

