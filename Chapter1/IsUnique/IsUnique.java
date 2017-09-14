import java.lang.StringBuilder;

class IsUnique {
  public static void main(String[] args) {
    System.out.println(isUnique("hahaha"));
    System.out.println(isUnique("whathe"));
    System.out.println(isUnique("123456"));
  }

  public static boolean isUnique(String test) {
    String newString = "";
    for (int i=0; i<test.length(); i++) {
      if (newString.contains(test.substring(i, i+1))) {
        return true;
      } else {
        newString += test.charAt(i);
      }
    }
    return false;
  }
}
