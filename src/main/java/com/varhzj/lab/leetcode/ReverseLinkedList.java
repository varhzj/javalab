package com.varhzj.lab.leetcode;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode prev = null;
		ListNode cur = head;
		ListNode next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		// TODO:
		return head;
	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return head;
		ListNode odd = head;
		ListNode even = head.next;
		while (odd.next != null && even.next != null && odd.next.next != null) {
			odd.next = even.next;
			even.next = odd.next.next;
			odd.next.next = even;
			odd = even;
			even = even.next;
		}
		return head;
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode iNode = head;
		ListNode jNode = head.next;
		while (jNode != null) {
			if (jNode.val == iNode.val)
				jNode = jNode.next;
			else {
				iNode.next = jNode;
				iNode = jNode;
			}
		}
		iNode.next = null;
		return head;
	}

	public static void main(String[] args) {
		int n = -11111;
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				count++;
			n >>>= 1;
		}
		System.out.println(Integer.bitCount(-11111));
		System.out.println(Integer.toBinaryString(-11111));
		System.out.println(count);
	}

}
