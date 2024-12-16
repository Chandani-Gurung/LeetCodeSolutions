package org.leetcode;

/*
* Given a binary tree, determine if it is height-balanced
*/
public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        BalancedBinaryTree solution = new BalancedBinaryTree();
        boolean isBalancedTree = solution.isBalanced(root);

        if (isBalancedTree) {
            System.out.println("The binary tree is balanced.");
        } else {
            System.out.println("The binary tree is not balanced.");
        }
    }
    private int checkHeight(TreeNode root) {

        if (root == null) return 0; //base case

        int leftHeight = checkHeight(root.left); //check if left subtree is unbalanced
        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(root.right); //check if right subtree is unbalanced
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1; //check balance between current nodes

        return Math.max(leftHeight, rightHeight) + 1; //height of the current subtree
    }

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
}
