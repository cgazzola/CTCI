package TreesAndGraphs;

import java.util.Random;

public class RandomNode {

    public static void main(String[] args) {
        AlternateTreeNode root = new AlternateTreeNode(20);
        root.insertInOrder(10);
        root.insertInOrder(30);
        root.insertInOrder(5);
        root.insertInOrder(15);
        root.insertInOrder(3);
        root.insertInOrder(7);
        root.insertInOrder(17);

        System.out.println(root.getRandomNode().data());
        System.out.println(root.getRandomNode().data());
        System.out.println(root.getRandomNode().data());
        System.out.println(root.getRandomNode().data());
        System.out.println(root.getRandomNode().data());
        System.out.println(root.getRandomNode().data());
        System.out.println(root.getRandomNode().data());

}
}
