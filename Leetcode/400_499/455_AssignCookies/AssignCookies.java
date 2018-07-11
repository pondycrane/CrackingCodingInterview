import java.util.Arrays;

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int satisfied = 0;
        int gP = 0;
        int sP = 0;
        while (gP < g.length && sP < s.length) {
            if (s[sP] >= g[gP]) {
                satisfied = satisfied + 1;
                gP = gP + 1;
            }
            sP = sP + 1;
        }
        return satisfied;
    }

    public static void main(String[] args) {
        AssignCookies ac = new AssignCookies();
        int[] gCase1 = {1, 2, 3};
        int[] sCase1 = {1, 1};
        System.out.println(ac.findContentChildren(gCase1, sCase1));

        int[] gCase2 = {1, 2};
        int[] sCase2 = {1, 2, 3};
        System.out.println(ac.findContentChildren(gCase2, sCase2));

        int[] gCase3 = {10, 9, 8, 7};
        int[] sCase3 = {5, 6, 7, 8};
        System.out.println(ac.findContentChildren(gCase3, sCase3));
    }
}
