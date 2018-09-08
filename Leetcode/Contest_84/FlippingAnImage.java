import java.util.Arrays;

class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
        	A[i] = flipRow(A[i]);
        }
        return A;
    }

    public int[] flipRow(int[] row) {
    	for (int i = 0; i < row.length / 2; i++) {
    		int last = row.length - i - 1;
    		int temp = row[last];
    		row[last] = row[i] ^ 1;
    		row[i] = temp ^ 1;
    	}
    	if (row.length % 2 != 0) {
    		int mid = row.length / 2;
    		row[mid] = row[mid] ^ 1;
    	}
    	return row;
    }

    public static void main(String[] args) {
    	FlippingAnImage fai = new FlippingAnImage();
    	int[][] case1 = {{1,1,0},{1,0,1},{0,0,0}};
    	int[][] converted = fai.flipAndInvertImage(case1);
    	for (int i = 0; i < converted.length; i++) {
    		System.out.println(Arrays.toString(converted[i]));
    	}
    	
    }
}