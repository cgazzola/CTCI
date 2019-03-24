package TreesAndGraphs;

public class TopView {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);

        root.setRight(n2);
        n2.setRight(n5);
        n5.setLeft(n3);
        n3.setRight(n4);
        n5.setRight(n6);

        topView(root);
    }

    public static void topView(BinaryTreeNode root) {
        if (root == null) return;
        left(root.getLeft());
        System.out.println(root.getVal());
        right(root.getRight());
        return;
    }

    private static void left(BinaryTreeNode n) {
        if (n == null) return;
        left(n.getLeft());
        System.out.println(n.getVal());
        return;
    }

    private static void right(BinaryTreeNode n) {
        if (n == null) return;
        System.out.println(n.getVal());
        right(n.getRight());
        return;
    }
}
