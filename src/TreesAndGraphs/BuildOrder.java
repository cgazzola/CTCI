package TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildOrder {

    // Find a correct build order
    Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    /* Build the graph, adding the edge (a, b) if b is dependent on a. Assumes a pair
    is listed in "build order". The pair (a, b) in dependencies indicates that b
    depends on a and a must be built before b.
     */
    Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();
        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    // Return a list of the projects in correct build order.
    Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        // Add "roots" to the build order first.
        int endOfList = addNonDependent(order, projects, 0);
        int toBeProcessed = 0;
        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            /* We have a circular dependency since there are no remaining projects
            with zero dependencies
             */
            if (current == null) {
                return null;
            }

            // Remove myself as a dependency
            ArrayList<Project> children = current.getChildren();
            for (Project child : children) {
                child.decrementDependencies();
            }

            // Add children that have no one depending on them
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;
        }

        return order;
    }

    /* A helper function to insert projects with zero dependencies into the order array,
    starting at index offset */

    int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }
        return offset;
    }


    public static void main(String[] args) {
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = new String[][]{
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"f", "a"},
                {"d", "c"}
        };

        BuildOrder bo = new BuildOrder();
        Project[] buildOrder = bo.findBuildOrder(projects, dependencies);
        for (Project project : buildOrder) {
            System.out.print(project.getName() + " ");
        }
    }


}

class Project {

    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String n) {
        name = n;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies() {
        dependencies++;
    }

    public void decrementDependencies() {
        dependencies--;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public int getNumberDependencies() {
        return dependencies;
    }

}

class Graph {

    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }
        return map.get(name);

    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);
        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }
}
