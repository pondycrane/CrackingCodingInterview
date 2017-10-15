/**
 * This is a quicksort algorithm
 */

class QuickSort {
  public static void main(String[] args) {
    int[] arr = {5,3,1,8,0,9,5,3,8};
    quickSort(arr, 0, arr.length-1);
  }

  public static void printArray(int[] arr) {
    for (int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + ", ");
    }
    System.out.println("");
  }

  public static void quickSort(int[] arr, int left, int right) {
    printArray(arr);
    int index = partition(arr, left, right);
    System.out.println("Index: " + index);
    if (left < index -1) {
        quickSort(arr, left, index - 1);
    }
    if (index < right) {
      quickSort(arr, index, right);
    }
  }
  
  public static int partition(int[] arr, int left, int right) {
    int pivot = arr[(left + right) / 2];
    while (left <= right) {
      while (arr[left] < pivot) left ++;
      
      while (arr[right] > pivot) {
        right --;
      }
      
      if (left <= right) {
        swap(arr, left, right);
        left ++;
        right --;
      }
    }
    return left;
  }
    
  public static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}
