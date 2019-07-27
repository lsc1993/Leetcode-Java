package com.ls.leetcode.question;

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

        binaryTree = createTree(foreForech, middleForech, binaryTree);

        BinaryTree fore = binaryTree;
        preOrderTraversal(fore);

        BinaryTree middle = binaryTree;
        inOrderTraversal(middle);

        postOrderTraversal(binaryTree);

        levelTraversal(binaryTree);
    }

    private static BinaryTree createTree(int[] fore, int[] middle, BinaryTree binaryTree) {
        if (fore.length == 0) {
            return null;
        }

        if (fore.length == 1) {
            binaryTree.value = fore[0];
            binaryTree.left = null;
            binaryTree.right = null;
            return binaryTree;
        }

        binaryTree.value = fore[0];
        int rootIndex = 0;
        for (int i = 0; i < fore.length; ++ i) {
            if (fore[0] == middle[i]) {
                rootIndex = i;
            }
        }

        //获取左子节点前序遍历和中序遍历
        int[] subMiddleLeft = new int[rootIndex];
        int[] subForeLeft = new int[rootIndex];
        for (int i = 0;i < rootIndex; ++i) {
            subMiddleLeft[i] = middle[i];
            subForeLeft[i] = fore[i + 1];
        }

        binaryTree.left = createTree(subForeLeft, subMiddleLeft, new BinaryTree());

        //获取右子节点前序遍历和中序遍历
        int rLen = middle.length - rootIndex - 1;
        int[] subMiddleRight = new int[rLen];
        int[] subForeRight = new int[rLen];
        for (int i = 0; i < rLen; ++i) {
            subMiddleRight[i] = middle[rootIndex + i + 1];
            subForeRight[i] = fore[rootIndex + i + 1];
        }

        binaryTree.right = createTree(subForeRight, subMiddleRight, new BinaryTree());


        return binaryTree;
    }

    static class BinaryTree {
        int value;

        BinaryTree left;
        BinaryTree right;
    }

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
            if (node.right != null) {
                stack.push(node.right);
            }
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

    static List<Integer> inOrderTraversal(BinaryTree tree) {
        List<Integer> result = new ArrayList<Integer>();

        if (tree == null) {
            return result;
        }

        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        BinaryTree node = tree;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                result.add(node.value);
                node = node.right;
            }
        }

        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();

        return result;
    }

    static List<Integer> postOrderTraversal(BinaryTree tree) {
        List<Integer> result = new ArrayList<Integer>();

        if (tree == null) {
            return result;
        }

        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        BinaryTree node = tree;
        BinaryTree last = null;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                BinaryTree peek = stack.peek();
                if (peek.right != null && last != peek.right) {
                    node = peek.right;
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
