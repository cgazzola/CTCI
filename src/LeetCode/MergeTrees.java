package LeetCode;
import TreesAndGraphs.BinaryTree;
import TreesAndGraphs.BinaryTreeNode;

public class MergeTrees {

    public static void main(String[] args) {

        // Construction of tree 1
        BinaryTreeNode t1 = new BinaryTreeNode(1);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n5 = new BinaryTreeNode(3);
        BinaryTreeNode n2 = new BinaryTreeNode(2);

        t1.setLeft(n3);
        t1.setRight(n2);
        n3.setLeft(n5);

        // Construction of tree 2
        BinaryTreeNode t2 = new BinaryTreeNode(2);
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n33 = new BinaryTreeNode(3);
        BinaryTreeNode n7 = new BinaryTreeNode(7);

        t2.setLeft(n1);
        t2.setRight(n33);
        n1.setRight(n4);
        n33.setRight(n7);

        BinaryTreeNode t3 = mergeTrees(t1, t2);
    }

    private static BinaryTreeNode mergeTrees(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1;
        }

        t1.setVal(t1.getVal() + t2.getVal());
        BinaryTreeNode node = mergeTrees(t1.getLeft(), t2.getLeft());
        if (node == t1.getLeft()) {
            node = mergeTrees(t1.getRight(), t2.getRight());
            if (node == null) {
                t1.setRight(t2.getRight());
            }
        } else {
            if (t2.getLeft() != null) {
                t1.setLeft(t2.getLeft());
                mergeTrees(t1.getRight(), t2.getRight());
            }
        }

        return t1;

    }
}
