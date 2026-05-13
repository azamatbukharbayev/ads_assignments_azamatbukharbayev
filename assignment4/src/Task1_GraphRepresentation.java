import java.util.*;;

public class Task1_GraphRepresentation {
    private Map<String, List<String[]>> adjacencyList;

    public Task1_GraphRepresentation() {
        adjacencyList = new LinkedHashMap<>();
    }

    public void add_vertex(String v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
            System.out.println("  Added vertex: " + v);
        } else {
            System.out.println("  Vertex " + v + " already exists, skipping.");
        }
    }

    public void add_edge(String u, String v, int weight) {
        if (!adjacencyList.containsKey(u)) {
            adjacencyList.put(u, new ArrayList<>());
        }
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }

        adjacencyList.get(u).add(new String[]{v, String.valueOf(weight)});

        adjacencyList.get(v).add(new String[]{u, String.valueOf(weight)});

        System.out.println("  Added edge: " + u + " —(" + weight + ")— " + v
                + "  (added to both " + u + "'s and " + v + "'s lists)");
    }

    public void printGraph() {
        System.out.println("\n========================================");
        System.out.println("       ADJACENCY LIST REPRESENTATION");
        System.out.println("========================================");

        for (Map.Entry<String, List<String[]>> entry : adjacencyList.entrySet()) {
            String vertex = entry.getKey();
            List<String[]> neighbors = entry.getValue();

            System.out.print(vertex + " -> [");

            for (int i = 0; i < neighbors.size(); i++) {
                String neighborName = neighbors.get(i)[0];
                String neighborWeight = neighbors.get(i)[1];

                System.out.print("(" + neighborName + ", " + neighborWeight + ")");

                if (i < neighbors.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println("========================================\n");
    }

    public Map<String, List<String[]>> getAdjacencyList() {
        return adjacencyList;
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  Task 1: Graph Representation (Adjacency List)");
        System.out.println("==============================================\n");

        Task1_GraphRepresentation graph = new Task1_GraphRepresentation();

        System.out.println("--- Adding Vertices ---");
        graph.add_vertex("A");
        graph.add_vertex("B");
        graph.add_vertex("C");
        graph.add_vertex("D");
        graph.add_vertex("E");

        System.out.println("\n--- Adding Edges ---");

        graph.add_edge("B", "A", 2);

        graph.add_edge("C", "B", 11);

        graph.add_edge("D", "C", 6);

        graph.add_edge("E", "B", 14);

        graph.add_edge("B", "D", 12);

        graph.add_edge("E", "A", 8);

        graph.add_edge("C", "E", 7);

        graph.printGraph();

    }
}
