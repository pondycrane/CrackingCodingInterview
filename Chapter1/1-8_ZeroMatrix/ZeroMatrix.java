/**
 * Write an algorithm that if a MxN array has an element 0,
 * write the entire row and column to 0
 */

import java.util.Arrays;
import java.lang.StringBuilder;

class ZeroMatrix {
  public static void main(String[] args) {
    ZeroMatrix zm = new ZeroMatrix();
    int[][] c1 = { { 1, 2, 4}, {3, 0, 5}, {1, 5, 5} };
    zm.setZerosMemo(c1);
    System.out.println(zm.print2Darray(c1));
  }

  public String print2Darray(int[][] arr) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<arr.length; i++) {
      sb.append(Arrays.toString(arr[i]));
      sb.append('\n');
    }
    return sb.toString();
  }

  public void setZerosMemo(int[][] matrix) {
    boolean[] row = new boolean[matrix.length];
    boolean[] col = new boolean[matrix.length];
    for (int i=0; i<matrix.length; i++) {
      for (int j=0; j<matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
        }
      }
    }

    // Set rows to zero
    for (int i=0; i<row.length; i++) {
      if (row[i]) {
        for (int j=0; j<matrix[i].length; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    // Set cols to zero
    for (int j=0; j<col.length; j++) {
      if (col[j]) {
        for (int i=0; i<matrix.length; i++) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
