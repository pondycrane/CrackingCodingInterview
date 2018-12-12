

class Solution{
    public int minDeletionSize(String[] A) {
        if (A[0].length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            char min = A[0].charAt(i);
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) < min) {
                    count += 1;
                    break;
                }
                min = A[j].charAt(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] case1 = {"cba","daf","ghi"}; //1
        String[] case2 = {"a","b"}; //0
        String[] case3 = {"zyx","wvu","tsr"}; //3
        Solution solution = new Solution();
        System.out.println(solution.minDeletionSize(case1));
        System.out.println(solution.minDeletionSize(case2));
        System.out.println(solution.minDeletionSize(case3));
    }
}
