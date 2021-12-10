package com.saranshbhalla.leetcode.medium;

public class ValidateBinarySearchTree_98 {
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

    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        int val = root.val;
        if ((max==null || val < max) && (min==null || val > min)){
            Integer lMax = max == null ? val : Math.min(max, val);
            Integer rMin = min == null ? val : Math.max(min, val);
            return isValidBST(root.left, min, lMax) &&
                    isValidBST(root.right, rMin, max);
        }
        else
            return false;

    }

}
