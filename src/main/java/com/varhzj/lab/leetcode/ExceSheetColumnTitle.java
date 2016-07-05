package com.varhzj.lab.leetcode;

public class ExceSheetColumnTitle {

	public static String convertToTitle(int n) {
		char[] arr = "ZABCDEFGHIJKLMNOPQRSTUVWXY".toCharArray();
		String s = "";
		while (n != 0) {
			s = arr[n % 26] + s;
			if (n % 26 == 0)
				n -= 26;
			n /= 26;
		}
		return s;
	}

	public String convertToTitle2(int n) {
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			sb.insert(0, (char) ('A' + --n % 26));
			n /= 26;
		}
		return sb.toString();
	}

	public static int titleToNumber(String s) {
		char[] arr = s.toCharArray();
		int len = arr.length;
		int result = 0;

		for (int i = len - 1; i > -1; i--) {
			int cur = arr[i] - 'A' + 1;
			for (int j = len - 1; j > i; j--)
				cur *= 26;
			result += cur;
		}

		return result;

	}

	public static int titleToNumber2(String s) {
		int result = 0, len = s.length();
		for (int i = 0; i < len; i++) {
			result *= 26;
			result += (s.charAt(i) - 'A' + 1);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(titleToNumber2(convertToTitle(1111111)));
	}

}
