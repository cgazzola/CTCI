package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MinimalTree extends BinaryTree {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        MinimalTree minimalTree = new MinimalTree();
        BinaryTreeNode root = minimalTree.createMinimalBST(arr);
        minimalTree.createList(root);

    }

    BinaryTreeNode createMinimalBST(int[] arr) {
        return createMinimalBST(arr, 0, arr.length - 1);
    }

    BinaryTreeNode createMinimalBST(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        BinaryTreeNode node = new BinaryTreeNode(arr[mid]);
        node.setLeft(createMinimalBST(arr, start, mid - 1));
        node.setRight(createMinimalBST(arr, mid + 1, end));
        return node;
    }

    public void createList(BinaryTreeNode node) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (node == null) {
            return;
        }
        createList(node.getLeft());
        System.out.println(node.getVal());
        createList(node.getRight());
    }


}
