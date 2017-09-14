import java.util.Arrays;

/**
 * Insertion sort is an O(N**2) sorting algorithm
 */
class InsertionSort {
  public static void main(String[] args) {
    int[] testCase1 = {5, 2, 4, 9};
    System.out.println("Before sort: " + Arrays.toString(testCase1));
    insertionSort(testCase1);
    System.out.println("After sort: " + Arrays.toString(testCase1));
  }

  /**
   * Sort array using swap method
   * Faster than fixed insertion point, but this is unstable
   *
   * @param ints Array to be sorted
   */
  static public void insertionSort(int[] ints) {
    if (ints.length > 0) {
      for (int i=1; i<ints.length; i++) {
        for (int j=i-1; j>=0; j--) {
          if (ints[j] > ints[i]) {
            int temp = ints[i];
            ints[i] = ints[j];
            ints[j] = temp;
            break;
          }
        }
      }
    }
  }
}
