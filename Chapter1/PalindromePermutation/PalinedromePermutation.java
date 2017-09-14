import java.lang.StringBuffer;
import java.util.LinkedList;

class PalinedromePermutation {
  public static void main(String[] args) {
    String test1 = "taco cat";
    String test2 = "train";

    System.out.println(palinedromePermutation(test1));
    System.out.println(palinedromePermutation(test2));
  }

  public static boolean palinedromePermutation(String input) {
    StringBuffer buff = new StringBuffer(input.toLowerCase());
    LinkedList<Character> found = new LinkedList<Character>();
    for (int i=0; i<buff.length(); i++) {
      if (i+1 < buff.length()) {
        int index = buff.indexOf(buff.substring(i, i+1), i+1);
        if (index == -1) {
          found.add(buff.charAt(i));
        } else {
          buff.deleteCharAt(index);
        }
      }
    }
    if (found.size() > 1) {
      return false;
    } else {
      return true;
    }
  }
}
