package TreesAndGraphs;

import java.util.HashMap;

public class PathsWithSum {

    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n31 = new BinaryTreeNode(3);
        BinaryTreeNode n32 = new BinaryTreeNode(3);
        BinaryTreeNode n2neg = new BinaryTreeNode(-2);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n3neg = new BinaryTreeNode(-3);
        BinaryTreeNode n11 = new BinaryTreeNode(11);

        root.setLeft(n5);
        n5.setLeft(n31);
        n31.setLeft(n32);
        n31.setRight(n2neg);
        n5.setRight(n2);
        n2.setRight(n1);
        root.setRight(n3neg);
        n3neg.setRight(n11);

        PathsWithSum solution = new PathsWithSum();
        solution.countPathsWithSum2(root, 8);

    }

    /* Brute force solution */
    int countPathsWithSum(BinaryTreeNode root, int targetSum) {
        if (root == null) return 0;

        /* Count paths with sum starting from the root */
        int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        /* Try the nodes on the left and right. */
        int pathsOnLeft = countPathsWithSum(root.getLeft(), targetSum);
        int pathsOnRight = countPathsWithSum(root.getRight(), targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    /* Returns the number of paths with this sum starting from this node */
    int countPathsWithSumFromNode(BinaryTreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum += node.getVal();

        int totalPaths = 0;
        if (currentSum == targetSum) { // Found a path from the root
           totalPaths++;
        }

        totalPaths += countPathsWithSumFromNode(node.getLeft(), targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.getRight(), targetSum, currentSum);
        return totalPaths;
    }

    /* Optimized Solution */
    int countPathsWithSum2(BinaryTreeNode root, int targetSum) {
        if (root == null) return 0;
        HashMap<Integer, Integer> pathCount = new HashMap<>();
        incrementHashTable(pathCount, 0, 1); // Needed if target path starts at root
        return countPathsWithSum(root, targetSum, 0, pathCount);
    }

    int countPathsWithSum(BinaryTreeNode node, int targetSum, int runningSum,
                          HashMap<Integer, Integer> pathCount) {
        if (node == null ) {
            return 0; // Base case
        }

        runningSum += node.getVal();
        incrementHashTable(pathCount, runningSum, 1); // Add runningSum

        /* Count paths with sum ending at the current node */
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.containsKey(sum) ? pathCount.get(sum) : 0;

        /* Count paths with sum on the left and right */
        totalPaths += countPathsWithSum(node.getLeft(), targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.getRight(), targetSum, runningSum, pathCount);

        incrementHashTable(pathCount, runningSum, -1); //Remove runningSum
        return totalPaths;
    }

    void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        if (!hashTable.containsKey(key)) {
            hashTable.put(key, 0);
        }
        hashTable.put(key, hashTable.get(key) + delta);
    }

}
