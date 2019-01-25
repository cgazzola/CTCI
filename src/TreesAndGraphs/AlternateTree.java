package TreesAndGraphs;

import java.util.Random;

public class AlternateTree {

    AlternateTreeNode root = null;

    public int size() { return root == null ? 0 : root.size(); }

    public AlternateTreeNode getRandomNumber() {
        if (root == null) return null;

        Random random = new Random();
        int i = random.nextInt(size());
        return root.getIthNode(i);
    }

    public void insertInOrder(int value) {
        if (root == null) {
            root = new AlternateTreeNode(value);
        } else {
            root.insertInOrder(value);
        }
    }

}
