class Solution {
    public int calculate(String s) {
        int[] result = df(0, s);
        return result[1];
    }
    
    private static int[] df(int ind, String s) {
        int sum = 0;
        if (ind >= s.length()) {
            return new int[]{ind, sum};
        }
        boolean add = true;
        int currentInt = 0;
        for (int i = ind; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '(') {
                if (currentInt != 0) {
                    sum = checkpoint(add, sum, currentInt);
                    currentInt = 0;
                }
                int[] result = df(i + 1, s);
                if (add) {
                    sum += result[1];
                } else {
                    sum -= result[1];
                }
                i = result[0];
            } else if (now == ')') {
                if (currentInt != 0) {
                    sum = checkpoint(add, sum, currentInt);
                    currentInt = 0;
                }
                return new int[]{i, sum};
            } else if (now == '+') {
                if (currentInt != 0) {
                    sum = checkpoint(add, sum, currentInt);
                    currentInt = 0;
                }
                add = true;
            } else if (now == '-') {
                if (currentInt != 0) {
                    sum = checkpoint(add, sum, currentInt);
                    currentInt = 0;
                }
                add = false;
            } else if (now == ' ') {
                if (currentInt != 0) {
                    sum = checkpoint(add, sum, currentInt);
                    currentInt = 0;
                }
            } else {
                currentInt = (currentInt * 10 + (now - '0'));
            }
        }
        if (currentInt != 0) {
            sum = checkpoint(add, sum, currentInt);
            currentInt = 0;
        }
        return new int[]{s.length(), sum};
    }

    private static int checkpoint(boolean add, int sum, int currentInt) {
        if (add) {
            sum += currentInt;
        } else {
            sum -= currentInt;
        }
        return sum;
    }

    public static void main(String[] args) {
        String case1 = "1 + 1";
        Solution solution = new Solution();
        System.out.println(solution.calculate(case1));
        String case2 = "2147483647";
        System.out.println(solution.calculate(case2));
        String case3 = "1-(5)";
        System.out.println(solution.calculate(case3));
        String case4 = "2-(5-6)";
        System.out.println(solution.calculate(case4));
    }
}
