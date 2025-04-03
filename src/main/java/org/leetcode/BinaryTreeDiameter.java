package org.leetcode;

public class BinaryTreeDiameter {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lHeight = height(node.left);
        int rHeight = height(node.right);

        diameter = Math.max(diameter, lHeight + rHeight);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeDiameter binaryTreeDiameter = new BinaryTreeDiameter();

        // Creating the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = binaryTreeDiameter.diameterOfBinaryTree(root);

        System.out.println("The diameter of the binary tree is: " + result);
    }
}
