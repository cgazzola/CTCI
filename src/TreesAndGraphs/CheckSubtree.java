package TreesAndGraphs;

public class CheckSubtree {

    public static void main(String[] args) {
        /* Big Tree */
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n9 = new BinaryTreeNode(9);
        BinaryTreeNode n15 = new BinaryTreeNode(15);
        BinaryTreeNode n17 = new BinaryTreeNode(17);
        BinaryTreeNode n14 = new BinaryTreeNode(14);
        BinaryTreeNode n22 = new BinaryTreeNode(22);
        BinaryTreeNode n20 = new BinaryTreeNode(20);
        BinaryTreeNode n25 = new BinaryTreeNode(25);

        root.setLeft(n4);
        root.setRight(n14);
        n4.setLeft(n3);
        n4.setRight(n9);
        n3.setLeft(n6);
        n3.setRight(n7);
        n9.setLeft(n15);
        n9.setRight(n17);
        n14.setLeft(n22);
        n14.setRight(n20);
        n20.setRight(n25);

        BinaryTree bigTree = new BinaryTree();
        bigTree.root = root;

        /* Subtree starting at 4 */
        BinaryTree subTree4 = new BinaryTree();
        subTree4.root = n4;

        /* Subtree starting at 9 */
        BinaryTree subTree9 = new BinaryTree();
        subTree9.root = n9;

        /* Subtree starting at 14 */
        BinaryTree subTree14 = new BinaryTree();
        subTree14.root = n14;

        /* Subtree starting at 22 */
        BinaryTree subTree22 = new BinaryTree();
        subTree22.root = n22;

        /* Subtree starting at 20 */
        BinaryTree subTree20 = new BinaryTree();
        subTree20.root = n20;

        /* Subtree which does not exist */
        BinaryTree subTreeDNE = new BinaryTree();
        BinaryTreeNode root14 = new BinaryTreeNode(14);
        BinaryTreeNode copy22 = new BinaryTreeNode(22);
        BinaryTreeNode copy20 = new BinaryTreeNode(20);
        BinaryTreeNode copy25 = new BinaryTreeNode(25);
        BinaryTreeNode copy29 = new BinaryTreeNode(29);

        root14.setLeft(copy22);
        root14.setRight(copy20);
        copy22.setLeft(copy29);
        copy20.setRight(copy25);
        subTreeDNE.root = root14;

        CheckSubtree cst = new CheckSubtree();
        System.out.println(cst.containsTree(bigTree.root, subTree4.root));
        System.out.println(cst.containsTree(bigTree.root, subTree9.root));
        System.out.println(cst.containsTree(bigTree.root, subTree14.root));
        System.out.println(cst.containsTree(bigTree.root, subTree22.root));
        System.out.println(cst.containsTree(bigTree.root, subTree20.root));
        System.out.println(cst.containsTree(bigTree.root, subTreeDNE.root));

    }

    boolean containsTree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t2 == null) { // The empty tree is always a subtree
            return true;
        }
        return subTree(t1, t2);
    }

    boolean subTree(BinaryTreeNode r1, BinaryTreeNode r2) {
        if (r1 == null) {
            return false; // big tree empty and subtree still not found.
        } else if (r1.getVal() == r2.getVal() && matchTree(r1, r2)) {
            return true;
        }
        return (subTree(r1.getLeft(), r2)) || subTree(r1.getRight(), r2);
    }

    boolean matchTree(BinaryTreeNode r1, BinaryTreeNode r2) {
        if (r2 == null && r1 == null) {
            return true; // nothing left in subtree
        } else if (r1 == null || r2 == null) {
            return false; // big tree empty and subtree still not found
        } else {
            return (matchTree(r1.getLeft(), r2.getLeft()) && matchTree(r1.getRight(), r2.getRight()));
        }
    }

}
