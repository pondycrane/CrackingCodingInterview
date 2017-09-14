import java.util.Arrays;

class CheckPermutation {
  public static void main(String[] args) {
    System.out.println(checkPermutation("4234", "34234"));
    System.out.println(checkPermutation("model", "ledmo"));
    System.out.println(checkPermutation("4234", "34234"));
    System.out.println(checkPermutation("4234", "34234"));
  }

  public static boolean checkPermutation(String str1, String str2) {
    char[] char1 = str1.toCharArray();
    char[] char2 = str2.toCharArray();
    Arrays.sort(char1);
    Arrays.sort(char2);
    return new String(char1).equals(new String(char2));
  }
}

