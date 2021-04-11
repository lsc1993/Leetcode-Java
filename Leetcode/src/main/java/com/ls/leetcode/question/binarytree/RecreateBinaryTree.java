package com.ls.leetcode.question.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 重建二叉树以及二叉树的循环遍历方法
 *
 * describe:
 * 根据一个二叉树的前序遍历和中序遍历重建二叉树
 */
public class RecreateBinaryTree {

    private static int index = 0;

    public static void main(String[] args) {
        int[] foreForech = {1, 2, 4, 7, 3, 5, 6, 8}; //前序遍历
        int[] middleForech = {4, 7, 2, 1, 5, 3, 8, 6}; //中序遍历

        BinaryTree binaryTree = new BinaryTree();

        //binaryTree = buildTree(foreForech, middleForech, binaryTree);

        BinaryTree fore = binaryTree;
        preOrderTraversal(fore);

        BinaryTree middle = binaryTree;
        inOrderTraversal(middle);

        postOrderTraversal(binaryTree);

        levelTraversal(binaryTree);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode binaryTree = new TreeNode();
        if (preorder.length == 1) {
            binaryTree.val = preorder[0];
            binaryTree.left = null;
            binaryTree.right = null;
            return binaryTree;
        }

        binaryTree.val = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i < preorder.length; ++ i) {
            if (preorder[0] == inorder[i]) {
                rootIndex = i;
            }
        }

        //获取左子节点前序遍历和中序遍历
        int[] subMiddleLeft = new int[rootIndex];
        int[] subForeLeft = new int[rootIndex];
        for (int i = 0;i < rootIndex; ++i) {
            subMiddleLeft[i] = inorder[i];
            subForeLeft[i] = preorder[i + 1];
        }

        binaryTree.left = buildTree(subForeLeft, subMiddleLeft);

        //获取右子节点前序遍历和中序遍历
        int rLen = inorder.length - rootIndex - 1;
        int[] subMiddleRight = new int[rLen];
        int[] subForeRight = new int[rLen];
        for (int i = 0; i < rLen; ++i) {
            subMiddleRight[i] = inorder[rootIndex + i + 1];
            subForeRight[i] = preorder[rootIndex + i + 1];
        }

        binaryTree.right = buildTree(subForeRight, subMiddleRight);


        return binaryTree;
    }

    static class BinaryTree {
        int value;

        BinaryTree left;
        BinaryTree right;
    }

    /**
     * 前序遍历 循环方式
     */
    static List<Integer> preOrderTraversal(BinaryTree tree) {
        List<Integer> result = new ArrayList<Integer>();

        if (tree == null) {
            return result;
        }

        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            BinaryTree node = stack.pop();
            result.add(node.value);
            //先存储右子节点
            if (node.right != null) {
                stack.push(node.right);
            }
            //存储左子节点,然后取出左子节点
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();

        return result;
    }

    /**
     * 中序遍历  循环方式
     */
    static List<Integer> inOrderTraversal(BinaryTree tree) {
        List<Integer> result = new ArrayList<Integer>();

        if (tree == null) {
            return result;
        }

        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        BinaryTree node = tree;
        while (node != null || !stack.isEmpty()) {
            //先存储节点,直到左子节点为null
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                //取出的节点是最底层的左子节点
                node = stack.pop();
                result.add(node.value);
                node = node.right; //加入右子节点
            }
        }

        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();

        return result;
    }

    /**
     * 后序遍历 循环方式
     */
    static List<Integer> postOrderTraversal(BinaryTree tree) {
        List<Integer> result = new ArrayList<Integer>();

        if (tree == null) {
            return result;
        }

        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        BinaryTree node = tree;
        BinaryTree last = null; //用来判断右子节点是否已经取出

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                //将左子节点加入到栈中
                stack.push(node);
                node = node.left;
            } else {
                BinaryTree peek = stack.peek();
                if (peek.right != null && last != peek.right) {
                    node = peek.right; //这里判断右子节点是否存在,然后加入到栈中
                } else {
                    peek = stack.pop();
                    result.add(peek.value);
                    last = peek;
                }
            }
        }

        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();

        return result;
    }

    /**
     * 层级遍历
     */
    static List<Integer> levelTraversal(BinaryTree tree) {
        List<Integer> result = new ArrayList<Integer>();

        if (tree == null) {
            return result;
        }

        LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.addLast(tree);

        while (queue.size() != 0) {
            BinaryTree node = queue.poll();
            result.add(node.value);
            if (node.left != null) {
                queue.addLast(node.left);
            }

            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();

        return result;
    }
}
