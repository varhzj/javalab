package com.varhzj.lab.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class LongestSubStringNRC {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int len = s.length();
		int max = 0;
		int start = 0;
		int end = 0;
		Map<Character, Integer> map = new HashMap<>();
		char[] arr = s.toCharArray();
		while (end < len) {
			if (map.containsKey(arr[end])) {
				max = Math.max(max, end - start);
				start = Math.max(start, map.get(arr[end]) + 1);
			}
			map.put(arr[end], end);
			end++;
		}

		return Math.max(max, end - start);
	}

	public int lengthOfLongestSubString(String s) {
		if (s == null)
			return 0;

		boolean[] flag = new boolean[256];
		int max = 0;
		int start = 0;
		char[] array = s.toCharArray();

		for (int i = 0; i < array.length; i++) {
			char cur = array[i];
			if (flag[cur]) {
				max = Math.max(max, i - start);
				for (int k = start; k < i; k++) {
					if (array[k] == cur) {
						start = k + 1;
						break;
					}
					flag[array[k]] = false;
				}
			} else {
				flag[cur] = true;
			}

		}
		return Math.max(max, array.length - start);
	}

	public static void main(String[] args) {
		LongestSubStringNRC l = new LongestSubStringNRC();
		String s = "bbabcddfcdabfef";
		System.out.println(l.lengthOfLongestSubstring(s));
	}

}
