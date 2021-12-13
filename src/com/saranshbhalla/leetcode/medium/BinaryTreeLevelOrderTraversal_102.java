package com.saranshbhalla.leetcode.medium;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allRows = new ArrayList<>();
        if (root == null)
            return allRows;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> currentRow = new ArrayList<>();
            int nodes = q.size();
            for (int i = 0; i < nodes; i++) {
                TreeNode node = q.poll();
                currentRow.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            allRows.add(currentRow);
        }
        return allRows;
    }
}
