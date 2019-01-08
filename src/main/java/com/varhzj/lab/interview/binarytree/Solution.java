package com.varhzj.lab.interview.binarytree;

import java.util.*;

/**
 * Created by varhzj on 12/14/16.
 */
public class Solution {

    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    private TreeNode flatten(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }

        root.right = flatten(root.left, flatten(root.right, tail));
        root.left = null;
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        return balancedHeight(root) >= 0;
    }

    private int balancedHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = balancedHeight(root.left);
        int right = balancedHeight(root.right);

        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfsPathSum(root);
        return maxSum;
    }

    private int dfsPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfsPathSum(root.left);
        int r = dfsPathSum(root.right);
        int sum = root.val;
        if (l > 0) {
            sum += l;
        }
        if (r > 0) {
            sum += r;
        }
        maxSum = Math.max(sum, maxSum);

        int sonMax = Math.max(l, r);
        return sonMax > 0 ? root.val + sonMax : root.val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left == null ? right : left;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        pathSum(root, sum, cur, res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        cur.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(cur));
        }

        pathSum(root.left, sum - root.val, cur, res);
        pathSum(root.right, sum - root.val, cur, res);

        cur.remove(cur.size() - 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        } else if (root.right == null) {
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }

    // Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // Find the sum of all left leaves in a given binary tree.
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    // Given two binary trees, write a function to check if they are equal or not.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }

    // Given a binary tree, return the preorder traversal of its nodes' values.
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }

    // Given a binary tree, return the inorder traversal of its nodes' values.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
        return res;
    }

    // Given a binary tree, return the level order traversal of its nodes' values.
    // (ie, from left to right, level by level).
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> cur = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        if (root != null) {
            cur.offer(root);
        }

        while (!cur.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            while (!cur.isEmpty()) {
                TreeNode node = cur.poll();
                list.add(node.val);
                if (node.left != null) {
                    next.offer(node.left);
                }
                if (node.right != null) {
                    next.offer(node.right);
                }
            }
            res.add(list);
            // swap
            Queue tmp = cur;
            cur = next;
            next = tmp;
        }

        return res;
    }

    // Given a binary tree, return the bottom-up level order traversal of its nodes' values.
    // (ie, from left to right, level by level from leaf to root).
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<Integer>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.addFirst(list);
        }

        return res;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.addLast(list);
            leftToRight = !leftToRight;
        }

        return res;
    }

    // Invert a binary tree.
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}
