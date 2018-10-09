/**
 * Given a sorted array, find a magic
 * number where A[i] = i
 * Use recusion or iterative approach
 */

class MagicIndex {
  public static void main(String[] args) {
    int[] testCase1 = {-7, -3, -2, 0, 2, 3, 4, 6, 7, 9};
    int[] testCase2 = {-3, 0, 2, 8, 10};
    int[] testCase3 = {1};
    System.out.println("TestCase1: " + magicRecursion(testCase1, testCase1.length/2));
    System.out.println("TestCase2: " + magicRecursion(testCase2, testCase2.length/2));
    System.out.println("TestCase3: " + magicRecursion(testCase3, testCase3.length/2));

    System.out.println("TestCase1: " + magicIterative(testCase1));
    System.out.println("TestCase2: " + magicIterative(testCase2));
    System.out.println("TestCase3: " + magicIterative(testCase3));
  }

  /**
   * If A[i] < i, the magic number will appear at the right side of i
   */
  static int magicRecursion(int[] array, int ind) {
    if (array == null) {
      return -1;
    } else if (array.length == 0) {
      return -1;
    } else if (array[ind] == ind) {
      return ind;
    }

    int nextInd = array[ind] < ind ? (ind + ((array.length - ind)/2)) :  (0 + ind/2);
    if (nextInd == ind)
      return -1;

    return magicRecursion(array, nextInd);
  }

  /**
   * An iterative version for finding magic index
   */
  static int magicIterative(int[] array) {
    if (array == null) {
      return -1;
    } else if (array.length == 0) {
      return -1;
    } else {
      int ind = -1;
      int nextInd = array.length/2;
      while (nextInd != ind) {
        ind = nextInd;
        nextInd = array[ind] < ind ? (ind + ((array.length - ind)/2)) : array[ind] > ind ? (0 + ind/2) : ind;
      }
      return array[ind] == ind ? ind : -1;
    }
  }
}

