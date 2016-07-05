package com.varhzj.lab.leetcode;

/*
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

public class AddTwoNums {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int one = 0;
		int sum = 0;
		ListNode root = new ListNode(-1);
		ListNode node = new ListNode(-1);
		while (l1 != null || l2 != null) {
			sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + one;
			one = sum / 10;
			sum = sum % 10;
			if (root.next == null) {
				node = new ListNode(sum);
				root.next = node;
			} else {
				node.next = new ListNode(sum);
				node = node.next;
			}
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		if (one == 1)
			node.next = new ListNode(one);

		return root.next;
	}

	public static void main(String[] args) {
		// ListNode l1 = new ListNode(1);
		// l1.next = new ListNode(4);
		// l1.next.next = new ListNode(4);
		// ListNode l2 = new ListNode(9);
		// l2.next = new ListNode(4);
		// l2.next.next = new ListNode(4);
		// AddTwoNums a = new AddTwoNums();
		// ListNode l3 = a.addTwoNumbers(l1, l2);
		// while (l3 != null) {
		// System.out.println(l3.val);
		// l3 = l3.next;
		// }
		String s1 = new StringBuilder("go").append("lang").toString();
		System.out.println( s1 == s1.intern());
		String s2 = new StringBuilder("ja").append("va").toString();
		System.out.println( s2 == s2.intern());
		String s3 = new String(new char[]{'a', 'b', 'c'});
		System.out.println(s3.intern() == s3);
//		String s4 = "abcd" + s3;
//		System.out.println(s4 == s4.intern());
	}

}
