package com.varhzj.lab.interview.linkedlist;

/**
 * Created by varhzj on 12/13/16.
 */
public class Solution {

    // Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = l1;

        return l3;
    }

    // Sort a linked list in O(n log n) time using constant space complexity.
    // 归并排序实现
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return mergeTwoLists(sortList(head), sortList(slow));
    }

    // 合并连个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        return dummy.next;
    }

    // Reverse Linked List
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode pre = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // Remove Linked List Elements:
    // Remove all elements from a linked list of integers that have value val.
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }

        ListNode curr = head.next;
        ListNode pre = head;
        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    // Rotate List:
    // Given a list, rotate the list to the right by k places, where k is non-negative.
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 遍历链表，并获取链表长度
        ListNode fast = head;
        int length = 0;
        while (fast != null) {
            length++;
            fast = fast.next;
        }

        int rotate = k % length;
        fast = head;
        // fast节点先前进rotate步
        while (rotate > 0) {
            fast = fast.next;
            rotate--;
        }

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 旋转
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

    // Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if (pre == null) {
            head = head.next;
        } else {
            pre.next = slow.next;
        }
        return head;
    }

    public ListNode removeNthFromEndII(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = dummy;
        for (int i = 0; i < m; i++) {
            pre = start;
            start = start.next;
        }
        ListNode tmp;
        for (int i = 0; i < n - m; i++) {
            tmp = start.next;
            start.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode newHead = solution.reverseBetween(head, 2, 4);
        printList(newHead);
    }

    static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

}
