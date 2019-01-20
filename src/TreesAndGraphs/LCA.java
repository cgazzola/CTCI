package TreesAndGraphs;

public class LCA {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        n6.setParent(root);
        root.setLeft(n6);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        n2.setParent(n6);
        n6.setLeft(n2);
        BinaryTreeNode n11 = new BinaryTreeNode(11);
        n6.setRight(n11);
        n11.setParent(n6);
        BinaryTreeNode n9 = new BinaryTreeNode(9);
        n11.setLeft(n9);
        n9.setParent(n11);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        n11.setRight(n5);
        n5.setParent(n11);
        BinaryTreeNode n8 = new BinaryTreeNode(8);
        root.setRight(n8);
        n8.setParent(root);
        BinaryTreeNode n13 = new BinaryTreeNode(13);
        n8.setRight(n13);
        n13.setParent(n8);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        n13.setLeft(n7);
        n7.setParent(n13);

        LCA lca = new LCA();
        System.out.println(lca.commonAncestor(n8, n7).getVal());

    }

    BinaryTreeNode commonAncestor(BinaryTreeNode p, BinaryTreeNode q) {
        if (p == q) return null;

        BinaryTreeNode ancestor = p;
        while (ancestor != null) {
            if (isOnPath(ancestor, q)) {
                return ancestor;
            }
            ancestor = ancestor.getParent();
        }
        return null;
    }

    boolean isOnPath(BinaryTreeNode ancestor, BinaryTreeNode node) {
        while (node != ancestor && node != null) {
            node = node.getParent();
        }

        return node == ancestor;
    }
}

