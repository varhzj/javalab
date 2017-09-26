package com.varhzj.lab.interview.linkedlist;

/**
 * Created by varhzj on 12/13/16.
 */
public class Solution {

    // Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int num = carry;

            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                num += l2.val;
                l2 = l2.next;
            }

            carry = num / 10;
            cur.next = new ListNode(num % 10);
            cur = cur.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }

    // Given a linked list, determine if it has a cycle in it.
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }

    // Given a singly linked list, group all odd nodes together followed by the even nodes.
    // Please note here we are talking about the node number and not the value in the nodes.
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            if (i % 2 != 0) {
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }
            // 注意GC
            ListNode tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }

        odd.next = evenDummy.next;
        return oddDummy.next;
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

    // 合并两个有序链表
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        // 反转链表
        slow = reverseList(slow);

        // 合并列表
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = slow;
            slow = slow.next;
            if (tmp != null) {
                cur.next.next = tmp;
            }
            cur = tmp;
        }
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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        if (fast != null) {
            slow = slow.next;
        }

        slow = reverseList(slow);
        ListNode cur = head;
        while (cur != null && slow != null) {
            if (cur.val != slow.val) {
                return false;
            }
            cur = cur.next;
            slow = slow.next;
        }

        if (cur == null && slow == null) {
            return true;
        }

        return false;
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

    // same as prev one
    public ListNode removeElementsI(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }

        return dummy.next;
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

    public ListNode kThToLast(ListNode head, int k) {
        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k - 1; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        if (p1 == null) {
            return null;
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    // Given a linked list, remove the nth node from the end of list and return its head.
    public ListNode removeNthFromEndII(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        ListNode node = slow.next;
        slow.next = node.next;
        node.next = null; // help GC

        return dummy.next;
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

    // Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode next;
        ListNode pre;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null && cur.val == next.val) {
                pre = next;
                next = next.next;
            }

            if (pre != cur) {
                pre.next = null; // help gc
            }
            cur.next = next;
            cur = cur.next;
        }

        return head;
    }

    // Write a program to find the node at which the intersection of two singly linked lists begins.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        int sizeA = 0;
        while (curA != null) {
            sizeA++;
            curA = curA.next;
        }

        ListNode curB = headB;
        int sizeB = 0;
        while(curB != null) {
            sizeB++;
            curB = curB.next;
        }

        if (curA != curB) {
            return null;
        }

        curA = headA;
        curB = headB;
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                curA = curA.next;
            }
        }

        if (sizeB > sizeA) {
            for (int i = 0; i < sizeB - sizeA; i++) {
                curB = curB.next;
            }
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
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
        solution.reorderList(head);
        printList(head);
//        ListNode newHead = solution.reverseBetween(head, 2, 4);
//        printList(newHead);
    }

    static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }

}
