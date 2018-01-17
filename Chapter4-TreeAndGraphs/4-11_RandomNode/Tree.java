/**
 * You are implementing a binary tree class from scratch,
 * which in addition to insert, delete, find method, there
 * is an additional method called getRandomNode(). The method
 * returned a node under the tree randomly
 */

import java.lang.StringBuilder;
import java.util.Random;

class Tree {
  RandomNode root;
  int size;

  public static void main(String[] args) {
    System.out.println("syit");
  }
}

class RandomNode {
  int val;
  int size;
  RandomNode left;
  RandomNode right;

  public static void main(String[] args) {
    RandomNode root = new RandomNode(10);
    root.inorderInsertion(4);
    root.inorderInsertion(9);
    root.inorderInsertion(12);
    System.out.println(root.getRandomNode());
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Integer.toString(this.val));
    return sb.toString();
  }

  RandomNode(int val) {
    this.val = val;
    this.size = 1;
    this.left = null;
    this.right = null;
  }

  public int size() { return this.size; }
  public int getValue() { return this.val; }
  public void inorderInsertion(int val) {
    if (val <= this.val) {
      if (this.left == null) {
        this.left = new RandomNode(val);
      } else {
        this.left.inorderInsertion(val);
      }
    } else {
      if (this.right == null) {
        this.right = new RandomNode(val);
      } else {
        this.right.inorderInsertion(val);
      }
    }
    this.size ++;
  }

  public RandomNode getRandomNode() {
    int leftSize = this.left == null ? 0 : this.left.size();
    Random rd = new Random();
    int randomInd = rd.nextInt(this.size);
    return randomInd == leftSize ? this : randomInd < leftSize ? this.left.getRandomNode() : this.right.getRandomNode();
  }

  public RandomNode getIthNode(int ind) {
    int leftSize = this.left == null ? 0 : this.left.size();
    if (leftSize == ind) return this;
    else if (ind < leftSize) return this.left.getIthNode(ind);
    else return this.right.getIthNode(ind - leftSize - 1);
  }
}
