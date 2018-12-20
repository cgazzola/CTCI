package TreesAndGraphs;

public class BinaryTreeNode {

    private int val;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public int getVal() {
        return val;
    }
}
