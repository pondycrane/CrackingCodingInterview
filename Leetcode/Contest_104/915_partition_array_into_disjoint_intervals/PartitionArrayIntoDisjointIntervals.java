import java.util.Arrays;

class PartitionArrayIntoDisjointIntervals {
    public static int partitionDisjoint(int[] A) {
        int[] minArray = new int[A.length];
        for (int i = A.length - 1; i >=0; i--) {
            if (i == A.length - 1) {
                minArray[i] = A[i];
            } else {
                minArray[i] = Math.min(minArray[i + 1], A[i]);
            }
        }
        System.out.println(Arrays.toString(minArray));
        int[] maxArray = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                maxArray[i] = A[i];
            } else {
                maxArray[i] = Math.max(maxArray[i - 1], A[i]);
            }
        }
        System.out.println(Arrays.toString(maxArray)); 
        int sep = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (maxArray[i] <= minArray[i + 1]) {
                sep = i;
                break;
            }
        }
        return sep + 1;
    }

    public static void main(String[] args) {
        int[] case1 = {5, 0, 3, 8, 6};
        System.out.println(partitionDisjoint(case1));

        int[] case2 = {1, 1, 1, 0, 6, 12};
        System.out.println(partitionDisjoint(case2));
    }
}
