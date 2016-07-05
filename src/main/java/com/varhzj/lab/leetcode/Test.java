package com.varhzj.lab.leetcode;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		for (int i : list) {
			System.out.println("========" + i + "========");
			for (int j : list) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
