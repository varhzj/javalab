package com.varhzj.lab.interview.binarytree;

import java.util.Stack;

/**
 * Created by varhzj on 16-8-13.
 */
public class TreeTraversal {

    public static void preOrderRecur(TreeNode head) {
        if (head == null)
            return;

        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(TreeNode head) {
        if (head == null)
            return;

        inOrderRecur(head.left);
        System.out.println(head.val + " ");
        inOrderRecur(head.right);
    }

    public static void posOrderRecur(TreeNode head) {
        if (head == null)
            return;

        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.printf(head.val + " ");
    }

    public static void preOrderUnRecur(TreeNode head) {
        if (head == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.printf(head.val + " ");
            if (head.right != null)
                stack.push(head.right);
            if (head.left != null)
                stack.push(head.left);
        }
    }

    public static void inOrderUnRecur(TreeNode head) {
        if (head == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.printf(head.val + " ");
                head = head.right;
            }
        }
    }

    public static void posOrderUnRecur(TreeNode head) {
        if (head == null)
            return;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null)
                s1.push(head.left);
            if (head.right != null)
                s1.push(head.right);
        }
        while (!s2.isEmpty()) {
            System.out.printf(s2.pop().val + " ");
        }
    }

}
