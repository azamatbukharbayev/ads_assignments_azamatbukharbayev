import java.util.*;

public class Task2_SearchTraversal {
    private Map<String, List<String[]>> adjacencyList;

    public Task2_SearchTraversal() {
        adjacencyList = new LinkedHashMap<>();
    }

    public void add_vertex(String v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }
    }

    public void add_edge(String u, String v, int weight) {
        if (!adjacencyList.containsKey(u)) adjacencyList.put(u, new ArrayList<>());
        if (!adjacencyList.containsKey(v)) adjacencyList.put(v, new ArrayList<>());
        adjacencyList.get(u).add(new String[]{v, String.valueOf(weight)});
        adjacencyList.get(v).add(new String[]{u, String.valueOf(weight)});
    }


    public void dfs(String startNode) {
        System.out.println("========================================");
        System.out.println("  DFS (Depth-First Search) from " + startNode);
        System.out.println("========================================");

        Set<String> visited = new LinkedHashSet<>();

        System.out.println("Starting DFS from node " + startNode + "...\n");

        dfsRecursive(startNode, visited, 0);

        System.out.println("\nDFS Traversal Order: " + String.join(" → ", visited));
        System.out.println("========================================\n");
    }


    private void dfsRecursive(String node, Set<String> visited, int depth) {
        String indent = "  ".repeat(depth);

        visited.add(node);
        System.out.println(indent + "Visit " + node + " (mark as visited)");

        List<String[]> neighbors = adjacencyList.get(node);

        for (String[] neighbor : neighbors) {
            String neighborName = neighbor[0];

            if (!visited.contains(neighborName)) {
                System.out.println(indent + "  " + node + " → going deeper to " + neighborName);
                dfsRecursive(neighborName, visited, depth + 1);
                System.out.println(indent + "  Backtracked to " + node);
            } else {
                System.out.println(indent + "  " + neighborName + " already visited, skip");
            }
        }
    }


    public void bfs(String startNode) {
        System.out.println("========================================");
        System.out.println("  BFS (Breadth-First Search) from " + startNode);
        System.out.println("========================================");

        Set<String> visited = new LinkedHashSet<>();

        Queue<String> queue = new LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);
        System.out.println("Enqueue " + startNode + " (starting node)");
        System.out.println("Mark " + startNode + " as visited\n");

        List<String> traversalOrder = new ArrayList<>();
        int step = 1;

        while (!queue.isEmpty()) {
            System.out.println("Step " + step + ": Queue = " + queue);

            String current = queue.poll();
            traversalOrder.add(current);
            System.out.println("  Dequeue and visit: " + current);

            List<String[]> neighbors = adjacencyList.get(current);

            for (String[] neighbor : neighbors) {
                String neighborName = neighbor[0];

                if (!visited.contains(neighborName)) {
                    queue.add(neighborName);
                    visited.add(neighborName);
                    System.out.println("    Enqueue " + neighborName
                            + " (unvisited neighbor of " + current + ")");
                } else {
                    System.out.println("    " + neighborName
                            + " already visited, skip");
                }
            }
            step++;
            System.out.println();
        }

        System.out.println("BFS Traversal Order: " + String.join(" → ", traversalOrder));
        System.out.println("========================================\n");
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  Task 2: Search & Traversal (DFS and BFS)");
        System.out.println("==============================================\n");

        Task2_SearchTraversal graph = new Task2_SearchTraversal();
        graph.add_vertex("A");
        graph.add_vertex("B");
        graph.add_vertex("C");
        graph.add_vertex("D");
        graph.add_vertex("E");

        graph.add_edge("B", "A", 2);
        graph.add_edge("C", "B", 11);
        graph.add_edge("D", "C", 6);
        graph.add_edge("E", "B", 14);
        graph.add_edge("B", "D", 12);
        graph.add_edge("E", "A", 8);
        graph.add_edge("C", "E", 7);

        graph.dfs("A");

        graph.bfs("A");
    }
}
