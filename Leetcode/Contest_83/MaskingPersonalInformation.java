import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

class MaskingPersonalInformation {
	public String maskPII(String S) {
		String masked = maskName(S);
		if (masked == null) {
			masked = maskNumber(S);
		}
		return masked;
	}

	private String maskNumber(String number) {
		number = number.replaceAll("[()]", "");
		number = number.replaceAll(" ", "");
		number = number.replaceAll("\\+", "");
		number = number.replaceAll("-", "");
		String pattern = "[0-9]+";
		if (!number.matches(pattern)) {
			return null;
		}
		return formatNumber(number);
	}

	private String formatNumber(String number) {
		StringBuilder sb = new StringBuilder(number).reverse();
		StringBuilder result = new StringBuilder();
		result.append(sb.substring(0, 4));
		result.append("-");
		result.append(genMaskByLen(3));
		result.append("-");
		result.append(genMaskByLen(3));
		String tail = sb.substring(10);
		if (tail.length() > 0) {
			result.append("-");
			result.append(genMaskByLen(tail.length()));
			result.append("+");
		}
		return result.reverse().toString();
	}

	private String genMaskByLen(int len) {
		char[] chars = new char[len];
		Arrays.fill(chars, '*');
		return new String(chars);
	}

	private String maskName(String name) {
		String pattern = "([a-zA-Z]+)@([a-zA-Z]+)\\.([a-zA-Z]+)";
		if (!name.matches(pattern)) {
			return null;
		}
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(name);
		String name1 = null;
		String name2 = null;
		String name3 = null;
		while (matcher.find()) {
			name1 = matcher.group(1);
			name2 = matcher.group(2);
			name3 = matcher.group(3);
		}
		return maskName1(name1) + "@" + name2.toLowerCase() + "." + name3.toLowerCase();
	}

	private String maskName1(String name1) {
		name1 = name1.toLowerCase();
		StringBuilder sb = new StringBuilder();
		sb.append(name1.charAt(0));
		sb.append("*****");
		sb.append(name1.charAt(name1.length() - 1));
		return sb.toString();
	}

	public static void main(String[] args) {
		MaskingPersonalInformation mpif = new MaskingPersonalInformation();
		System.out.println(mpif.maskPII("AB@qq.com"));
		System.out.println(mpif.maskPII("1(234)567-890"));
		System.out.println(mpif.maskPII("+86(88)1513-7-74"));
	}
}