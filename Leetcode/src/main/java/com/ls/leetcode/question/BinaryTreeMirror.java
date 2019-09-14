package com.ls.leetcode.question;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 二叉树的镜像
 *
 * describe:
 *     完成一个函数，输入一个二叉树，该函数输出它的镜像
 *
 * @author liushuanggo@gmail.com
 * date: 2019-9-14
 */
public class BinaryTreeMirror {

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.value = 8;
        tree.left = new BinaryTree();
        tree.left.value = 6;
        tree.right = new BinaryTree();
        tree.right.value = 10;

        tree.left.left = new BinaryTree();
        tree.left.left.value = 5;
        tree.left.right = new BinaryTree();
        tree.left.right.value = 3;

        tree.right.left = new BinaryTree();
        tree.right.left.value = 4;
        /*tree.right.right = new BinaryTree();
        tree.right.right.value = 9;*/

        printBinaryTreeMirror(tree);

    }

    static void printBinaryTreeMirror(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
        queue.addLast(tree);

        while (queue.size() != 0) {
            BinaryTree node = queue.poll();
            result.add(node.value);

            if (node.right != null) {
                queue.addLast(node.right);
            }

            if (node.left != null) {
                queue.addLast(node.left);
            }
        }

        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    static void printBinaryTreeMirror2(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        System.out.print(tree.value + " ");

        if (tree.left == null && tree.right == null) {
            return;
        }

        BinaryTree tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;

        if (tree.left != null) {
            printBinaryTreeMirror2(tree.left);
        }

        if (tree.right != null) {
            printBinaryTreeMirror2(tree.right);
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    }
}
