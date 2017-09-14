import java.lang.StringBuilder;

class OneAway {
  public static void main(String[] args) {
    System.out.println(oneAway("bone", "bon"));
    System.out.println(oneAway("bone", "bonb"));
    System.out.println(oneAway("teacher", "teacer"));
    System.out.println(oneAway("monster", "deadly"));
  }

  public static boolean oneAway(String str1, String str2) {
    String start = "";
    String partner = "";
    boolean clean = true;
    StringBuilder ref = new StringBuilder();

    if (str1.length() < str2.length()) {
      start = str1;
      partner = str2;
    } else {
      start = str2;
      partner = str1;
    }

    if (start.length() - partner.length() > 1) {
      return false;
    }

    int i = 0;
    while (clean && i<start.length()) {
      if (start.charAt(i) == partner.charAt(i)) {
        ref.append(start.charAt(i));
      } else {
        ref.append(partner.charAt(i));
        if (start.length() == partner.length()) {
          ref.append(start.substring(i+1));
        } else {
          ref.append(start.substring(i));
        }
        clean = false;
      }

      if (i == start.length() -1 ) {
        if (partner.length() > start.length()) {
          ref.append(partner.charAt(i+1));
        }
        clean = false;
      }
     i++;
    }

    return ref.toString().equals(partner);
  }
}
