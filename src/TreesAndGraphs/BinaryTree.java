package TreesAndGraphs;

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

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(50);
        tree.addNode(30);
        tree.addNode(60);
        tree.addNode(52);
        tree.addNode(62);
        tree.addNode(51);
        tree.addNode(54);
        tree.addNode(58);
        tree.inOrderTraversal(tree.root);
    }

}

class BinaryTreeNode {
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
