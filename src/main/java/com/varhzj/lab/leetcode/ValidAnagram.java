package com.varhzj.lab.leetcode;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if (s == null && t == null)
			return true;

		if (s != null && t != null && s.length() == t.length()) {
			int[] arr = new int[26];
			char[] sa = s.toCharArray();
			for (char sc : sa)
				arr[sc - 'a'] += 1;
			char[] ta = t.toCharArray();
			for (char tc : ta)
				if ((arr[tc - 'a'] -= 1) < 0)
					return false;
			for (int i : arr)
				if (i != 0)
					return false;
			return true;
		}

		return false;
	}

}
