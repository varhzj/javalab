package com.varhzj.lab.interview.binarytree;

import java.util.LinkedList;

/**
 * Created by varhzj on 12/7/16.
 */
public class TreePrint {

    public static void printByLevel(TreeNode head) {
        if (head == null) {
            return;
        }

        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(head);
        TreeNode current;
        while (!list.isEmpty()) {
            current = list.poll();
            System.out.print(current.val + " ");
            if (current.left != null) {
                list.offer(current.left);
            }
            if (current.right != null) {
                list.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(6);
        TreeNode h = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = g;
        c.right = f;
        d.right = h;
        printByLevel(a);
    }

}
