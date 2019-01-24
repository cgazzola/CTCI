package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public BinaryTreeNode root;

    public void addNode(int val) {
        BinaryTreeNode node = new BinaryTreeNode(val);
        if (root == null) {
            root = node;
            return;
        } else {
            BinaryTreeNode focusNode = root;
            BinaryTreeNode parent;
            while (true) {
                parent = focusNode;
                if (val < focusNode.getVal()) {
                    focusNode = focusNode.getLeft();
                    if (focusNode == null) {
                        parent.setLeft(node);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRight();
                    if (focusNode == null) {
                        parent.setRight(node);
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getVal() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void preOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.getVal() + " ");
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }

    public void postOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.print(node.getVal() + " ");
        }
    }

    public void bfs(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        if (root == null) return;
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.getVal() + " ");
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }

    }


}
