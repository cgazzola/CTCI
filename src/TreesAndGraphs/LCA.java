package TreesAndGraphs;

public class LCA {

    public static void main(String[] args) {
//        BinaryTreeNode root = new BinaryTreeNode(3);
//        BinaryTreeNode n6 = new BinaryTreeNode(6);
//        n6.setParent(root);
//        root.setLeft(n6);
//        BinaryTreeNode n2 = new BinaryTreeNode(2);
//        n2.setParent(n6);
//        n6.setLeft(n2);
//        BinaryTreeNode n11 = new BinaryTreeNode(11);
//        n6.setRight(n11);
//        n11.setParent(n6);
//        BinaryTreeNode n9 = new BinaryTreeNode(9);
//        n11.setLeft(n9);
//        n9.setParent(n11);
//        BinaryTreeNode n5 = new BinaryTreeNode(5);
//        n11.setRight(n5);
//        n5.setParent(n11);
//        BinaryTreeNode n8 = new BinaryTreeNode(8);
//        root.setRight(n8);
//        n8.setParent(root);
//        BinaryTreeNode n13 = new BinaryTreeNode(13);
//        n8.setRight(n13);
//        n13.setParent(n8);
//        BinaryTreeNode n7 = new BinaryTreeNode(7);
//        n13.setLeft(n7);
//        n7.setParent(n13);

        BinaryTreeNode root = new BinaryTreeNode(20);
        BinaryTreeNode n10 = new BinaryTreeNode(10);
        root.setLeft(n10);
        n10.setParent(root);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        n10.setLeft(n5);
        n5.setParent(n10);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        n5.setLeft(n3);
        n3.setParent(n5);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        n7.setParent(n5);
        n5.setRight(n7);
        BinaryTreeNode n15 = new BinaryTreeNode(15);
        n10.setRight(n15);
        n15.setParent(n10);
        BinaryTreeNode n17 = new BinaryTreeNode(17);
        n15.setRight(n17);
        n17.setParent(n15);
        BinaryTreeNode n30 = new BinaryTreeNode(30);
        root.setRight(n30);
        n30.setParent(root);

        LCA lca = new LCA();
        System.out.println(lca.commonAncestor2(root, n7, n17).getVal());

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

    BinaryTreeNode commonAncestor2(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        /* Check if either node is not in the tree, or if one covers the other. */
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }

        /* Traverse upwards until you find a node that covers q. */
        BinaryTreeNode sibling = getSibling(p);
        BinaryTreeNode parent = p.getParent();
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.getParent();
        }
        return parent;
    }

    boolean covers(BinaryTreeNode root, BinaryTreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.getLeft(), p) || covers(root.getRight(), p);
    }

    BinaryTreeNode getSibling(BinaryTreeNode node) {
        if (node == null || node.getParent() == null) {
            return null;
        }
        BinaryTreeNode parent = node.getParent();
        return parent.getLeft() == node ? parent.getRight() : parent.getLeft();
    }


}

