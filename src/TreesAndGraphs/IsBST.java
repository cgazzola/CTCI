package TreesAndGraphs;

public class IsBST {

    public boolean checkBST(BinaryTreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean checkBST(BinaryTreeNode node, int min, int max) {
        if (node == null) return true;
        if (node.getVal() <= min || node.getVal() >= max) return false;
        return checkBST(node.getLeft(), min, node.getVal()) && checkBST(node.getRight(), node.getVal(), max);
    }
}
