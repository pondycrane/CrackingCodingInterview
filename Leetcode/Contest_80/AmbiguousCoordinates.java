/**
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  
 * Then, we removed all commas, decimal points, and spaces, and ended up
 * with the string S.  Return a list of strings representing all possibilities
 * for what our original coordinates could have been.
 *
 * Our original representation never had extraneous zeroes, so we never started
 * with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other 
 * number that can be represented with less digits.  Also, a decimal point within
 * a number never occurs without at least one digit occuring before it, so we 
 * never started with numbers like ".1".
 *
 * The final answer list can be returned in any order.  Also note that all
 * coordinates in the final answer have exactly one space between them (occurring
 * after the comma.)
 */

import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

class AmbiguousCoordinates {
	private static DecimalFormat df = new DecimalFormat("0.###############");
	public List<String> ambiguousCoordinates(String S) {
		if (S == null || S.length() <= 2) {
			return null;
		}
		List<String> list = new ArrayList<>();
		ambiguousCoordinatesHelper(list, S.substring(1, S.length() - 1), 1);
		return list;
	}

	private static void ambiguousCoordinatesHelper(List<String> list, String S, int ind) {
		if (ind >= S.length()) {
			return;
		}
		String left = S.substring(0, ind);
		String right = S.substring(ind);
		if (!checkValidString(left)) {
			ambiguousCoordinatesHelper(list, S, ind + 1);
		}
		if (checkValidString(left) && checkValidString(right)) {
			for (int i = 1; i < left.length() + 1; i++) {
				String ll = left.substring(0, i);
				String lr = left.substring(i);
				if (!checkValidLeftWing(ll)) {
					break;
				}
				if (!checkValidRightWing(lr)) {
					continue;
				}
				String l = ll + "." + lr;
				for (int j = 1; j < right.length() + 1; j++) {
					String rl = right.substring(0, j);
					String rr = right.substring(j);
					if (!checkValidLeftWing(rl)) {
						break;
					}
					if (!checkValidRightWing(rr)) {
						continue;
					}
					String r = rl + "." + rr;
					String toAdd = "(" + df.format(Double.valueOf(l)) + ", " + df.format(Double.valueOf(r)) + ")";
					list.add(toAdd);
				}
			}
			ambiguousCoordinatesHelper(list, S, ind + 1);
		} else if (checkValidString(left)) {
			ambiguousCoordinatesHelper(list, S, ind + 1);
		}
	}

	private static boolean checkValidString(String number) {
		if (number == null || number.isEmpty()) {
			return false;
		}
		return !(Double.valueOf(number) == 0 && number.length() > 1);
	}

	private static boolean checkValidLeftWing(String number) {
		if (number == null || number.isEmpty()) {
			return false;
		}
		return !(number.charAt(0) == '0' && number.length() > 1);
	}

	private static boolean checkValidRightWing(String number) {
		if (number == null || number.isEmpty()) {
			return true;
		}
		int value = Integer.valueOf(number);
		if (value == 0) {
			return false;
		}
		return value % 10 != 0;
	}

	public static void main(String[] args) {
		AmbiguousCoordinates ac = new AmbiguousCoordinates();
		String case1 = "(123)";
		System.out.println(case1);
		System.out.println(ac.ambiguousCoordinates(case1));
		String case2 = "(00011)";
		System.out.println(case2);
		System.out.println(ac.ambiguousCoordinates(case2));
		String case3 = "(0123)";
		System.out.println(case3);
		System.out.println(ac.ambiguousCoordinates(case3));
		String case4 = "(100)";
		System.out.println(case4);
		System.out.println(ac.ambiguousCoordinates(case4));
	}
}